package com.example.eshopfirstproject.service;

import com.example.eshopfirstproject.Mapper.ProductMapper;
import com.example.eshopfirstproject.dto.ProductDto;
import com.example.eshopfirstproject.entity.Product;
import com.example.eshopfirstproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    public ProductDto saveProduct(ProductDto productDto){
        Product product = productMapper.mapToProduct(productDto);
        Product save = productRepository.save(product);
        return productMapper.mapToProductDto(save);
    }


    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(productMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

    public ProductDto findById(Long id) {
        return productMapper.mapToProductDto( //в метод mapToProductDto
                productRepository.findById(id) //поместили результат поиска по id
                        .orElse(new Product()) //если ни чего не нашли, то вернем пустой entity
        );
    }

    public ProductDto updateProduct(ProductDto productDto){
        Product updatedProduct = productRepository.findById(productDto.getId()).get();
        updatedProduct.setId(productDto.getId());
        updatedProduct.setName(productDto.getName());
        updatedProduct.setWeight(productDto.getWeight());
        updatedProduct.setQuantity(productDto.getQuantity());
        return productMapper.mapToProductDto(updatedProduct);
    }

    public void deleteProduct(Long id){
        Product deleteProduct = productRepository.findById(id).get();
        productRepository.delete(deleteProduct);

    }

}
