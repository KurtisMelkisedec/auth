package com.api.auth.data.repositories;

import com.api.auth.data.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightRepository extends JpaRepository<Flight, Long> {
}
