package com.lizana.msproduct.model.entity;

import com.lizana.msproduct.model.dto.ProductTipoCuentDto;
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
    private String tipoDeProducto;
    private String nombreDeProducto;
    private ProductTipoCuentDto tipoDeCuenta;


}
