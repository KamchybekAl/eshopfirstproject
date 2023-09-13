package com.example.eshopfirstproject.service;

import com.example.eshopfirstproject.Mapper.OrderDetailMapper;
import com.example.eshopfirstproject.dto.OrderDetailDto;
import com.example.eshopfirstproject.entity.OrderDetail;
import com.example.eshopfirstproject.repository.OrderDetailRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailMapper orderDetailMapper;
    public OrderDetailDto saveOrderDetail(OrderDetailDto orderDetailDto){
        OrderDetail orderDetail = orderDetailMapper.mapToOrderDetail(orderDetailDto);
        OrderDetail save = orderDetailRepository.save(orderDetail);
        return orderDetailMapper.mapToOrderDetailDto(save);
    }


    public List<OrderDetailDto> findAll() {
        return orderDetailRepository.findAll().stream()
                .map(orderDetailMapper::mapToOrderDetailDto)
                .collect(Collectors.toList());
    }

    public OrderDetailDto findById(Long id) {
        return orderDetailMapper.mapToOrderDetailDto( //в метод mapToProductDto
                orderDetailRepository.findById(id) //поместили результат поиска по id
                        .orElse(new OrderDetail()) //если ни чего не нашли, то вернем пустой entity
        );
    }

    public OrderDetailDto updateOrderDetail(OrderDetailDto orderDetailDto){
        OrderDetail updatedOrderDetail = orderDetailRepository.findById(orderDetailDto.getId()).get();
        updatedOrderDetail.setId(orderDetailDto.getId());
        updatedOrderDetail.setIsPaid(orderDetailDto.getIsPaid());
        updatedOrderDetail.setTotalPrice(orderDetailDto.getTotalPrice());
        return orderDetailMapper.mapToOrderDetailDto(updatedOrderDetail);
    }

    public void deleteOrderDetail(Long id){
        OrderDetail deleteOrderDetail = orderDetailRepository.findById(id).get();
        orderDetailRepository.delete(deleteOrderDetail);

    }


}
