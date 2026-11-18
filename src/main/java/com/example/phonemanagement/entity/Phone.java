package com.example.phonemanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Brand" , nullable = false)
    private  String Brand;

    @Column(name = "Model" , nullable = false)
    private  String Model;

    @Column(name = "Date Manufactured" , nullable = false)
    private  String dateManufactured;

    @Column(name = "Price" , nullable = false)
    private  String Price;

}

