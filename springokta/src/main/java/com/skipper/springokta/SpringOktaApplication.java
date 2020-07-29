package com.skipper.springokta;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringOktaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringOktaApplication.class, args);
    }

    @Bean
    ApplicationRunner init(CarRepository repository){
        return args -> {
            Stream.of("Ferrari", "Audi", "Jaguar", "Lamborghini", "BMW", "VW").forEach(
                    name -> {
                        Car car = new Car();
                        car.setName(name);
                        repository.save(car);
                    });
            repository.findAll().forEach(System.out::println);
        };
    }

}
