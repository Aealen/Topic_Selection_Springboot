package me.aowu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class TsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TsApplication.class, args);
    }

}
