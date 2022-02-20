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
public class PolicySubTypes {

    @JsonProperty("policy_type_id")
    private String policyTypeId;

    @JsonProperty("policy_type_code")
    private String policyTypeCd;

    @JsonProperty("description")
    private String description;

    @JsonProperty("yearsofpayments")
    private String yearsOfPayments;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("maturityperiod")
    private String maturityPeriod;

    @JsonProperty("maturityAmount")
    private String maturityAmount;

    @JsonProperty("validity")
    private String validity;

}
