package com.example.eshopfirstproject.controller;

import com.example.eshopfirstproject.dto.OrderDetailDto;
import com.example.eshopfirstproject.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @PostMapping("/save")
    @PreAuthorize("permitAll()")
    public OrderDetailDto saveOrderDetail(@RequestBody OrderDetailDto orderDetailDto) {
        return orderDetailService.saveOrderDetail(orderDetailDto);
    }

    @GetMapping("/findById")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public OrderDetailDto findById(@RequestParam Long id) {
        return orderDetailService.findById(id);
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<OrderDetailDto> findAll() {
        return orderDetailService.findAll();
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public OrderDetailDto updateOrderDetail(@RequestBody OrderDetailDto orderDetailDto) {
        return orderDetailService.updateOrderDetail(orderDetailDto);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@RequestParam Long id) {
        orderDetailService.deleteOrderDetail(id);
    }


}
