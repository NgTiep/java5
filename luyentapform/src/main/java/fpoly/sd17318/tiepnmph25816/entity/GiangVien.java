package fpoly.sd17318.tiepnmph25816.entity;

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
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GiangVien {

    @NotEmpty(message = "Không để trống trường")
    @Size(min = 5,message = "Tối thiểu 5")
    private String ma;

    @NotEmpty(message = "Không để trống trường")
    @Pattern(regexp = "[a-z A-Z]+", message = "Chưa đúng định dạng")
    private String hoTen;

    @NotNull(message = "Không để trống trường")
    @Min(20)
    private Integer tuoi;

    @NotEmpty(message = "Không để trống trường")
    private String queQuan;
}
