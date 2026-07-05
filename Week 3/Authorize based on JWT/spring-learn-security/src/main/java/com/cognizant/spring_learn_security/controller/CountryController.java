package com.cognizant.spring_learn_security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn_security.model.Country;
import com.cognizant.spring_learn_security.service.CountryService;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getCountries() {

        return countryService.getAllCountries();

    }

    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code) {

        return countryService.getCountry(code);

    }

}