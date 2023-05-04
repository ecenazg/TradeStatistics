package io.smartpulse.internship.controller;

import io.smartpulse.internship.entity.Contract;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MockValues {
    public static List<Contract> createDummyContractList() {
        List<Contract> retList = new ArrayList<>();
        Contract c1 = new Contract("PH22012603", 100.0, 8);
        Contract c2 = new Contract("PH22012603", 90.0, 5);
        Contract c3 = new Contract("PH22012604", 120, 6);
        retList.add(c1);
        retList.add(c2);
        retList.add(c3);
        return retList;
    }

    public static Map<LocalDateTime, Double> createDummyAmountMap() {
        Map<LocalDateTime, Double> retMap = new TreeMap<>();
        retMap.put(LocalDateTime.of(2022,1,26,3,0), 125.0);
        retMap.put(LocalDateTime.of(2022,1,26,4,0), 72.0);
        return retMap;
    }

    public static Map<LocalDateTime, Double> createDummyQuantityMap() {
        Map<LocalDateTime, Double> retMap = new TreeMap<>();
        retMap.put(LocalDateTime.of(2022,1,26,3,0), 1.3);
        retMap.put(LocalDateTime.of(2022,1,26,4,0), 0.6);
        return retMap;
    }
}
