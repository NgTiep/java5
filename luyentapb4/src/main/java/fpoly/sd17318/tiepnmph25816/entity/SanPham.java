package fpoly.sd17318.tiepnmph25816.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SanPham {

    @Id
    @NotNull(message = "khong de trong id")
    private int id;

    @NotEmpty(message = "khong de trong ma")
    private String ma;

    @NotEmpty(message = "khong de trong ten")
    private String ten;

    @NotNull(message = "khong de trong gia")
    @Min(value = 0, message = "phai la so duong")
    @Max(value = 150, message = "lon hon 150")
    private int gia;

    private boolean gioiTinh;
    private String loai;
}
