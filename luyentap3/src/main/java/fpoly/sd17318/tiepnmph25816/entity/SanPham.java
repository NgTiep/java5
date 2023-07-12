package fpoly.sd17318.tiepnmph25816.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SanPham {

    @NotNull(message = "khong de trong id")
    private int id;

    @NotEmpty(message = "khong de trong ma")
    private String ma;

    @NotEmpty(message = "khong de trong ten")
    private String ten;

    @NotNull(message = "khong de trong gia")
    @Min(value=0, message="must be equal or greater than 0")
    @Max(value=150, message="must be equal or less than 150")
    private int gia;

    private String loai;

}
