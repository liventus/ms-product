package com.lizana.msproduct.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTipoCuentDto {

    private String code;
    @JsonProperty("comision")
    private String comision;



}
