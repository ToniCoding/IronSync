package dev.ironsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IronSyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(IronSyncApplication.class, args);
    }
}