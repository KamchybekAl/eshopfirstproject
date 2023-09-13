package com.example.eshopfirstproject.controller;

import com.example.eshopfirstproject.dto.ProductDto;
import com.example.eshopfirstproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/save")
    @PreAuthorize("permitAll()")
    public ProductDto saveProduct(@RequestBody ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

    @GetMapping("/findById")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ProductDto findById(@RequestParam Long id) {
        return productService.findById(id);
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@RequestParam Long id) {
        productService.deleteProduct(id);
    }

}
