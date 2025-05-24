package com.api.auth.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true,length = 20)
    private String reference;
    @Column(nullable = false,length = 100)
    private String departure;
    @Column(nullable = false,length = 100)
    private String destination;
    @Column(nullable = false)
    private LocalDateTime departureTime;
    @Column(nullable = false)
    private LocalDateTime arrivalTime;
    @Column(nullable = false,length = 100)
    private String departureAirport;
    @Column(nullable = false,length = 100)
    private String arrivalAirport;
    @ManyToOne
    private Airline airline;
    @ManyToMany
    private List<Passenger>passengers = new ArrayList<>();

}
