package com.lizana.msproduct.controller;


import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.dto.StatusResponse;
import com.lizana.msproduct.services.ProductService;

import com.lizana.msproduct.util.ConstantsUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ConstantsUtil.PRODUCT)
public class ProductController {

  @Autowired
  ProductService productService;

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE},
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
  public Mono<StatusResponse> create(@Valid @RequestBody ProductDto product) {
    return productService.create(product);
  }

  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
  public Mono<StatusResponse> findByProductId(@RequestHeader String productId) {
    return productService.findById(productId);
  }

  @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE},
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
  public Mono<StatusResponse> update(@RequestBody ProductDto product) {
    return productService.update(product);
  }

  @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE},
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
  public Mono<StatusResponse> delete(@RequestHeader String productId) {
    return productService.delete(productId);
  }


}
