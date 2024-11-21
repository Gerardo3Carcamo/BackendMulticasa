package com.multicasa.multicasabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories("com.multicasa.multicasabackend.Repositories")
public class MulticasaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MulticasaBackendApplication.class, args);
    }

}
