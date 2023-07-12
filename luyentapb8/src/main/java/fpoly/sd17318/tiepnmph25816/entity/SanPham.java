package fpoly.sd17318.tiepnmph25816.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {

    private int id;
    private String ma;
    private String ten;
    private boolean gioiTinh;
    private String loai;

}
