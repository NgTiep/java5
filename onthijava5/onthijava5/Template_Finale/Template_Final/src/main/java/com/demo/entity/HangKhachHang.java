package com.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hangkhachhang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HangKhachHang {

    @Id
    @Column(name = "mahang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maHang;

    @Column(name = "tenhang")
    private String tenHang;


}
