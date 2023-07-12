package fpoly.sd17318.tiepnmph25816.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SinhVien {

    private int id;
    private String ten;
    private int tuoi;
    private boolean gioiTinh;
    private String diaChi;
}
