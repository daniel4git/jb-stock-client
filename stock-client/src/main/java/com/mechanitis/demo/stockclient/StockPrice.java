package com.mechanitis.demo.stockclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Using Lombok’s @Data annotation, we can create a data class similar to our Kotlin data class
 *
 * Add an @AllArgsConstructor and a @NoArgsConstructor via Lombok,
 * these are needed for our code and for JSON serialisation.
 *
 *
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockPrice {
    private String symbol;
    private Double price;
    private LocalDateTime time;
}
