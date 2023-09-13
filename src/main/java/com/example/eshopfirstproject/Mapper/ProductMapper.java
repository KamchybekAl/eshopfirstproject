package com.example.eshopfirstproject.Mapper;

import com.example.eshopfirstproject.dto.ProductDto;
import com.example.eshopfirstproject.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public ProductDto mapToProductDto(Product productDetail) {
        ProductDto productDetailDto = new ProductDto();
        productDetailDto.setId(productDetail.getId());
        productDetailDto.setName(productDetailDto.getName());
        productDetailDto.setWeight(productDetailDto.getWeight());
        productDetailDto.setQuantity(productDetailDto.getQuantity());
        return productDetailDto;
    }


    public Product mapToProduct(ProductDto productDetailDto) {
        Product productDetail = new Product();
        productDetail.setId(productDetail.getId());
        productDetail.setName(productDetailDto.getName());
        productDetail.setWeight(productDetail.getWeight());
        productDetail.setQuantity(productDetailDto.getQuantity());
        return productDetail;
    }
}
