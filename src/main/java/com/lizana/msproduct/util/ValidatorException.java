package com.lizana.msproduct.util;


import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.dto.StatusResponse;


public class ValidatorException extends RuntimeException {


    private StatusResponse statusResponse;

    public ValidatorException(int codigo, String descripcion, ProductDto clientObject) {

        this.statusResponse = new StatusResponse();
        this.statusResponse.setCode(codigo);
        this.statusResponse.setDescription(descripcion);
        this.statusResponse.setDetail(clientObject);
    }

    public StatusResponse getStatusResponse() {
        return statusResponse;
    }
}
