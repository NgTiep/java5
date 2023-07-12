package com.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @NotEmpty(message = "Không để trong name")
    String name;

    @NotEmpty(message = "Khong  de trong email")
    String email;

    @NotNull(message = "Khong de trong marks")
    Double marks;
    Boolean gender;
    String faculty;
    @NotEmpty(message = "Khong de trong hobbies")
    List<String> hobbies;
}
