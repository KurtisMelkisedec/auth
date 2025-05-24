package com.api.auth.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Passenger{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String firstName;
    @Column(nullable = false,length = 100)
    private String lastName;
    @Column(nullable = false)
    private LocalDate birthDate;
    @Column(nullable = false)
    private boolean isRegistered;
    @ManyToMany(mappedBy = "passengers")
    private List<Flight>flights = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private AppUser appUser;
}
