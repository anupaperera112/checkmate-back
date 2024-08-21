package com.example.to_do.list.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="user_id",length=45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId ;

    @Column(name="user_name",length=45)
    private String userName;

    @Column(name="user_email",length=45)
    private String userEmail;

    @Column(name="user_password",length=45)
    private String userPassword;

}
