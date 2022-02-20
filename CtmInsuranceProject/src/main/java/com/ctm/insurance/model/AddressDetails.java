package com.ctm.insurance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
