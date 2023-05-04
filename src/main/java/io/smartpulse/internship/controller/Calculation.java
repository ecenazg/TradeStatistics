package io.smartpulse.internship.controller;

import io.smartpulse.internship.entity.Contract;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Business related calculations
 * TreeMap is used for sorting based on LocalDateTime
 * Map structure is used for get better performance
 */
public class Calculation {
    public Map<LocalDateTime, Double> calculateTotalTradeAmounts(List<Contract> contractList) {
        Map<LocalDateTime, Double> totalTradeAmounts = new TreeMap<>();
        contractList.forEach(contract -> totalTradeAmounts.put(convertContractDate(contract.getContractCode()),
            totalTradeAmounts.getOrDefault(convertContractDate(contract.getContractCode()), 0.0) +
                (contract.getPrice()*contract.getQuantity())/10));
        return totalTradeAmounts;
    }

    public Map<LocalDateTime, Double> calculateTotalTradeQuantities(List<Contract> contractList) {
        Map<LocalDateTime, Double> totalTradeQuantities = new TreeMap<>();
        contractList.forEach(contract -> totalTradeQuantities.put(convertContractDate(contract.getContractCode()),
            totalTradeQuantities.getOrDefault(convertContractDate(contract.getContractCode()), 0.0) +
                contract.getQuantity()/10.0));
        return totalTradeQuantities;
    }

    private LocalDateTime convertContractDate(String contractCode) {
        String dateStr = contractCode.substring(2,10);
        int year = Integer.parseInt("20" + dateStr.substring(0,2));
        int month = Integer.parseInt(dateStr.substring(2,4));
        int day = Integer.parseInt(dateStr.substring(4,6));
        int hour = Integer.parseInt(dateStr.substring(6,8));
        LocalDateTime convertedDate = LocalDateTime.of(year,month,day,hour,0);
        return convertedDate;
    }

}
