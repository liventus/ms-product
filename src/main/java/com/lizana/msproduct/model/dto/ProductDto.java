package com.lizana.msproduct.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String id;
    private String idDeProducto;
    private Number comision;
    private String tipoDeCuenta;
    private String claseDeCuenta;
    private Number limitMaxDepositoMensual;
    private Number limitMaxRetiroMensual;
    private Number limitMaxPagoMensual;
    private Number limitMaxCredito;



}
