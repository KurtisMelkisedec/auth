package com.api.auth.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 100, unique = true)
    private String login;
    @ManyToMany
    private List<AppRole> roles=new ArrayList<>();

    @OneToOne
    private Passenger passenger;
}
