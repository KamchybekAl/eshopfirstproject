package com.example.eshopfirstproject.Mapper;

import com.example.eshopfirstproject.dto.CategoryDto;
import com.example.eshopfirstproject.entity.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {

    //From entity to dto
    public CategoryDto mapToCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }
    //From dto to entity

    public Category mapToCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        return category;
    }


}
