package com.example.eshopfirstproject.controller;

import com.example.eshopfirstproject.Mapper.UserInfoMapper;
import com.example.eshopfirstproject.dto.AuthRequest;
import com.example.eshopfirstproject.dto.UserInfoDto;
import com.example.eshopfirstproject.entity.UserInfo;
import com.example.eshopfirstproject.security.jwt.JwtService;
import com.example.eshopfirstproject.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoMapper userInfoMapper;
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

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return userDetailService.addUser(userInfo);
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserInfoDto> findAll() {
        return userDetailService.findAll();
    }

    @GetMapping("/findById")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public UserInfoDto findById(@RequestParam Integer id) {
        return userDetailService.findById(id);
    }

    @PutMapping("updateUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserInfoDto updateUser(@RequestBody UserInfoDto userInfoDto){
        return userDetailService.updateUserInfo(userInfoDto);
    }


    @DeleteMapping("/deleteUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@RequestParam int id){
        userDetailService.deleteUser(id);
    }

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
