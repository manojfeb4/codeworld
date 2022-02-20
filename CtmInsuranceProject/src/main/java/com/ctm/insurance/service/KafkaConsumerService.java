package com.ctm.insurance.service;


import com.ctm.insurance.model.*;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.*;
import java.nio.file.Paths;


@Service
public class KafkaConsumerService {

    @Autowired
    AmazonS3Service s3 ;

    @Value("${insurance.config.dirPath}/${insurance.config.userDetailsFile}.csv")
    String userDetailsFile;

    @Value("${insurance.config.dirPath}/${insurance.config.addressDetailsFile}.csv")
    String addressDetailsFile;

    @Value("${insurance.config.dirPath}/${insurance.config.userPoliciesFile}.csv")
    String userPoliciesFile;

    @Value("${insurance.config.dirPath}/${insurance.config.refPolicyTypesFile}.csv")
    String refPolicyTypesFile;

    @Value("${insurance.config.dirPath}/${insurance.config.policySubTypesFile}.csv")
    String policySubTypesFile;

    @Value("${insurance.config.dirPath}/${insurance.config.policyPaymentsFile}.csv")
    String policyPaymentsFile;

   @KafkaListener(topics = "${kafka.consumer.userDetailsTopic}", groupId = "${kafka.consumer.group-id}",
   containerFactory = "userDetailsKafkaListenerContainerFactory")
    public void readUserDetails(UserDetails userDetails) throws IOException {
       CsvMapper mapper = new CsvMapper();
       mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
       File csvOutputFile = new File( Paths.get(userDetailsFile).toUri());
       var csvSchema = mapper.schemaFor(UserDetails.class).withColumnSeparator('|');
       ObjectWriter writer = mapper.writer(csvSchema);
       OutputStream outstream = new FileOutputStream(csvOutputFile , true);
        writer.writeValue(outstream, userDetails);
     }

    @KafkaListener(topics = "${kafka.consumer.addressDetailsTopic}", groupId = "${kafka.consumer.group-id}",
            containerFactory = "addressDetailsKafkaListenerContainerFactory")
    public void readAddressDetails(AddressDetails addressDetails) throws IOException {
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        File csvOutputFile = new File( Paths.get(addressDetailsFile).toUri());
        var csvSchema = mapper.schemaFor(AddressDetails.class).withColumnSeparator('|');
        ObjectWriter writer = mapper.writer(csvSchema);
        OutputStream outstream = new FileOutputStream(csvOutputFile , true);
        writer.writeValue(outstream, addressDetails);

    }

    @KafkaListener(topics = "${kafka.consumer.userPoliciesTopic}", groupId = "${kafka.consumer.group-id}",
            containerFactory = "userPoliciesKafkaListenerContainerFactory")
    public void readUserPolicies(UserPolicies userPolicies) throws  IOException {
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        File csvOutputFile = new File( Paths.get(userPoliciesFile).toUri());
        var csvSchema = mapper.schemaFor(UserPolicies.class).withColumnSeparator('|');
        ObjectWriter writer = mapper.writer(csvSchema);
        OutputStream outstream = new FileOutputStream(csvOutputFile , true);
        writer.writeValue(outstream, userPolicies);
    }

    @KafkaListener(topics = "${kafka.consumer.refPolicyTypesTopic}", groupId = "${kafka.consumer.group-id}",
            containerFactory = "refPolicyTypesKafkaListenerContainerFactory")
    public void readRefPolicyTypes(RefPolicyTypes refPolicyTypes) throws  IOException {
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        File csvOutputFile = new File( Paths.get(refPolicyTypesFile).toUri());
        var csvSchema = mapper.schemaFor(RefPolicyTypes.class).withColumnSeparator('|');
        ObjectWriter writer = mapper.writer(csvSchema);
        OutputStream outstream = new FileOutputStream(csvOutputFile , true);
        writer.writeValue(outstream, refPolicyTypes);
    }

    @KafkaListener(topics = "${kafka.consumer.policySubTypesTopic}", groupId = "${kafka.consumer.group-id}",
            containerFactory = "policySubTypesKafkaListenerContainerFactory")
    public void readPolicySubTypes(PolicySubTypes policySubTypes) throws  IOException {
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        File csvOutputFile = new File( Paths.get(policySubTypesFile).toUri());
        var csvSchema = mapper.schemaFor(PolicySubTypes.class).withColumnSeparator('|');
        ObjectWriter writer = mapper.writer(csvSchema);
        OutputStream outstream = new FileOutputStream(csvOutputFile , true);
        writer.writeValue(outstream, policySubTypes);
    }

    @KafkaListener(topics = "${kafka.consumer.policyPaymentsTopic}", groupId = "${kafka.consumer.group-id}",
            containerFactory = "policyPaymentsKafkaListenerContainerFactory")
    public void readPolicyPayments(PolicyPayments policyPayments) throws  IOException {
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        File csvOutputFile = new File( Paths.get(policyPaymentsFile).toUri());
        var csvSchema = mapper.schemaFor(PolicyPayments.class).withColumnSeparator('|');
        ObjectWriter writer = mapper.writer(csvSchema);
        OutputStream outstream = new FileOutputStream(csvOutputFile , true);
        writer.writeValue(outstream, policyPayments);
    }

}
