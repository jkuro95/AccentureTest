package com.test.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Product {
    Long id;
    String name;
    int price;

}
