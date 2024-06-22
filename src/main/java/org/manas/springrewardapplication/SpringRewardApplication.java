package org.manas.springrewardapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringRewardApplication {

    public static void main(String[] args) {

        ApplicationContext con = SpringApplication.run(SpringRewardApplication.class, args);


    }

}
