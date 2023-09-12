package com.example.eshopfirstproject.Mapper;

import com.example.eshopfirstproject.dto.BasketDto;
import com.example.eshopfirstproject.entity.Basket;
import org.springframework.stereotype.Service;

@Service
public class BasketMapper {
    public BasketDto mapToBasketDto(Basket Basket) {
        BasketDto BasketDto = new BasketDto();
        BasketDto.setId(Basket.getId());
        BasketDto.setQuantity(Basket.getQuantity());
        return BasketDto;
    }

    public Basket mapToBasket(BasketDto BasketDto) {
        Basket Basket = new Basket();
        Basket.setId(BasketDto.getId());
        Basket.setQuantity(BasketDto.getQuantity());
        return Basket;
    }
}
