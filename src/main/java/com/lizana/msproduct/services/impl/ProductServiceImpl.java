package com.lizana.msproduct.services.impl;

import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.dto.StatusResponse;
import com.lizana.msproduct.model.entity.ProductEntity;
import com.lizana.msproduct.repository.ProductRepository;
import com.lizana.msproduct.services.ProductService;
import com.lizana.msproduct.util.ProductUtil;
import com.lizana.msproduct.util.ProductValidator;
import com.lizana.msproduct.util.ValidatorException;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Maybe<StatusResponse> saveProduct(ProductDto productDto) {
        try {
            ProductValidator.validateClientObject(productDto);
        } catch (ValidatorException ex) {
            return Maybe.just(ex.getStatusResponse());
        }
        return Maybe
                .fromPublisher(
                        productRepository.save(ProductUtil.dtoToEntity(productDto))
                                .map(ProductUtil::entityToDto)
                                .map(x -> ProductUtil.setStatusResponse(HttpStatus.CREATED, x)));

    }

    @Override
    public Maybe<StatusResponse> deleteProduct(String idProduct) {
        return Maybe.fromPublisher(
                productRepository.findById(idProduct)
                        .flatMap(product -> {
                            if (product != null) {
                                return productRepository.deleteById(product.getIdDeProducto())
                                        .then(Mono.just(new StatusResponse(13, "a", null)));
                            } else {
                                return Mono.empty();
                            }
                        })
                        .switchIfEmpty(Mono.just(new StatusResponse(123, "Product not found", null)))
        );

    }

    @Override
    public Maybe<StatusResponse> getProduct(String idProduct) {
        //extrae el producto

        return Maybe.fromPublisher(productRepository.findById(idProduct)
                .map(ProductUtil::entityToDto)
                .map(x -> ProductUtil.setStatusResponse(HttpStatus.OK, x)));
    }

    @Override
    public Maybe<StatusResponse> updateProduct(ProductDto ProductObject) {

        return Maybe.fromPublisher(productRepository.save(ProductUtil.dtoToEntity(ProductObject))
                .map(ProductUtil::entityToDto)
                .map(x -> ProductUtil.setStatusResponse(HttpStatus.OK, x)));
    }

    @Override
    public Flowable<ProductDto> getProductAll() {
        return Flowable
                .fromPublisher(productRepository.findAll().map(ProductUtil::entityToDto));
    }


}
