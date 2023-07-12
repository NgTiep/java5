package fpoly.sd17218.btvn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "nhan_vien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NhanVien {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "khong the trong truong")
    @Column(name = "ma")
    private String ma;

    @NotBlank(message = "khong the trong truong")
    @Column(name = "ten")
    private String ten;

    @NotBlank(message = "khong the trong truong")
    @Column(name = "ten_dem")
    private String tenDem;

    @NotBlank(message = "khong the trong truong")
    @Column(name = "ho")
    private String ho;

    @NotNull(message = "khong the trong truong")
    @Column(name = "gioi_tinh")
    private String gioiTinh;

    @NotBlank(message = "khong the trong truong")
    @Column(name = "dia_chi")
    private String diaChi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ch", referencedColumnName = "id")
    private CuaHang cuaHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cv", referencedColumnName = "id")
    private ChucVu chucVu;

}
