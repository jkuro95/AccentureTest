package com.test.test.controller;

import com.test.test.model.Invoice;
import com.test.test.model.Product;
import com.test.test.model.RequestSell;
import com.test.test.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductServices productServices;
    private Product product;

    @PostMapping("/sell")
    public Invoice sell(@RequestBody RequestSell requestSell){
        int total = productServices.calculateTotal(requestSell.getIdProduct());
        if(total < 70000){
            return Invoice.builder()
                    .address("null")
                    .document("Imposible realizar venta, la suma de los productos tiene que ser mayor a $70000")
                    .iva(0)
                    .total(total)
                    .totalWithIva(0)
                    .deliveryPrice(0)
                    .build();
        }


        return Invoice.builder()
                .address(requestSell.getAddress())
                .document(requestSell.getDocument())
                .iva(productServices.calculateIva(total))
                .total(total)
                .totalWithIva(productServices.calculateIva(total)+total)
                .deliveryPrice(productServices.priceDelivery(total))
                .build();
    }


}
