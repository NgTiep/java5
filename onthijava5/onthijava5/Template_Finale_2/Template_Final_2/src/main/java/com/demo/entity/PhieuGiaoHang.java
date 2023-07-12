package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "phieugiaohang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhieuGiaoHang {

    @Id
    @Column(name = "maphieugiao")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID maphieugiao;

    @Column(name = "nguoinhan")
    private String nguoinhan;

    @Column(name = "sdtnhan")
    private String sdt;

    @Column(name = "ngaygiao")
    private String ngaygiao;

    @Column(name = "ngaynhan")
    private String ngaynhan;

    @Column(name = "trangthai")
    private int trangthai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hoadongiao",referencedColumnName = "mahoadon")
    private HoaDon hoadon;



}
