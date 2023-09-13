package com.example.eshopfirstproject.Mapper;

import com.example.eshopfirstproject.dto.OrderDetailDto;
import com.example.eshopfirstproject.entity.OrderDetail;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailMapper {


    public OrderDetailDto mapToOrderDetailDto(OrderDetail orderDetail) {
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setId(orderDetail.getId());
        orderDetailDto.setIsPaid(orderDetailDto.getIsPaid());
        orderDetailDto.setTotalPrice(orderDetailDto.getTotalPrice());
        return orderDetailDto;
    }


    public OrderDetail mapToOrderDetail(OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(orderDetail.getId());
        orderDetail.setIsPaid(orderDetail.getIsPaid());
        orderDetail.setTotalPrice(orderDetail.getTotalPrice());
        return orderDetail;
    }
}
