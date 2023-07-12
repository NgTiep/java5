package fpoly.sd17318.lab4.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {

    private Integer id;
    private String name;
    private double price;
    private int qty;
}
