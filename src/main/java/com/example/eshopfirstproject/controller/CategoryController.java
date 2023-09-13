package com.example.eshopfirstproject.controller;

import com.example.eshopfirstproject.dto.CategoryDto;
import com.example.eshopfirstproject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/save")
    @PreAuthorize("permitAll()")
    public CategoryDto saveCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.saveCategory(categoryDto);
    }

    @GetMapping("/findById")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public CategoryDto findById(@RequestParam Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(categoryDto);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@RequestParam Long id) {
        categoryService.deleteCategory(id);
    }

}
