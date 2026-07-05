package com.cognizant.spring_learn_security.service;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn_security.model.Country;

@Service
public class CountryService {

    @SuppressWarnings("unchecked")
    public ArrayList<Country> getAllCountries() {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        ArrayList<Country> list =
                (ArrayList<Country>) context.getBean("countryList");

        context.close();

        return list;
    }

    public Country getCountry(String code) {

        for (Country country : getAllCountries()) {

            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }

        }

        return null;
    }
}