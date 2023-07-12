package fpoly.sd17318.tiepnmph25816.entity;

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
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SanPham {

    @NotNull(message = "Không để trống id")
    private Integer id;

    @NotEmpty(message = "Không để trống mã")
    private String ma;

    @NotEmpty(message = "Không để trống tên")
    private String ten;

    @NotNull(message = "Không để trống giá")
    private Integer gia;

    private Boolean gioiTinh;
    private String loai;
}
