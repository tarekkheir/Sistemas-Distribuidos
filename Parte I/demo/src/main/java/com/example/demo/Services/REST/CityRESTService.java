package com.example.demo.Services.REST;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.example.demo.Models.City;
import java.util.List;

@Service
public class CityRESTService {

    private final List<City> cities = new ArrayList<>();
    private Long idCounter = 1L;

    public List<City> getAllCities() {
        return cities;
    }

    public City getCityById(Long id) {
        for (City city : cities) {
            if (city.getId().equals(id)) {
                return city;
            }
        }
        return null;
    }

    public City add(City city) {
        if (city.getName() == null || city.getCountry() == null) return null;
        city.setId(idCounter++);
        cities.add(city);
        return city;
    }

    public Boolean updatePATCH(Long id, City newCityData) {
        if (newCityData.getName() == null) return false;
        for (City city : cities) {
            if (city.getId().equals(id)) {
                city.setName(newCityData.getName());
                return true;
            }
        }
        return false;
    }

    public Boolean delete(Long id) {
        int tmp = cities.size();
        cities.removeIf(city -> city.getId().equals(id));
        if (tmp > cities.size()) return true;
        return false;
    }
}
