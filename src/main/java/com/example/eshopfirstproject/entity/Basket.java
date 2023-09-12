package com.example.eshopfirstproject.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "basket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double quantity;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "user_infi_id",referencedColumnName = "id")
    private UserInfo userInfo;



}
