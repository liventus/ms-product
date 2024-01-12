package com.lizana.msproduct.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {

    private String id;
    @NotBlank
    private String idDeProducto;
    @NotNull
    @Min(1)
    private Number comision;
    @Pattern(regexp = "^(016|017|022|025)$")
    private String tipoDeCuenta;
    private String claseDeCuenta;
    private Number limitMaxDepositoMensual;
    private Number limitMaxRetiroMensual;
    private Number limitMaxPagoMensual;
    private Number limitMaxCredito;



}
