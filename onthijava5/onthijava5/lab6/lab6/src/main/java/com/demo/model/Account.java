package com.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data @Entity @Table(name="Accounts")
public class Account {
    @Id String username;
    String password;
    String fullname;
    String email;
    Boolean activated;

    @OneToMany(mappedBy = "account")
    List<Order> orders;
}
