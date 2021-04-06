package com.test.test.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)

public class Invoice {
    String document;
    String address;
    double total;
    double iva;
    double totalWithIva;
    int deliveryPrice;
}
