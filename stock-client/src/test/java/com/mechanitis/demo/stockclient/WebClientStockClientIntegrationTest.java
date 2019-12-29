package com.mechanitis.demo.stockclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

//https://blog.jetbrains.com/idea/2019/11/tutorial-reactive-spring-boot-a-rest-client-for-reactive-streams/
class WebClientStockClientIntegrationTest {

//    use a WebClient to connect to the service.
    private WebClient webClient = WebClient.builder().build();

    @Test
    void shouldRetrieveStockPricesFromTheService() {
        // given
        WebClientStockClient webClientStockClient = new WebClientStockClient(webClient);

//        takes a String that represents the symbol of the stock we want the prices for
        // when
        Flux<StockPrice> prices = webClientStockClient.pricesFor("SYMBOL");

        // then
        Assertions.assertNotNull(prices);
        Flux<StockPrice> fivePrices = prices.take(5);
        Assertions.assertEquals(5, fivePrices.count().block());
        Assertions.assertEquals("SYMBOL", fivePrices.blockFirst().getSymbol());
    }
}