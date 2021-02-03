package com.example.producingwebservice.repository;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData(){
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(34290843);

        countries.put(spain.getName(),spain);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(439084569);
        countries.put(uk.getName(),uk);


        Country brazil = new Country();
        brazil.setName("Brazil");
        brazil.setCapital("Brasilia");
        brazil.setCurrency(Currency.EUR);
        brazil.setPopulation(253543543);
        countries.put(brazil.getName(),brazil);
    }

    public Country findCountry(String name){
        Assert.notNull(name,"The country name must not be null");
        return countries.get(name);
    }
}
