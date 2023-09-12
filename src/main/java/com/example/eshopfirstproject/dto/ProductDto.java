package com.example.eshopfirstproject.dto;

import com.example.eshopfirstproject.entity.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {

    Long id;
    String name;
    Double weight;
    Double quantity;
    Category category;
}
