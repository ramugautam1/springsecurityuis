package com.vastika.uis.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "city_name")
    private String cityName;
}