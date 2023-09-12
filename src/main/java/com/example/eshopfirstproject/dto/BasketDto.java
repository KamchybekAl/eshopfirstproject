package com.example.eshopfirstproject.dto;

import com.example.eshopfirstproject.entity.UserInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasketDto {
    Long id;
    Double quantity;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate createdDate;
    UserInfo userInfo;

}
