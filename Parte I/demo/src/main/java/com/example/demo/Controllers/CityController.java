package com.example.demo.Controllers;
import com.example.demo.Services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Models.City;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/form")
    public String form() {
        return "cityForm";
    }

    @GetMapping("/show")
    public String show(Model model) {
        List<City> cities = cityService.getAllCities();
        model.addAttribute("cities", cities);
        return "cities";
    }
    @GetMapping("/show/{id}")
    public String showById(@PathVariable Long id, Model model) {
        City city = cityService.getById(id);
        if (city == null) return "error";
        model.addAttribute("city", city);
        return "city";
    }
    @GetMapping("/edit/{id}")
    public String editById(@PathVariable Long id, Model model) {
        City city = cityService.getById(id);
        if (city == null) return "error";
        model.addAttribute("city", city);
        return "cityEdit";
    }
    @PostMapping("/add")
    public RedirectView add(City city, Model model) {
        cityService.add(city);
        return new RedirectView("/city/show", true);
    }
    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id,
                               @RequestBody City newCity,
                               Model model) {
        City city = cityService.getById(id);
        if (!city.getName().equals(newCity.getName())) cityService.update(id, newCity);
        model.addAttribute("city", newCity);
        return "city";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        cityService.delete(id);
        List<City> cities = cityService.getAllCities();
        model.addAttribute("cities", cities);
        return "cities";
    }
}