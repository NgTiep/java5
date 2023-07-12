package fpoly.sd17318.tiepnmph25816.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SanPham {


    @Id
    @NotNull(message = "khong de trong id")
    private int id;

    @NotEmpty(message = "khong de trong ma")
    @Size(max = 5, message = "gia tri lon hon 5")
    private String ma;

    @NotEmpty(message = "khong de trong ten")
    @Pattern(regexp = "[a-z A-Z]+",message = "sai dinh dang chu")
    private String ten;

    @NotNull(message = "khong de trong gia")
    @Min(value = 0, message = "phai la so duong")
    @Max(value = 150, message = "lon hon 150")
    private int gia;

    private boolean gioiTinh;
    private String loai;
}
