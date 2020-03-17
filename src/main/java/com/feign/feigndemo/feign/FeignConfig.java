package com.feign.feigndemo.feign;

import com.feign.feigndemo.controllers.PersonServiceClient;
import feign.Client;
import feign.Feign;
import feign.Retryer;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(FeignClientsConfiguration.class)
@Configuration
public class FeignConfig {

    @Value("${facility-api-url}")
    private String facilityApiUrl;

    @Value("${retry.period:1000}")
    private int period;

    @Value("${retry.maxPeriod:30000}")
    private int maxPeriod;

    @Value("${retry.maxAttempts:3}")
    private int maxAttempts;

    @Bean
    public PersonServiceClient personServiceClient(Client client){
        return Feign.builder()
                .client(client)
                .contract( new SpringMvcContract())
                .decode404()
                .retryer(new Retryer.Default(period,maxPeriod,maxAttempts))
                .target(PersonServiceClient.class, facilityApiUrl);
    }



}
