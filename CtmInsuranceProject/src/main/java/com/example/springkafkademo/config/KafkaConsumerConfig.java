package com.example.springkafkademo.config;

import com.example.springkafkademo.model.AddressDetails;
import com.example.springkafkademo.model.UserDetails;
import com.example.springkafkademo.model.UserPolicies;
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



    @Bean("kafkaListenerContainerFactoryUserDetails")
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
   @Bean("kafkaListenerContainerFactoryAddressDetails")
    public ConcurrentKafkaListenerContainerFactory<String, AddressDetails> kafkaListenerContainerFactoryAddressDetails() {
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
    @Bean("kafkaListenerContainerFactoryUserPolicies")
    public ConcurrentKafkaListenerContainerFactory<String, UserPolicies> kafkaListenerContainerFactoryUserPolicies() {
        ConcurrentKafkaListenerContainerFactory<String, UserPolicies>
                factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryUserPolicies());
        return factory;
    }
}