package com.example.eshopfirstproject.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "orderdetail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Boolean isPaid;
    Double totalPrice;

//    @ManyToMany(cascade = CascadeType.MERGE)
//    private List<ProductDto> productList;
    @ManyToOne(cascade = CascadeType.MERGE)
    private UserInfo userInfo;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Price price;

}
