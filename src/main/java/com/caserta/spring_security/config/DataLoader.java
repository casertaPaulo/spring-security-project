package com.caserta.spring_security.config;

import com.caserta.spring_security.entity.Role;
import com.caserta.spring_security.entity.User;
import com.caserta.spring_security.enums.RoleType;
import com.caserta.spring_security.repository.RoleRepository;
import com.caserta.spring_security.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.beans.Transient;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        roleRepository.save(new Role(1L, RoleType.ADMIN.name()));
        roleRepository.save(new Role(2L, RoleType.BASIC.name()));

        var role = roleRepository.findByRoleType(RoleType.ADMIN.name());
        System.out.println(role.getId() + " " + role.getRoleType());

        var user = new User();
        user.setUsername("Paulo");
        user.setPassword(passwordEncoder.encode("123"));
        user.setRoles(Set.of(role));
        userRepository.save(user);

    }
}
