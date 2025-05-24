package com.api.auth.data.fixtures;

import com.api.auth.data.entities.AppUser;
import com.api.auth.data.entities.Passenger;
import com.api.auth.data.repositories.IAppRoleRepository;
import com.api.auth.data.repositories.IAppUserRepository;
import com.api.auth.data.repositories.IPassengerRepository;
import com.api.auth.service.ISecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
//@Order(3)
@RequiredArgsConstructor
public class AppUserFixtures implements CommandLineRunner {
    private final ISecurityService securityService;
    private final IPassengerRepository passengerRepository;
    private final IAppRoleRepository roleRepository;
    private final IAppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {



//            Passenger passenger=passengerRepository.findById(1L).get();
//
//            if (passenger!=null){
//                AppUser user=new AppUser();
//                user.setLogin("kurtismelkisoft@gmail.com");
//                user.setPassword(passwordEncoder.encode("passer123"));
//                user.setPassenger(passenger);
//                passenger.setAppUser(user);
//                user.getRoles().add(
//                        roleRepository.findByRoleName("PASSENGER")
//                );
//                userRepository.save(user);
//                passengerRepository.save(passenger);
//            }


    }
}
