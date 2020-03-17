package com.feign.feigndemo.controllers;

import com.feign.feigndemo.entity.Person;
import com.feign.feigndemo.feign.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name = "person-service", url = "http://localhost:8080/api1", configuration = FeignConfig.class)
public interface PersonServiceClient {

    @GetMapping(value = "/people")
    public List<Person> getAllPeople();
}
