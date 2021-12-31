package com.users.users.configuration;

import com.users.users.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.jos.dem.springboot.h2.model")
@EnableJpaRepositories("com.jos.dem.springboot.h2.repository")
@Configuration
@Slf4j
public class H2Application {

    @Bean
    CommandLineRunner start(UserRepository userRepository) {
        return args -> {
            long count = userRepository.count();
            log.info("Usuarios al inicio: {}", count);
        };
    }
}
