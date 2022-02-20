package com.ctm.insurance.config;

import com.ctm.insurance.model.*;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value("${kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${kafka.consumer.group-id}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, UserDetails> consumerFactoryUserDetails() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
                new JsonDeserializer<>(UserDetails.class));
    }



    @Bean("userDetailsKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, UserDetails> userDetailsKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UserDetails>
                factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryUserDetails());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, AddressDetails> consumerFactoryAddressDetails() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
                new JsonDeserializer<>(AddressDetails.class));
    }
   @Bean("addressDetailsKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, AddressDetails> addressDetailsKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, AddressDetails>
                factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryAddressDetails());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, UserPolicies> consumerFactoryUserPolicies() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
                new JsonDeserializer<>(UserPolicies.class));
    }
    @Bean("userPoliciesKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, UserPolicies> userPoliciesKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UserPolicies>
                factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryUserPolicies());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, RefPolicyTypes> consumerFactoryRefPolicyTypes() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
                new JsonDeserializer<>(RefPolicyTypes.class));
    }
    @Bean("refPolicyTypesKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, RefPolicyTypes> refPolicyTypesKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, RefPolicyTypes>
                factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryRefPolicyTypes());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, PolicySubTypes> consumerFactoryPolicySubTypes() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
                new JsonDeserializer<>(PolicySubTypes.class));
    }
    @Bean("policySubTypesKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, PolicySubTypes> policySubTypesKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, PolicySubTypes>
                factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryPolicySubTypes());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, PolicyPayments> consumerFactoryPolicyPayments() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
                new JsonDeserializer<>(PolicyPayments.class));
    }
    @Bean("policyPaymentsKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, PolicyPayments> policyPaymentsKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, PolicyPayments>
                factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryPolicyPayments());
        return factory;
    }

}