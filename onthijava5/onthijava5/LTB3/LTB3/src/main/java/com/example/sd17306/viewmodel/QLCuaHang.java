package com.example.sd17306.viewmodel;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class QLCuaHang {

    @NotBlank(message = "Không được để trống mã")
    @Length(max = 255, message = "Mã không được quá 255 kí tự")
    private String ma;

    @NotBlank
    @Length(max = 255)
    private String ten;

    @NotBlank
    @Length(max = 255)
    private String diaChi;

    @NotBlank
    @Length(max = 255)
    private String thanhPho;

    @NotBlank
    @Length(max = 255)
    private String quocGia;

}
