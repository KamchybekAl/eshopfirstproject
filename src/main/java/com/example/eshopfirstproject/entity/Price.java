package com.example.eshopfirstproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "price")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double price;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime startDate;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    Product product;

}
