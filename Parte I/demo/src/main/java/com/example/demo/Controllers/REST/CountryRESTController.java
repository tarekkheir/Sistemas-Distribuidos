package com.example.demo.Controllers.REST;
import com.example.demo.Models.Club;
import com.example.demo.Services.REST.CountryRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Models.Country;

import java.util.List;


@RestController
@RequestMapping("/api/country")
public class CountryRESTController {

    @Autowired
    private CountryRESTService countryRESTService;
    @GetMapping("/show")
    public ResponseEntity<List<Country>> show() {
        List<Country> countries = countryRESTService.getAllCountries();
        return ResponseEntity.status(200).body(countries);
    }
    @GetMapping("/show/{id}")
    public ResponseEntity<Country> showById(@PathVariable Long id) {
        Country country = countryRESTService.getCountryById(id);
        if (country == null) return ResponseEntity.status(404).body(null);
        return ResponseEntity.status(200).body(country);
    }
    @PostMapping("/add")
    public ResponseEntity<Country> add(@RequestBody Country country) {
        Country res = countryRESTService.add(country);
        if (res == null) return ResponseEntity.status(400).body(null);
        return ResponseEntity.status(201).body(res);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Country newCountry) {
        Boolean patched = countryRESTService.updatePATCH(id, newCountry);
        String res = patched ? "Country updated successfully !"
                                : "No country found for this id or error in the request";
        if (!patched) return ResponseEntity.status(404).body(res);
        return ResponseEntity.status(201).body(res);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Boolean deleted = countryRESTService.delete(id);
        String res = deleted ? "Country deleted successfully !"
                                : "No country found for this id or error in the request";
        if (!deleted) return ResponseEntity.status(404).body(res);
        return ResponseEntity.status(201).body(res);
    }
}