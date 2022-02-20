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
public class UserPolicies {

    @JsonProperty("policy_no")
    private String policyNum;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("date_registered")
    private String dateRegistered;

    @JsonProperty("policy_type_id")
    private String policyTypeId;
}
