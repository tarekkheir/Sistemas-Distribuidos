package com.example.demo.Services.Web;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.example.demo.Models.City;
import java.util.List;

@Service
public class CityService {

    private final List<City> cities = new ArrayList<>();
    private Long idCounter = 1L;

    public List<City> getAllCities() {
        return cities;
    }

    public City getById(Long id) {
        for (City city : cities) {
            if (city.getId().equals(id)) {
                return city;
            }
        }
        return null;
    }

    public void add(City city) {
        city.setId(idCounter++);
        cities.add(city);
    }

    public void update(Long id, City newCityData) {
        for (City city : cities) {
            if (city.getId().equals(id)) {
                city.setName(newCityData.getName());
                return;
            }
        }
    }

    public void delete(Long id) {
        cities.removeIf(city -> city.getId().equals(id));
    }
}
