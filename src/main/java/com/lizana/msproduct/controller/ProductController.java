package com.lizana.msproduct.controller;


import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.dto.StatusResponse;
import com.lizana.msproduct.services.ProductService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ProductController.PRODUCT)
public class ProductController {
    public static final String PRODUCT = "/product";

    @Autowired
    ProductService productService;

    @PostMapping(produces = {"application/json"})
    public Maybe<StatusResponse> create(@RequestBody ProductDto product) {
        return productService.saveProduct(product);
    }



    @GetMapping
    public Maybe<StatusResponse> buscarPor(@RequestHeader String productId) {
        return productService.getProduct(productId);
    }


    @PutMapping
    public Maybe<StatusResponse> update(@RequestBody ProductDto product) {
        return productService.updateProduct(product);
    }


    @DeleteMapping
    public Maybe<StatusResponse> delete(@RequestHeader String productId) {
        return productService.deleteProduct(productId);
    }








}
