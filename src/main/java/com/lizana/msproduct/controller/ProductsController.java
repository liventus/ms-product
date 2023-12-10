package com.lizana.msproduct.controller;


import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.dto.StatusResponse;
import com.lizana.msproduct.services.ProductService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ProductsController.PRODUCTS)
public class ProductsController {
    public static final String PRODUCTS = "/products";

    @Autowired
    ProductService productService;


    @GetMapping()
    public Flowable<ProductDto> findAll() {
        return productService.getProductAll();
    }





}
