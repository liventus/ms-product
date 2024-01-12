package com.lizana.msproduct.services;


import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.dto.StatusResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ProductService {

    Mono<StatusResponse> create(ProductDto ProductObject);

    Mono<StatusResponse> delete(String idProducto);

    Mono<StatusResponse> findById(String idProduct);


    Mono<StatusResponse> update(ProductDto ProductObject);

    Flux<ProductDto> findAll();




}
