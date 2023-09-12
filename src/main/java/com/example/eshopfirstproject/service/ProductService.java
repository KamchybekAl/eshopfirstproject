package com.example.eshopfirstproject.service;

import com.example.eshopfirstproject.dto.ProductDto;
import com.example.eshopfirstproject.entity.UserInfo;
import com.example.eshopfirstproject.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    List<ProductDto> productList = null;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @PostConstruct
//    public void loadProductsFromDB() {
//        productList = IntStream.rangeClosed(1, 100)
//                .mapToObj(i -> ProductDto.builder()
//                        .productId(i)
//                        .name("product " + i)
//                        .qty(new Random().nextInt(10))
//                        .price(new Random().nextInt(5000)).build()
//                ).collect(Collectors.toList());
//    }


//    public List<ProductDto> getProducts() {
//        return productList;
//    }
//
//    public ProductDto getProduct(int id) {
//        return productList.stream()
//                .filter(product -> product.getProductId() == id)
//                .findAny()
//                .orElseThrow(() -> new RuntimeException("product " + id + " not found"));
//    }


    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "user added to system ";
    }

//    public UserInfo updateUser(UserInfo userInfo){
////        UserInfo updatedUser = userInfoRepository.findById(userInfo.getId()).get();
//        UserInfo updatedUser = userInfoRepository.findById(userInfo.getId())
//                .orElseThrow(() -> new IllegalArgumentException("Пользователя c введеным ID нет"));
//        updatedUser.setName(userInfo.getName());
//        updatedUser.setEmail(userInfo.getEmail());
//        updatedUser.setPassword(userInfo.getPassword());
//        updatedUser.setRoles(userInfo.getRoles());
//        return updatedUser;
//    }

    public void deleteUser(Integer id){
        UserInfo deleteUser = userInfoRepository.findById(id).get();
        userInfoRepository.delete(deleteUser);
        }
}
