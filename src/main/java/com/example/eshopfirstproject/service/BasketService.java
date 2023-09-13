package com.example.eshopfirstproject.service;

import com.example.eshopfirstproject.Mapper.BasketMapper;
import com.example.eshopfirstproject.dto.BasketDto;
import com.example.eshopfirstproject.entity.Basket;
import com.example.eshopfirstproject.repository.BasketRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BasketService {
    private final BasketRepository basketRepository;
    private final BasketMapper basketMapper;
    public BasketDto saveBasket(BasketDto basketDto){
        Basket basket = basketMapper.mapToBasket(basketDto);
        Basket save = basketRepository.save(basket);
        return basketMapper.mapToBasketDto(save);
    }


    public List<BasketDto> findAll() {
        return basketRepository.findAll().stream()
                .map(basketMapper::mapToBasketDto)
                .collect(Collectors.toList());
    }

    public BasketDto findById(Long id) {
        return basketMapper.mapToBasketDto( //в метод mapToBasketDto
                basketRepository.findById(id) //поместили результат поиска по id
                        .orElse(new Basket()) //если ни чего не нашли, то вернем пустой entity
        );
    }

    public BasketDto updateBasket(BasketDto basketDto){
        Basket updatedBasket = basketRepository.findById(basketDto.getId()).get();
        updatedBasket.setId(basketDto.getId());
        updatedBasket.setQuantity(basketDto.getQuantity());
        updatedBasket.setCreatedDate(basketDto.getCreatedDate());
        return basketMapper.mapToBasketDto(updatedBasket);
    }

    public void deleteBasket(Long id){
        Basket deleteBasket = basketRepository.findById(id).get();
        basketRepository.delete(deleteBasket);

    }


}
