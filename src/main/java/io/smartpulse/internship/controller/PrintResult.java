package io.smartpulse.internship.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * Print results
 */
public class PrintResult {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy HH:mm");
    public void printCalculation(Map<LocalDateTime, Double> totalTradeAmounts, Map<LocalDateTime, Double> totalTradeQuantities) {
        // Print the calculated info
        System.out.println("     Contract    | Toplam İşlem Miktarı | Toplam İşlem Tutarı | Ağırlıklı Ortalama Fiyat");
        System.out.println("---------------- | -------------------- | ------------------- | ------------------------");
        for (LocalDateTime ldt : totalTradeAmounts.keySet()) {
            double totalTradeAmount = totalTradeAmounts.get(ldt);
            double totalTradeQuantity = totalTradeQuantities.get(ldt);
            double weightedAveragePrice = totalTradeAmount / totalTradeQuantity;

            System.out.printf("%16s | %19.2f | %19.2f | %26.2f\n", formatter.format(ldt), totalTradeQuantity, totalTradeAmount, weightedAveragePrice);
        }
    }
}
