package com.example.demo.Services.REST;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.example.demo.Models.Country;
import java.util.List;

@Service
public class CountryRESTService {

    private final List<Country> countries = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Country> getAllCountries() {
        return countries;
    }

    public Country getCountryById(Long id) {
        for (Country country : countries) {
            if (country.getId().equals(id)) {
                return country;
            }
        }
        return null;
    }

    public Country add(Country country) {
        if (country.getName() == null) return null;
        country.setId(idCounter++);
        countries.add(country);
        return country;
    }

    public Boolean updatePATCH(Long id, Country newCountryData) {
        if (newCountryData.getName() == null) return false;
        for (Country country : countries) {
            if (country.getId().equals(id)) {
                country.setName(newCountryData.getName());
                return true;
            }
        }
        return false;
    }

    public Boolean delete(Long id) {
        int tmp = countries.size();
        countries.removeIf(country -> country.getId().equals(id));
        if (tmp > countries.size()) return true;
        return false;
    }
}
