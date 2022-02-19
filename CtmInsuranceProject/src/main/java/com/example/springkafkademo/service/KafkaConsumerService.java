package com.example.springkafkademo.service;


import com.example.springkafkademo.model.AddressDetails;
import com.example.springkafkademo.model.UserDetails;
import com.example.springkafkademo.model.UserPolicies;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.*;
import java.nio.file.Paths;


@Service
public class KafkaConsumerService {

    @Autowired
    AmazonS3Service s3 ;


   @KafkaListener(topics = "${kafka.consumer.userDetailsTopic}", groupId = "${kafka.consumer.group-id}",
   containerFactory = "kafkaListenerContainerFactoryUserDetails")
    public void readUserDetails(UserDetails userDetails) throws IOException {
       CsvMapper mapper = new CsvMapper();
       mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
       File csvOutputFile = new File( Paths.get("src/main/resources/userDetails.csv").toUri());
       var csvSchema = mapper.schemaFor(UserDetails.class).withColumnSeparator('|');
       ObjectWriter writer = mapper.writer(csvSchema);
       OutputStream outstream = new FileOutputStream(csvOutputFile , true);
        writer.writeValue(outstream, userDetails);
     }

    @KafkaListener(topics = "${kafka.consumer.addressDetailsTopic}", groupId = "${kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactoryAddressDetails")
    public void readAddressDetails(AddressDetails addressDetails) throws IOException {
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        File csvOutputFile = new File( Paths.get("src/main/resources/addressDetails.csv").toUri());
        var csvSchema = mapper.schemaFor(AddressDetails.class).withColumnSeparator('|');
        ObjectWriter writer = mapper.writer(csvSchema);
        OutputStream outstream = new FileOutputStream(csvOutputFile , true);
        writer.writeValue(outstream, addressDetails);

    }

    @KafkaListener(topics = "${kafka.consumer.userPoliciesTopic}", groupId = "${kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactoryUserPolicies")
    public void readUserPolicies(UserPolicies userPolicies) throws  IOException {
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        File csvOutputFile = new File( Paths.get("src/main/resources/userPolicies.csv").toUri());
        var csvSchema = mapper.schemaFor(UserPolicies.class).withColumnSeparator('|');
        ObjectWriter writer = mapper.writer(csvSchema);
        OutputStream outstream = new FileOutputStream(csvOutputFile , true);
        writer.writeValue(outstream, userPolicies);
    }
}
