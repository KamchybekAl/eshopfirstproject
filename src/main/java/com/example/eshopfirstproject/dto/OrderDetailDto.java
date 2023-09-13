package com.example.eshopfirstproject.dto;

import com.example.eshopfirstproject.entity.Price;
import com.example.eshopfirstproject.entity.UserInfo;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailDto {

    Long id;
    Boolean isPaid;
    Double totalPrice;
    private UserInfo userInfo;
    private Price price;
}
