package fpoly.sd17318.luyentap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "SanPham")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "MaSP")
    private  String maSP;

    @Column(name = "TenSP")
    private String tenSP;

    @Column(name = "DonGia")
    private float donGia;
    @Column(name = "Mota")
    private String moTa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSac",referencedColumnName = "Id")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHang",referencedColumnName = "Id")
    private HangDienThoai hangDienThoai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChip",referencedColumnName = "Id")
    private Chip chip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdRam",referencedColumnName = "Id")
    private Ram ram;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdRom",referencedColumnName = "Id")
    private Rom rom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPin",referencedColumnName = "Id")
    private Pin pin;

    @Column(name = "SoLuong")
    private int soLuong;
}
