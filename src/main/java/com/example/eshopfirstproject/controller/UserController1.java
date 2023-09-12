package com.example.eshopfirstproject.controller;

import com.example.eshopfirstproject.dto.AuthRequest;
import com.example.eshopfirstproject.dto.UserInfoDto;
import com.example.eshopfirstproject.security.jwt.JwtService;
import com.example.eshopfirstproject.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class UserController1 {
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfoDto userInfoDto) {
        return userDetailService.addUser(userInfoDto);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public UserInfoDto findById(@PathVariable Integer id) {
        return userDetailService.findById(id);
    }

    @PutMapping("updateUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserInfoDto update(@RequestBody UserInfoDto userInfoDto){
        return userDetailService.updateUserInfo(userInfoDto);
    }


    @DeleteMapping("/deleteUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@RequestParam int id){
        userDetailService.deleteUser(id);
    }


    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                (authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }


}
