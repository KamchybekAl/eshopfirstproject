package com.example.eshopfirstproject.controller;

import com.example.eshopfirstproject.dto.BasketDto;
import com.example.eshopfirstproject.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @PostMapping("/save")
    @PreAuthorize("permitAll()")
    public BasketDto saveBasket(@RequestBody BasketDto basketDto) {
        return basketService.saveBasket(basketDto);
    }

    @GetMapping("/findById")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public BasketDto findById(@RequestParam Long id) {
        return basketService.findById(id);
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<BasketDto> findAll() {
        return basketService.findAll();
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public BasketDto updateBasket(@RequestBody BasketDto basketDto) {
        return basketService.updateBasket(basketDto);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@RequestParam Long id) {
        basketService.deleteBasket(id);
    }


}
