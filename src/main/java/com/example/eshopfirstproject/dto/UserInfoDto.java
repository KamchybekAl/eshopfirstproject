package com.example.eshopfirstproject.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserInfoDto {
    Integer id;
    String name;
    String email;
    String password;
    String roles;
}
