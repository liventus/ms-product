package com.lizana.msproduct.controller;


import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.services.ProductService;

import com.lizana.msproduct.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(ConstantsUtil.PRODUCTS)
public class ProductsController {

  @Autowired
  ProductService productService;
  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
  public Flux<ProductDto> findAll() {
    return productService.findAll();
  }


}
