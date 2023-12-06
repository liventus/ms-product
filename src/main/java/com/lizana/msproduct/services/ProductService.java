package com.lizana.msproduct.services;


import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.dto.Status;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Maybe<ProductDto> saveProduct(ProductDto ProductObject);

    Mono<ResponseEntity<Status>> deleteProduct(String tipoDeDocumento, String numeroDeDocumento, ServerWebExchange exchange);

    Mono<ResponseEntity<ProductDto>> getProduct(String tipoDeDocumento, String numeroDeDocumento, ServerWebExchange exchange);


    Mono<ResponseEntity<ProductDto>> updateProduct(Mono<ProductDto> ProductObject, ServerWebExchange exchange);

    Mono<ResponseEntity<Flux<ProductDto>>> getProductAll(ServerWebExchange exchange);




}
