package io.smartpulse.internship;

import io.smartpulse.internship.controller.Calculation;
import io.smartpulse.internship.common.Connection;
import io.smartpulse.internship.controller.JsonParser;
import io.smartpulse.internship.controller.PrintResult;
import io.smartpulse.internship.entity.Contract;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.json.simple.parser.ParseException;

/**
 * Driver method
 *
 */
public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        //
        JsonParser jparser = new JsonParser();
        Calculation calculation = new Calculation();
        PrintResult printResult = new PrintResult();

        // Singleton connection
        HttpURLConnection conn = Connection.getConnection();

        // Get contracts with start PH. It is parametric. If send null value, list all contracts
        List<Contract> validContractList = jparser.parse("", conn);
        Map<LocalDateTime, Double> tradeAmounts = calculation.calculateTotalTradeAmounts(validContractList);
        Map<LocalDateTime, Double> tradeQuantities =  calculation.calculateTotalTradeQuantities(validContractList);

        printResult.printCalculation(tradeAmounts, tradeQuantities);

        // Close connection
        Connection.closeConnection();

    }
}