package com.lizana.msproduct.services;


import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.dto.Status;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;


public interface ProductService {

    Maybe<ProductDto> saveProduct(ProductDto ProductObject);

    Maybe<Status> deleteProduct(String idProducto);

    Maybe<ProductDto>  getProduct(String idProduct);


    Maybe<ProductDto> updateProduct(ProductDto ProductObject);

    Flowable<ProductDto> getProductAll();




}
