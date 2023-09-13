package com.example.eshopfirstproject.service;

import com.example.eshopfirstproject.Mapper.UserInfoMapper;
import com.example.eshopfirstproject.dto.UserInfoDto;
import com.example.eshopfirstproject.entity.UserInfo;
import com.example.eshopfirstproject.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserDetailService {


    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserInfoMapper userInfoMapper;


    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "user added to system ";
    }

    public List<UserInfoDto> findAll() {
        return userInfoRepository.findAll().stream() //создали из листа стирим
                .map(userInfoMapper::mapToUserInfoDto) //оператором из streamAPI map, использовали для каждого элемента метод mapToProductDto из класса MappingUtils
                .collect(Collectors.toList()); // превратили стрим обратно в коллекцию, а точнее в лист
    }

    public UserInfoDto findById(Integer id) {
        return userInfoMapper.mapToUserInfoDto( //в метод mapToProductDto
                userInfoRepository.findById(id) //поместили результат поиска по id
                        .orElse(new UserInfo()) //если ни чего не нашли, то вернем пустой entity
        );
    }

    public UserInfoDto updateUserInfo(UserInfoDto userInfoDto) {
        UserInfo updatedUserInfo = userInfoRepository.findById(userInfoDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Пользователя с введеным ID нет"));
        updatedUserInfo.setId(userInfoDto.getId());
        updatedUserInfo.setName(userInfoDto.getName());
        updatedUserInfo.setEmail(userInfoDto.getEmail());
        updatedUserInfo.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
        updatedUserInfo.setRoles(userInfoDto.getRoles());

        return userInfoMapper.mapToUserInfoDto(updatedUserInfo);
    }


    public void deleteUser(Integer id) {
        UserInfo deleteUser = userInfoRepository.findById(id).get();
        userInfoRepository.delete(deleteUser);
    }
}

