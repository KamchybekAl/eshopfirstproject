package com.example.eshopfirstproject.service;

import com.example.eshopfirstproject.dto.CategoryDto;
import com.example.eshopfirstproject.entity.Category;
import com.example.eshopfirstproject.repository.CategoryRepository;
import com.example.eshopfirstproject.Mapper.CategoryMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryDto saveCategory(CategoryDto categoryDto){
        Category category = categoryMapper.mapToCategory(categoryDto);
        Category save = categoryRepository.save(category);
        return categoryMapper.mapToCategoryDto(save);
    }


    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream() //создали из листа стирим
                .map(categoryMapper::mapToCategoryDto) //оператором из streamAPI map, использовали для каждого элемента метод mapToProductDto из класса MappingUtils
                .collect(Collectors.toList()); // превратили стрим обратно в коллекцию, а точнее в лист
    }

    public CategoryDto findById(Long id) {
        return categoryMapper.mapToCategoryDto( //в метод mapToProductDto
                categoryRepository.findById(id) //поместили результат поиска по id
                        .orElse(new Category()) //если ни чего не нашли, то вернем пустой entity
        );
    }

    public CategoryDto updateCategory(CategoryDto categoryDto){
        Category updatedCategory = categoryRepository.findById(categoryDto.getId()).get();
        updatedCategory.setName(categoryDto.getName());
        return categoryMapper.mapToCategoryDto(updatedCategory);
    }

    public void deleteCategory(Long id){
        Category deleteCategory = categoryRepository.findById(id).get();
        categoryRepository.delete(deleteCategory);
    }


}
