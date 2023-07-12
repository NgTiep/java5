package com.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity @Data @Table(name="Orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String address;

    @Temporal(TemporalType.DATE)
    @Column(name="Createdate")
    public Date createDate = new Date();

    @ManyToOne @JoinColumn(name="Username")
    Account account;
}
