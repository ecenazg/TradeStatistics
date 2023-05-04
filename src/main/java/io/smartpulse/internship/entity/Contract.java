package io.smartpulse.internship.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contract {
    private String contractCode;
    private double price;
    private long quantity;
}
