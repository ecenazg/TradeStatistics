package io.smartpulse.internship.controller;

import io.smartpulse.internship.common.Connection;
import io.smartpulse.internship.common.DateValidator;
import io.smartpulse.internship.common.DateValidatorUsingDateTimeFormatter;
import io.smartpulse.internship.entity.Contract;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Parsing remote file
 */
public class JsonParser {

    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZZZ");
    private static DateValidator dateValidator = new DateValidatorUsingDateTimeFormatter(dateFormatter);

    static Logger logger = Logger.getLogger(Connection.class.getName());
    public List<Contract> parse(String contractsStartWith, HttpURLConnection conn) throws IOException, ParseException {
        if(Objects.isNull(contractsStartWith))
            contractsStartWith = "";
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(conn.getInputStream()));
        JSONObject body = (JSONObject) jsonObject.get("body");
        return parseIntraDayTradeHistory(body, contractsStartWith);
    }

    private List<Contract> parseIntraDayTradeHistory (JSONObject body, String contractsStartWith) {
        JSONArray intraDayTradeHistoryList = (JSONArray) body.get("intraDayTradeHistoryList");

        List<Contract> validContracts = new ArrayList<>();
        for (int i = 0; i < intraDayTradeHistoryList.size(); i++) {
            JSONObject contract = (JSONObject) intraDayTradeHistoryList.get(i);
            String contractCode = (String)contract.get("conract");
            if(contractCode.startsWith(contractsStartWith)) {

                String idCandidate = ""+contract.get("id");
                String priceCandidate = ""+contract.get("price");
                String quantityCandidate = ""+contract.get("quantity");
                String dateCandidate = ""+contract.get("date");

                try {
                    Long id = Long.parseLong(idCandidate);
                    double price = Double.parseDouble(priceCandidate);
                    int quantity = Integer.parseInt(quantityCandidate);
                    validContracts.add(new Contract(contractCode, price, quantity));
                } catch (NumberFormatException nfe) {
                    logger.log(Level.WARNING, "Number parse exception for TradeHistory: { contractCode: " +
                        contractCode +  ", id: " + idCandidate + ", price: " + priceCandidate + ", quantity: " +
                        quantityCandidate +", date: " + dateCandidate +" }");
                }

                if(!dateValidator.isValid(dateCandidate)) {
                    logger.log(Level.WARNING, "Date parse exception for TradeHistory: { contractCode: " +
                        contractCode +  ", id: " + idCandidate + ", price: " + priceCandidate + ", quantity: " +
                        quantityCandidate +", date: " + dateCandidate +" }");
                }
            }
        }
        return validContracts;
    }
}
