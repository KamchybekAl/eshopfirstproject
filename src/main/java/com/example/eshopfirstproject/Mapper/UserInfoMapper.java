package com.example.eshopfirstproject.Mapper;

import com.example.eshopfirstproject.dto.UserInfoDto;
import com.example.eshopfirstproject.entity.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class UserInfoMapper {

    public UserInfoDto mapToUserInfoDto(UserInfo UserInfo){
        UserInfoDto UserInfoDto = new UserInfoDto();
        UserInfoDto.setName(UserInfo.getName());
        UserInfoDto.setEmail(UserInfoDto.getEmail());
        UserInfoDto.setPassword(UserInfoDto.getPassword());
        UserInfoDto.setRoles(UserInfoDto.getRoles());
        return UserInfoDto;
    }


    public UserInfo mapToUserInfo(UserInfoDto UserInfoDto){
        UserInfo UserInfo = new UserInfo();
        UserInfo.setName(UserInfoDto.getName());
        UserInfo.setEmail(UserInfoDto.getEmail());
        UserInfo.setPassword(UserInfoDto.getPassword());
        UserInfo.setRoles(UserInfoDto.getRoles());
        return UserInfo;
    }
}
