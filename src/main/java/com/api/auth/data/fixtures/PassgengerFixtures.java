package com.api.auth.data.fixtures;

import com.api.auth.data.entities.Passenger;
import com.api.auth.data.repositories.IPassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

//@Component
//@Order(2)
@RequiredArgsConstructor
public class PassgengerFixtures implements CommandLineRunner {
    private final IPassengerRepository passengerRepository;
    @Override
    public void run(String... args) throws Exception {


//        for (int i = 1; i <= 10; i++) {
//            Passenger passenger=new Passenger();
//            passenger.setFirstName("Passenger_"+i);
//            passenger.setLastName("Passenger_"+i);
//            passenger.setBirthDate(LocalDate.now());
//            passenger.setRegistered(false);
//            passengerRepository.save(passenger);
//        }


    }
}
