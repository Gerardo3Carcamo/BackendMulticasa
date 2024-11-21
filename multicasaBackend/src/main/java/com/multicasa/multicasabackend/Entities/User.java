package com.multicasa.multicasabackend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Column(name = "id", nullable = false)
    @Id
    private int id;
    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "pass", nullable = false, length = 8)
    private String pass;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

}