package com.lizana.msproduct.model.mapper;

import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

  @Mapping(source = "entity.id", target = "id")
  @Mapping(source = "entity.idDeProducto", target = "idDeProducto")
  @Mapping(source = "entity.comision", target = "comision")
  @Mapping(source = "entity.tipoDeCuenta", target = "tipoDeCuenta")
  @Mapping(source = "entity.claseDeCuenta", target = "claseDeCuenta")
  @Mapping(source = "entity.limitMaxDepositoMensual", target = "limitMaxDepositoMensual")
  @Mapping(source = "entity.limitMaxRetiroMensual", target = "limitMaxRetiroMensual")
  @Mapping(source = "entity.limitMaxPagoMensual", target = "limitMaxPagoMensual")
  @Mapping(source = "entity.limitMaxCredito", target = "limitMaxCredito")
  ProductDto entityToResponse(ProductEntity entity);

  @Mapping(source = "request.id", target = "id")
  @Mapping(source = "request.idDeProducto", target = "idDeProducto")
  @Mapping(source = "request.comision", target = "comision")
  @Mapping(source = "request.tipoDeCuenta", target = "tipoDeCuenta")
  @Mapping(source = "request.claseDeCuenta", target = "claseDeCuenta")
  @Mapping(source = "request.limitMaxDepositoMensual", target = "limitMaxDepositoMensual")
  @Mapping(source = "request.limitMaxRetiroMensual", target = "limitMaxRetiroMensual")
  @Mapping(source = "request.limitMaxPagoMensual", target = "limitMaxPagoMensual")
  @Mapping(source = "request.limitMaxCredito", target = "limitMaxCredito")
  ProductEntity requestToEntity(ProductDto request);

}
