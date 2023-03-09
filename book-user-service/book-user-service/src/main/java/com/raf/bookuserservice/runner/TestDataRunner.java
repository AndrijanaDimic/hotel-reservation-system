package com.raf.bookuserservice.runner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.raf.bookuserservice.domain.AdminUser;
import com.raf.bookuserservice.domain.ClientStatus;
import com.raf.bookuserservice.domain.Role;

import com.raf.bookuserservice.repository.AdminUserRepository;
import com.raf.bookuserservice.repository.ClientStatusRepository;
import com.raf.bookuserservice.repository.RoleRepository;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

    private RoleRepository roleRepository;
    private AdminUserRepository userRepository;
    private ClientStatusRepository clientStatusRepository;

    public TestDataRunner(RoleRepository roleRepository, AdminUserRepository userRepository, ClientStatusRepository clientStatusRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.clientStatusRepository = clientStatusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Insert roles
        Role roleUser = new Role("ROLE_USER", "User role");
        Role roleAdmin = new Role("ROLE_ADMIN", "Admin role");
        Role roleManager = new Role("ROLE_MANAGER", "Manager role");
        roleRepository.save(roleManager);
        roleRepository.save(roleUser);
        roleRepository.save(roleAdmin);
        //Insert admin
        AdminUser admin = new AdminUser();
        admin.setEmail("admin@gmail.com");
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRole(roleAdmin);
        userRepository.save(admin);
        //User statuses
        clientStatusRepository.save(new ClientStatus(0, 5, 0));
        clientStatusRepository.save(new ClientStatus(6, 10, 10));
        clientStatusRepository.save(new ClientStatus(11, 20, 20));
    
    
    }
}
