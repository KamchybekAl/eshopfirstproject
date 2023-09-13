package com.example.eshopfirstproject.Mapper;

import com.example.eshopfirstproject.dto.PriceDto;
import com.example.eshopfirstproject.entity.Price;
import org.springframework.stereotype.Service;

@Service
public class PriceMapper {
    public PriceDto mapToPriceDto(Price priceDetail) {
        PriceDto priceDetailDto = new PriceDto();
        priceDetailDto.setId(priceDetail.getId());
        priceDetailDto.setPrice(priceDetailDto.getPrice());
        priceDetailDto.setStartDate(priceDetailDto.getStartDate());
        priceDetailDto.setEndDate(priceDetailDto.getEndDate());
        return priceDetailDto;
    }


    public Price mapToPrice(PriceDto priceDetailDto) {
        Price priceDetail = new Price();
        priceDetail.setId(priceDetail.getId());
        priceDetail.setPrice(priceDetail.getPrice());
        priceDetail.setStartDate(priceDetailDto.getStartDate());
        priceDetail.setEndDate(priceDetailDto.getEndDate());
        return priceDetail;
    }


}
