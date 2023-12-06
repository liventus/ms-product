package com.lizana.msproduct.services.impl;

import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.dto.Status;
import com.lizana.msproduct.model.entity.ProductEntity;
import com.lizana.msproduct.repository.ProductRepository;
import com.lizana.msproduct.services.ProductService;
import com.lizana.msproduct.util.ProductUtil;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Maybe<ProductDto> saveProduct(ProductDto productDto) {
        Mono<ProductEntity> savedEntity = productRepository.save(ProductUtil.dtoToEntity(productDto));
        return Maybe.fromPublisher(savedEntity.map(ProductUtil::entityToDto));
    }

    @Override
    public Mono<ResponseEntity<Status>> deleteProduct(String tipoDeDocumento, String numeroDeDocumento, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<ProductDto>> getProduct(String tipoDeDocumento, String numeroDeDocumento, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<ProductDto>> updateProduct(Mono<ProductDto> ProductObject, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Flux<ProductDto>>> getProductAll(ServerWebExchange exchange) {
        return null;
    }
}
