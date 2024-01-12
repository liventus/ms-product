package com.lizana.msproduct.util;



import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.dto.StatusResponse;
import com.lizana.msproduct.model.entity.ProductEntity;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@NoArgsConstructor
public class ProductUtil {



    public  static StatusResponse setStatusResponse(HttpStatus http, ProductDto dto){
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setCode(http.value());
        statusResponse.setDescription(http.name());
        statusResponse.setDetail(dto);


        return statusResponse;
    }
}
