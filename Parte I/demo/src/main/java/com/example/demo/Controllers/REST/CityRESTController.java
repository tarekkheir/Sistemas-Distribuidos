package com.example.demo.Controllers.REST;
import com.example.demo.Services.REST.CityRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Models.City;

import java.util.List;


@RestController
@RequestMapping("/api/city")
public class CityRESTController {

    @Autowired
    private CityRESTService cityRESTService;
    @GetMapping("/show")
    public ResponseEntity<List<City>> show() {
        List<City> cities = cityRESTService.getAllCities();
        return ResponseEntity.status(200).body(cities);
    }
    @GetMapping("/show/{id}")
    public ResponseEntity<City> showById(@PathVariable Long id) {
        City city = cityRESTService.getCityById(id);
        if (city == null) return ResponseEntity.status(404).body(null);
        return ResponseEntity.status(200).body(city);
    }
    @PostMapping("/add")
    public ResponseEntity<City> add(@RequestBody City city) {
        City res = cityRESTService.add(city);
        if (res == null) return ResponseEntity.status(400).body(null);
        return ResponseEntity.status(201).body(res);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody City newCity) {
        Boolean patched = cityRESTService.updatePATCH(id, newCity);
        String res = patched ? "City updated successfully !"
                                : "No city found for this id or error in the request";
        if (!patched) return ResponseEntity.status(404).body(res);
        return ResponseEntity.status(201).body(res);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Boolean deleted = cityRESTService.delete(id);
        String res = deleted ? "City deleted successfully !"
                                : "No city found for this id or error in the request";
        if (!deleted) return ResponseEntity.status(404).body(res);
        return ResponseEntity.status(201).body(res);
    }
}