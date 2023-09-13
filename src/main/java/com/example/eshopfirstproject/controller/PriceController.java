package com.example.eshopfirstproject.controller;

import com.example.eshopfirstproject.dto.PriceDto;
import com.example.eshopfirstproject.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("price")
@RequiredArgsConstructor
public class PriceController {
    private final PriceService priceService;

    @PostMapping("/save")
    @PreAuthorize("permitAll()")
    public PriceDto savePrice(@RequestBody PriceDto priceDto) {
        return priceService.savePrice(priceDto);
    }

    @GetMapping("/findById")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public PriceDto findById(@RequestParam Long id) {
        return priceService.findById(id);
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<PriceDto> findAll() {
        return priceService.findAll();
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public PriceDto updatePrice(@RequestBody PriceDto priceDto) {
        return priceService.updatePrice(priceDto);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@RequestParam Long id) {
        priceService.deletePrice(id);
    }


}
