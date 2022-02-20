package com.ctm.insurance.service;

import com.ctm.insurance.model.*;
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

    @Autowired
    private KafkaTemplate<String, PolicySubTypes> kafkaTemplatePolicySubTypes;

    @Autowired
    private KafkaTemplate<String, RefPolicyTypes> kafkaTemplateRefPolicyTypes;

    @Autowired
    private KafkaTemplate<String, PolicyPayments> kafkaTemplatePolicyPayments;

    @Value("${kafka.producer.userDetailsTopic}")
    String kafkaTopicUserDetails;

    @Value("${kafka.producer.addressDetailsTopic}")
    String kafkaTopicAddressDetails;

    @Value("${kafka.producer.userPoliciesTopic}")
    String kafkaTopicUserPolicies;

    @Value("${kafka.producer.policySubTypesTopic}")
    String kafkaTopicPolicySubTypes;

    @Value("${kafka.producer.refPolicyTypesTopic}")
    String kafkaTopicRefPolicyTypes;

    @Value("${kafka.producer.policyPaymentsTopic}")
    String kafkaTopicPolicyPayments;

    public void send(UserDetails userDetails){
        log.info("Sending user Json serializer : {}", userDetails);
        kafkaTemplateUserDetails.send(kafkaTopicUserDetails, userDetails);
    }


   public void send(AddressDetails addressDetails){
        log.info("Sending address detail Json serializer : {}", addressDetails);
        kafkaTemplateAddressDetails.send(kafkaTopicAddressDetails, addressDetails);
    }


    public void send(UserPolicies userPolicies){
        log.info("Sending user policies Json serializer : {}", userPolicies);
        kafkaTemplateUserPolicies.send(kafkaTopicUserPolicies, userPolicies);
    }

    public void send(RefPolicyTypes refPolicyTypes){
        log.info("Sending ref policy type Json serializer : {}", refPolicyTypes);
        kafkaTemplateRefPolicyTypes.send(kafkaTopicRefPolicyTypes, refPolicyTypes);
    }

    public void send(PolicySubTypes policySubTypes){
        log.info("Sending policy sub type Json serializer : {}", policySubTypes);
        kafkaTemplatePolicySubTypes.send(kafkaTopicPolicySubTypes, policySubTypes);
    }

    public void send(PolicyPayments policyPayments){
        log.info("Sending policy payment Json serializer : {}", policyPayments);
        kafkaTemplatePolicyPayments.send(kafkaTopicPolicyPayments, policyPayments);
    }


}
