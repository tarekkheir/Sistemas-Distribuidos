package com.example.demo.Services;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.example.demo.Models.Country;
import java.util.List;

@Service
public class CountryService {

    private final List<Country> countries = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Country> getAllCountries() {
        return countries;
    }

    public Country getById(Long id) {
        for (Country country : countries) {
            if (country.getId().equals(id)) {
                return country;
            }
        }
        return null;
    }

    public void add(Country country) {
        country.setId(idCounter++);
        countries.add(country);
    }

    public void update(Long id, Country newCityData) {
        for (Country country : countries) {
            if (country.getId().equals(id)) {
                country.setName(newCityData.getName());
                return;
            }
        }
    }

    public void delete(Long id) {
        countries.removeIf(country -> country.getId().equals(id));
    }
}
