package com.example.eshopfirstproject.service;

import com.example.eshopfirstproject.dto.CategoryDto;
import com.example.eshopfirstproject.entity.Category;
import com.example.eshopfirstproject.repository.CategoryRepository;
import com.example.eshopfirstproject.Mapper.CategiryMapper;
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
    private final CategiryMapper categiryMapper;

    public CategoryDto saveCategory(CategoryDto categoryDto){
        Category category = categiryMapper.mapToCategory(categoryDto);
        Category save = categoryRepository.save(category);
        return categiryMapper.mapToCategoryDto(save);
    }


    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream() //создали из листа стирим
                .map(categiryMapper::mapToCategoryDto) //оператором из streamAPI map, использовали для каждого элемента метод mapToProductDto из класса MappingUtils
                .collect(Collectors.toList()); // превратили стрим обратно в коллекцию, а точнее в лист
    }

    public CategoryDto findById(Long id) {
        return categiryMapper.mapToCategoryDto( //в метод mapToProductDto
                categoryRepository.findById(id) //поместили результат поиска по id
                        .orElse(new Category()) //если ни чего не нашли, то вернем пустой entity
        );
    }

    public CategoryDto updateCategory(CategoryDto categoryDto){
        Category updatedCategory = categoryRepository.findById(categoryDto.getId()).get();
        updatedCategory.setName(categoryDto.getName());
        return categiryMapper.mapToCategoryDto(updatedCategory);
    }

    public void deleteCategory(Long id){
        Category deleteCategory = categoryRepository.findById(id).get();
        categoryRepository.delete(deleteCategory);
    }


}
