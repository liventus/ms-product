package com.lizana.msproduct.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class ProductEntity {

    @Id
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
