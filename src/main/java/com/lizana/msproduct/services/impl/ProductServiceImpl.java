package com.lizana.msproduct.services.impl;

import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.dto.StatusResponse;
import com.lizana.msproduct.model.entity.ProductEntity;
import com.lizana.msproduct.model.mapper.ProductMapper;
import com.lizana.msproduct.repository.ProductRepository;
import com.lizana.msproduct.services.ProductService;
import com.lizana.msproduct.util.ProductUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  private final ProductMapper mapper;

  @Override
  @Transactional
  public Mono<StatusResponse> create(ProductDto productDto) {
    log.info("create");
    log.info("{}",productDto);
    ProductEntity productEntity = mapper.requestToEntity(productDto);
    log.info("{}",productEntity);
    return productRepository.save(productEntity)
        .map(mapper::entityToResponse)
        .map(x -> ProductUtil.setStatusResponse(HttpStatus.CREATED, x));

  }

  @Override
  @Transactional
  public Mono<StatusResponse> delete(String idProduct) {
    return
        productRepository.findById(idProduct)
            .flatMap(product -> {
              if (product != null) {
                return productRepository.deleteById(product.getIdDeProducto())
                    .then(Mono.just(new StatusResponse(13, "se elimino correctamente", null)));
              } else {
                return Mono.just(new StatusResponse(13, "no existe el producto", null));
              }
            });
  }

  @Override
  @Transactional(readOnly = true)
  public Mono<StatusResponse> findById(String id) {
    return productRepository.findById(id)
        .map(mapper::entityToResponse)
        .map(x -> ProductUtil.setStatusResponse(HttpStatus.OK, x));
  }

  @Override
  @Transactional
  public Mono<StatusResponse> update(ProductDto productDto) {
    ProductEntity productEntity = mapper.requestToEntity(productDto);
    return productRepository.save(productEntity)
        .map(mapper::entityToResponse)
        .map(x -> ProductUtil.setStatusResponse(HttpStatus.OK, x));
  }

  @Override
  @Transactional(readOnly = true)
  public Flux<ProductDto> findAll() {
    return productRepository.findAll().map(mapper::entityToResponse);
  }


}
