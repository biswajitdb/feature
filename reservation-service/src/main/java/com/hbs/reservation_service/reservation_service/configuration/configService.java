package com.hbs.reservation_service.reservation_service.configuration;


import com.hbs.reservation_service.reservation_service.client.CustomerClient;
import com.hbs.reservation_service.reservation_service.client.Hotelclient;
import com.hbs.reservation_service.reservation_service.client.PaymentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class configService {


    @Autowired
    private LoadBalancedExchangeFilterFunction filterfunction;


    @Bean
    public WebClient guestWebClient() {
        return WebClient .builder().baseUrl("http://GUEST-SERVICE")
                .filter(filterfunction)
                .build();
    }
    @Bean
    public CustomerClient customerclient() {
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory .builderFor(WebClientAdapter.create(guestWebClient())).build();
        return httpServiceProxyFactory.createClient(CustomerClient.class);
    }
    @Bean
    public WebClient hotelWebClient() {
        return WebClient .builder().baseUrl("http://HOTEL-SERVICE")
                .filter(filterfunction)
                .build();
    }
    @Bean
    public Hotelclient hotelclient() {
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory .builderFor(WebClientAdapter.create(hotelWebClient())).build();
        return httpServiceProxyFactory.createClient(Hotelclient.class);
    }

    @Bean
    public WebClient paymentWebClient() {
        return WebClient .builder().baseUrl("http://PAYMENT-SERVICE")
                .filter(filterfunction)
                .build();
    }
    @Bean
    public PaymentClient paymentclient() {
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory .builderFor(WebClientAdapter.create(paymentWebClient())).build();
        return httpServiceProxyFactory.createClient(PaymentClient.class);
    }

}
