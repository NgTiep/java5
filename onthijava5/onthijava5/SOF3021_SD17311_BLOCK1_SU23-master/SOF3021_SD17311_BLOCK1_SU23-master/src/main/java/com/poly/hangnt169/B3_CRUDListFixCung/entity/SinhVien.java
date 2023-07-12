package com.poly.hangnt169.B3_CRUDListFixCung.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor // contructor all tham so
@NoArgsConstructor // contructor k tham so
@Getter
@Setter
@ToString
@Builder // Tao ra contructor co so luong tham so tuy y
// Neu truyen vao 1 tham so => Contructor 1 tham so...
public class SinhVien {

    @NotEmpty(message = "Ngu ngoc dien di")
    @Size(min = 5,message = "Toi thieu bang 5")
    private String mssv;

    @Pattern(regexp = "[a-z A-Z]+")
    private String ten;

    @NotNull
    @Min(20)
    private Integer tuoi;

    private String diaChi;

    private Boolean gioiTinh;

    // @Data <=> Import * (import willcast)
    // Ctrl Alt O => Xoa import thua

}
