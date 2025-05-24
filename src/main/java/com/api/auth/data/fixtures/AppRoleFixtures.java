package com.api.auth.data.fixtures;

import com.api.auth.data.entities.AppRole;
import com.api.auth.data.repositories.IAppRoleRepository;
import com.api.auth.service.ISecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//@Order(1)
@RequiredArgsConstructor
public class AppRoleFixtures implements CommandLineRunner {
    private final ISecurityService securityService;
    private final IAppRoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        AppRole role1=new AppRole();
        role1.setRoleName("ADMIN");
        AppRole role2=new AppRole();
        role2.setRoleName("PASSENGER");
        roleRepository.save(role1);
        roleRepository.save(role2);



    }
}
