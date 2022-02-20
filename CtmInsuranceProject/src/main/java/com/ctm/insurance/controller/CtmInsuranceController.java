package com.ctm.insurance.controller;

import com.ctm.insurance.model.*;
import com.ctm.insurance.service.KafkaProducerService;
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
        return new ResponseEntity<>(userDetails, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/addressdetails")
    public ResponseEntity<AddressDetails> createAddressDetails(@RequestBody AddressDetails addressDetails){
        kafkaProducer.send(addressDetails);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(addressDetails, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/userpolicies")
    public ResponseEntity<UserPolicies> createUserPolicies(@RequestBody UserPolicies userPolicies){
        kafkaProducer.send(userPolicies);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(userPolicies, httpHeaders, HttpStatus.OK);
    }


    @PostMapping("/refpolicytypes")
    public ResponseEntity<RefPolicyTypes> createRefPolicyTypes(@RequestBody RefPolicyTypes refPolicyTypes){
        kafkaProducer.send(refPolicyTypes);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(refPolicyTypes, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/policysubtypes")
    public ResponseEntity<PolicySubTypes> createPolicySubTypes(@RequestBody PolicySubTypes policySubTypes){
        kafkaProducer.send(policySubTypes);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(policySubTypes, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/policypayments")
    public ResponseEntity<PolicyPayments> createPolicyPayments(@RequestBody PolicyPayments policyPayments){
        kafkaProducer.send(policyPayments);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(policyPayments, httpHeaders, HttpStatus.OK);
    }

}
