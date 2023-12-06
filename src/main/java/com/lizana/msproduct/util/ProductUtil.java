package com.lizana.msproduct.util;



import com.lizana.msproduct.model.dto.ProductDto;
import com.lizana.msproduct.model.entity.ProductEntity;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;


@NoArgsConstructor
public class ProductUtil {

    public static ProductDto entityToDto(ProductEntity productEntity) {
        ProductDto productDto= new ProductDto();
        BeanUtils.copyProperties(productEntity, productDto);
        return productDto;
    }

    public static ProductEntity dtoToEntity(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productDto, productEntity);
        return productEntity;
    }
}
