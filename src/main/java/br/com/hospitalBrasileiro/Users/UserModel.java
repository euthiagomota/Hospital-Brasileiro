package br.com.hospitalBrasileiro.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "tb_users")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String firstname;
    private String lastname;

    @Column(unique = true)
    private String username;

    private Date birthdate;
    private String email;
    private String password;
}
