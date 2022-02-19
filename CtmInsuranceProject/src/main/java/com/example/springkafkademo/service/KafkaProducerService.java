package com.example.springkafkademo.service;

import com.example.springkafkademo.model.AddressDetails;
import com.example.springkafkademo.model.UserDetails;
import com.example.springkafkademo.model.UserPolicies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final Logger log = LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String, UserDetails> kafkaTemplateUserDetails;

    @Autowired
    private KafkaTemplate<String, AddressDetails> kafkaTemplateAddressDetails;

    @Autowired
    private KafkaTemplate<String, UserPolicies> kafkaTemplateUserPolicies;

    @Value("${kafka.producer.userDetailsTopic}")
    String kafkaTopicUserDetails;

    @Value("${kafka.producer.addressDetailsTopic}")
    String kafkaTopicAddressDetails;

    @Value("${kafka.producer.userPoliciesTopic}")
    String kafkaTopicUserPolicies;


    public void send(UserDetails userDetails){
        log.info("Sending user Json serializer : {}", userDetails);
        kafkaTemplateUserDetails.send(kafkaTopicUserDetails, userDetails);
    }


   public void send(AddressDetails addressDetails){
        log.info("Sending customer Json serializer : {}", addressDetails);
        kafkaTemplateAddressDetails.send(kafkaTopicAddressDetails, addressDetails);
    }


    public void send(UserPolicies userPolicies){
        log.info("Sending customer Json serializer : {}", userPolicies);
        kafkaTemplateUserPolicies.send(kafkaTopicUserPolicies, userPolicies);
    }
}
