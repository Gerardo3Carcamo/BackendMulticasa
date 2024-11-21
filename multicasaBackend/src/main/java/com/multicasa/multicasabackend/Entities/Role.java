package com.multicasa.multicasabackend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {
    @Column(name = "id", nullable = false)
    @Id
    private int id;
    @Column(name = "role_description", nullable = false, length = 20)
    private String roleDescription;

}