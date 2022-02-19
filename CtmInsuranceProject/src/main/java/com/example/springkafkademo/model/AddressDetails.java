package com.example.springkafkademo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddressDetails {

    @JsonProperty("address_id")
    private String addressId;

    @JsonProperty("h_no")
    private String hNo;

    @JsonProperty("city")
    private String city;

    @JsonProperty("addressline1")
    private String addressLine1;

    @JsonProperty("state")
    private String state;

    @JsonProperty("pin")
    private String pin;

}
