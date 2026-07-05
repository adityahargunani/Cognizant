package com.cognizant.spring_learn;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(SpringLearnApplication.class, args);

        displayCountries();
    }

    public static void displayCountries() {

        LOGGER.debug("START");

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        ArrayList<Country> list =
                (ArrayList<Country>) context.getBean("countryList");

        for (Country country : list) {
            LOGGER.debug(country.toString());
        }

        context.close();

        LOGGER.debug("END");
    }
}