package com.users.users.configuration;

import com.users.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.h2.server.web.WebServlet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EntityScan("com.users.model")
//@ComponentScan("com.users.repository")
//@EnableJpaRepositories("com.users.repository")
//@EnableJdbcRepositories
//@EnableTransactionManagement
//@EnableWebMvc
//@EnableSpringDataWebSupport
@Component
@Configuration
@Slf4j
@RequiredArgsConstructor
public class H2Application {

    private final UserRepository userRepository;


    //@Bean
    CommandLineRunner start() {
        return args -> {
            long count = userRepository.count();
            log.info("Usuarios al inicio: {}", count);
        };
    }

    @Bean
    public ServletRegistrationBean h2ConsoleServletRegistration() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new WebServlet());
        bean.addUrlMappings("/console/*");
        return bean;
    }
}
