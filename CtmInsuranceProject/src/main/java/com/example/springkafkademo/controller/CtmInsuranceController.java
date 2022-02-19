package com.example.springkafkademo.controller;

import com.example.springkafkademo.model.AddressDetails;
import com.example.springkafkademo.model.UserDetails;
import com.example.springkafkademo.model.UserPolicies;
import com.example.springkafkademo.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class CtmInsuranceController {
    private final Logger log = LoggerFactory.getLogger(CtmInsuranceController.class);

    @Autowired
    KafkaProducerService kafkaProducer;

    @PostMapping("/userdetails")
    public ResponseEntity<UserDetails> createUserDetails(@RequestBody UserDetails userDetails){
        kafkaProducer.send(userDetails);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put("statusUserDetails", List.of("User Details Created"));
        return new ResponseEntity<>(userDetails, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/addressdetails")
    public ResponseEntity<AddressDetails> createAddressDetails(@RequestBody AddressDetails addressDetails){
        kafkaProducer.send(addressDetails);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put("statusAddressDetails", List.of("Address Details created"));
        return new ResponseEntity<>(addressDetails, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/userpolicies")
    public ResponseEntity<UserPolicies> createUserPolicies(@RequestBody UserPolicies userPolicies){
        kafkaProducer.send(userPolicies);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put("statusUserPolicies", List.of("User Policy created"));
        return new ResponseEntity<>(userPolicies, httpHeaders, HttpStatus.OK);
    }


}
