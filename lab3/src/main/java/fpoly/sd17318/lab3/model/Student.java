package fpoly.sd17318.lab3.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    @NotEmpty(message = "Vui lòng nhập họ tên")
    String name;

    @NotEmpty(message = "Vui lòng nhập email")
    @Email(message = "Nhập đúng định dạng email")
    String email;

    @NotNull(message = "Không để trống marks")
    @Min(value = 0, message = "Điểm phải lớn hơn hoặc bằng 0")
    @Max(value = 10, message = "Điểm phải nhỏ hơn hoặc bằng 10")
    Double marks;

    @NotNull(message = "Vui lòng chọn giới tính")
    Boolean gender;

    @NotEmpty(message = "Vui lòng chọn khoa")
    String faculty;

    @NotEmpty(message = "Vui lòng chọn sở thích")
    List<String> hobbies;
}
