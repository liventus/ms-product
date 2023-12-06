package com.lizana.msproduct.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    @JsonProperty("code")
    private String code;
    @JsonProperty("description")
    private String description;

}


