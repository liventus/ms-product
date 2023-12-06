package com.lizana.msproduct.services.impl;

import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.dto.Status;
import com.lizana.msproduct.model.entity.ProductEntity;
import com.lizana.msproduct.repository.ProductRepository;
import com.lizana.msproduct.services.ProductService;
import com.lizana.msproduct.util.ProductUtil;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        //guarda el producto
        Mono<ProductEntity> savedEntity = productRepository.save(ProductUtil.dtoToEntity(productDto));
        return Maybe.fromPublisher(savedEntity.map(ProductUtil::entityToDto));
    }

    @Override
    public Maybe<Status> deleteProduct(String idProduct) {
        return Maybe.fromPublisher(
                productRepository.findById(idProduct)
                        .flatMap(product -> {
                            if (product != null) {
                                return productRepository.deleteById(product.getId())
                                        .then(Mono.just(new Status("asd", "a")));
                            } else {
                                return Mono.empty();
                            }
                        })
                        .switchIfEmpty(Mono.just(new Status("NOT_FOUND", "Product not found")))
        );

    }

    @Override
    public Maybe<ProductDto> getProduct(String idProduct) {
        //extrae el producto
        Mono<ProductEntity> para = productRepository.findById(idProduct);
        return Maybe.fromPublisher(para.map(ProductUtil::entityToDto));
    }

    @Override
    public Maybe<ProductDto> updateProduct(ProductDto ProductObject) {
        Mono<ProductEntity> updateEntity = productRepository.save(ProductUtil.dtoToEntity(ProductObject));
        return Maybe.fromPublisher(updateEntity.map(ProductUtil::entityToDto));
    }

    @Override
    public Flowable<ProductDto> getProductAll() {
        return Flowable
                .fromPublisher(productRepository.findAll().map(ProductUtil::entityToDto));
    }


}
