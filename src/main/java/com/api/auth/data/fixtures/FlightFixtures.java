package com.api.auth.data.fixtures;

import com.api.auth.data.entities.Airline;
import com.api.auth.data.entities.Flight;
import com.api.auth.data.entities.Passenger;
import com.api.auth.data.repositories.IAirlineRepository;
import com.api.auth.data.repositories.IAppUserRepository;
import com.api.auth.data.repositories.IFlightRepository;
import com.api.auth.data.repositories.IPassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Order(5)
@RequiredArgsConstructor
@Component
public class FlightFixtures implements CommandLineRunner {
    private final IFlightRepository flightRepository;
    private final IAirlineRepository airlineRepository;
    private final IPassengerRepository passengerRepository;
    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();



        for (int i = 1; i <= 50; i++) {
            Flight flight = new Flight();

            flight.setReference("FLIGHT-" + i);
            flight.setDeparture("City-" + (random.nextInt(10) + 1));
            flight.setDestination("City-" + (random.nextInt(10) + 11));

            flight.setDepartureAirport("Airport-" + (random.nextInt(100) + 1));
            flight.setArrivalAirport("Airport-" + (random.nextInt(100) + 101));

            LocalDateTime departureTime = LocalDateTime.now().plusDays(i);
            LocalDateTime arrivalTime = departureTime.plusHours(2 + random.nextInt(8));
            flight.setDepartureTime(departureTime);
            flight.setArrivalTime(arrivalTime);


            long airlineId = random.nextInt(10) + 1;
            Airline airline = airlineRepository.findById(airlineId)
                    .orElseThrow(() -> new RuntimeException("Airline avec ID " + airlineId + " introuvable"));
            flight.setAirline(airline);


            List<Passenger> passengers = new ArrayList<>();
            int numberOfPassengers = 1 + random.nextInt(5);

            while (passengers.size() < numberOfPassengers) {
                long passengerId = 1 + random.nextInt(10);
                passengerRepository.findById(passengerId).ifPresent(passenger -> {
                    if (!passengers.contains(passenger)) {
                        passengers.add(passenger);
                    }
                });
            }

            flight.setPassengers(passengers);
            flightRepository.save(flight);
        }

    }
}
