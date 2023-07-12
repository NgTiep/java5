package fpoly.sd17218.assigment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {

    @Id
    @Column(name = "username")
    @NotBlank(message = "Không để trống trường")
    private String username;

    @NotBlank(message = "Không để trống trường")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "Không để trống trường")
    @Column(name = "fullname")
    private String fullname;

    @NotBlank(message = "Không để trống trường")
    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "photo")
    private String photo;

    @Column(name = "activated")
    private Integer activated;

    @Column(name = "admin")
    private Integer admin;


}
