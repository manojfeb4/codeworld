package com.example.springkafkademo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
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
