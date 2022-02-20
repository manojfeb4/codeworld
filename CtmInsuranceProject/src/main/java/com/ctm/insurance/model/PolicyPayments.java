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
public class PolicyPayments {

    @JsonProperty("receipno")
    private String receiptNum;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("policy_no")
    private String policyNum;

    @JsonProperty("dateofpayment")
    private String dateOfPayment;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("fine")
    private String fine;

}
