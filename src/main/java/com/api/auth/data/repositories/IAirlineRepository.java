package com.api.auth.data.repositories;

import com.api.auth.data.entities.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirlineRepository extends JpaRepository<Airline, Long> {
}
