package ru.GlobalListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("ru.GlobalListener")
@EnableJpaRepositories
@Configuration
public class Starter {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Starter.class, args);
        ListenersInitializer initializer = context.getBean(ListenersInitializer.class);
        initializer.initListeners();
    }
}
