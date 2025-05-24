package com.api.auth.data.repositories;

import com.api.auth.data.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPassengerRepository extends JpaRepository<Passenger, Long> {
}
