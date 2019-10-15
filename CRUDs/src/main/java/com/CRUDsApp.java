package com;

import com.entity.Chore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class CRUDsApp {
    public static void main(String[] args) {
        SpringApplication.run(CRUDsApp.class, args);
    }

    @Repository
    public interface ChoreRepository extends JpaRepository<Chore, Long> {
    }
}
