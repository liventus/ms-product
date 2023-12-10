package com.lizana.msproduct.services;


import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.dto.StatusResponse;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;


public interface ProductService {

    Maybe<StatusResponse> saveProduct(ProductDto ProductObject);

    Maybe<StatusResponse> deleteProduct(String idProducto);

    Maybe<StatusResponse>  getProduct(String idProduct);


    Maybe<StatusResponse> updateProduct(ProductDto ProductObject);

    Flowable<ProductDto> getProductAll();




}
