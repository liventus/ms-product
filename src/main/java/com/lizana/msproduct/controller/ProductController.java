package com.lizana.msproduct.controller;


import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.dto.Status;
import com.lizana.msproduct.services.ProductService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import jakarta.ws.rs.HeaderParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ProductController.PRODUCTS)
public class ProductController {
    public static final String PRODUCTS = "/products";

    @Autowired
    ProductService productService;

    @PostMapping(produces = {"application/json"})
    public Maybe<ProductDto> create(@RequestBody ProductDto product) {
        return productService.saveProduct(product);
    }


    @RequestMapping("/all")
    public Flowable<ProductDto> findAll() {
        return productService.getProductAll();
    }

    @GetMapping
    public Maybe<ProductDto> buscarPor(@RequestHeader String productId) {
        return productService.getProduct(productId);
    }


    @PutMapping
    public Maybe<ProductDto> update(@RequestBody ProductDto product) {
        return productService.updateProduct(product);
    }


    @DeleteMapping
    public Maybe<Status> delete(@RequestHeader String productId) {
        return productService.deleteProduct(productId);
    }





}
