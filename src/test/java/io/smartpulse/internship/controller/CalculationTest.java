package io.smartpulse.internship.controller;

import static org.mockito.ArgumentMatchers.any;

import io.smartpulse.internship.entity.Contract;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculationTest {

    @InjectMocks
    Calculation calculation;
    @Test
    void calculateTotalTradeAmountsTest() {
        Map<LocalDateTime, Double> expectedMap = MockValues.createDummyAmountMap();
        List<Contract> dummyList = MockValues.createDummyContractList();
        Map<LocalDateTime, Double> returnMap = calculation.calculateTotalTradeAmounts(dummyList);
        Assertions.assertEquals(expectedMap, returnMap);
    }

    @Test
    void calculateTotalTradeQuantitiesTest() {
        Map<LocalDateTime, Double> expectedMap = MockValues.createDummyQuantityMap();
        List<Contract> dummyList = MockValues.createDummyContractList();
        Map<LocalDateTime, Double> returnMap = calculation.calculateTotalTradeQuantities(dummyList);
        Assertions.assertEquals(expectedMap, returnMap);
    }
}
