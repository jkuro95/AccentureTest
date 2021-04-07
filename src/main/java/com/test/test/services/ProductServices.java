package com.test.test.services;

import com.test.test.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServices {

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        products.add(Product.builder()
                .id(1L).name("Galletas")
                .price(12000).build());

        products.add(Product.builder()
                .id(2L).name("Pan")
                .price(10000).build());

        products.add(Product.builder()
                .id(3L).name("Leche")
                .price(5000).build());

        products.add(Product.builder()
                .id(4L).name("Pechugas de pollo")
                .price(25000).build());

        products.add(Product.builder()
                .id(5L).name("Helado")
                .price(17000).build());

        products.add(Product.builder()
                .id(6L).name("Carne")
                .price(16000).build());

        products.add(Product.builder()
                .id(7L).name("Garrafa de ron")
                .price(78000).build());

        return products;
    }

    public int calculateTotal(List<Long> ids) {
        int total = 0;
        for (Long id : ids) {
            for(Product product : getAllProducts()){
                if (id.longValue() == product.getId().longValue()) {
                    total += product.getPrice();
                }
            }
        }
        return total;
    }

    public double calculateIva(int total){
        double iva;
        iva = total * 0.19;
        return iva;
    }

    public int priceDelivery(int total){
        if (total > 70000 && total <= 100000){
            return 5000;
        }
        return 0;
    }

}
