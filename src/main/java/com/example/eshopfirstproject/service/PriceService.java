package com.example.eshopfirstproject.service;

import com.example.eshopfirstproject.Mapper.PriceMapper;
import com.example.eshopfirstproject.dto.PriceDto;
import com.example.eshopfirstproject.entity.Price;
import com.example.eshopfirstproject.repository.PriceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PriceService {
    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;
    public PriceDto savePrice(PriceDto priceDto){
        Price price = priceMapper.mapToPrice(priceDto);
        Price save = priceRepository.save(price);
        return priceMapper.mapToPriceDto(save);
    }


    public List<PriceDto> findAll() {
        return priceRepository.findAll().stream()
                .map(priceMapper::mapToPriceDto)
                .collect(Collectors.toList());
    }

    public PriceDto findById(Long id) {
        return priceMapper.mapToPriceDto( //в метод mapToProductDto
                priceRepository.findById(id) //поместили результат поиска по id
                        .orElse(new Price()) //если ни чего не нашли, то вернем пустой entity
        );
    }

    public PriceDto updatePrice(PriceDto priceDto){
        Price updatedPrice = priceRepository.findById(priceDto.getId()).get();
        updatedPrice.setId(priceDto.getId());
        updatedPrice.setPrice(priceDto.getPrice());

        return priceMapper.mapToPriceDto(updatedPrice);
    }

    public void deletePrice(Long id){
        Price deletePrice = priceRepository.findById(id).get();
        priceRepository.delete(deletePrice);

    }
}
