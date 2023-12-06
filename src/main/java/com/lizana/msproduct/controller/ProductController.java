package com.lizana.msproduct.controller;


import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.services.ProductService;
import io.reactivex.rxjava3.core.Maybe;
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
    public Maybe<ProductDto> create(@Valid @RequestBody ProductDto product) {
        return this.productService.saveProduct(product);
    }




}
