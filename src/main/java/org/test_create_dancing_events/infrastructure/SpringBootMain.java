package org.test_create_dancing_events.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.test_create_dancing_events"})
public class SpringBootMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }
}