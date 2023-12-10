package com.lizana.msproduct.util;


import com.lizana.msproduct.model.dto.ProductDto;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@NoArgsConstructor
public class ProductValidator {

    public static void validateClientObject(ProductDto dto) {

        if (dto.getIdDeProducto().isEmpty() || dto.getIdDeProducto().isBlank()) {
            throw new ValidatorException(HttpStatus.BAD_REQUEST.value(), "id de producto no puede ser vacio ", dto);
        }
    }
}
