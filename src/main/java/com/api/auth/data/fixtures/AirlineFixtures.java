package com.api.auth.data.fixtures;

import com.api.auth.data.entities.Airline;
import com.api.auth.data.repositories.IAirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Order(4)
@RequiredArgsConstructor
@Component
public class AirlineFixtures implements CommandLineRunner {
    private final IAirlineRepository airlineRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i <=20 ; i++) {
            Airline airline=new Airline();
            airline.setName("Airline_"+1);
            airlineRepository.save(airline);

        }
    }
}
