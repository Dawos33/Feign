package com.feign.feigndemo.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class AppController {

    private final PersonServiceClient personServiceClient;


    public AppController(PersonServiceClient personServiceClient) {
        this.personServiceClient = personServiceClient;
    }

    @GetMapping("/fetchPeople")
        public ResponseEntity < ? > fetchPeople(){
            return ResponseEntity.ok(personServiceClient.getAllPeople());
        }

}
