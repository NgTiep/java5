package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Integer maHang;

    @Column(name = "tenhang")
    private String tenHang;

}
