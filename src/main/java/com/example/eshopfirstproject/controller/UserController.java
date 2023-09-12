package com.example.eshopfirstproject.controller;

import com.example.eshopfirstproject.dto.AuthRequest;
import com.example.eshopfirstproject.entity.UserInfo;
import com.example.eshopfirstproject.security.jwt.JwtService;
import com.example.eshopfirstproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ProductService service;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

//    @PutMapping("updateUser")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public UserInfo update(@RequestBody UserInfo userInfo){
//        return service.updateUser(userInfo);
//    }

//    @GetMapping("/all")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public List<ProductDto> getAllTheProducts() {
//        return service.getProducts();
//    }

    @DeleteMapping("/deleteUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@RequestParam int id){
        service.deleteUser(id);
    }

//    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
//    public ProductDto getProductById(@PathVariable Integer id) {
//        return service.getProduct(id);
//    }
//








    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken
                (authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}