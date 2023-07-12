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
import java.util.UUID;

@Entity
@Table(name = "diachi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiaChi {

    @Id
    @Column(name = "madiachi")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID maDiaChi;

    @Column(name = "tendiachi")
    private String tenDiaChi;
}
