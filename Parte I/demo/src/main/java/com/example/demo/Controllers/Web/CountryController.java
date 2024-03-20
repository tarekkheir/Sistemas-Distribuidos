package com.example.demo.Controllers.Web;
import com.example.demo.Models.City;
import com.example.demo.Services.Web.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Models.Country;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/form")
    public String form() {
        return "country/countryAdd";
    }

    @GetMapping("/show")
    public String show(Model model) {
        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        return "country/countries";
    }
    @GetMapping("/show/{id}")
    public String showById(@PathVariable Long id, Model model) {
        Country country = countryService.getById(id);
        if (country == null) return "error";
        model.addAttribute("country", country);
        return "country/country";
    }
    @GetMapping("/edit/{id}")
    public String editById(@PathVariable Long id, Model model) {
        Country country = countryService.getById(id);
        if (country == null) return "error";
        model.addAttribute("country", country);
        return "country/countryEdit";
    }
    @PostMapping("/add")
    public RedirectView add(Country country, Model model) {
        countryService.add(country);
        return new RedirectView("/country/show", true);
    }
    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @RequestBody Country newCountry,
                         Model model) {
        Country country = countryService.getById(id);
        if (!country.getName().equals(newCountry.getName())) countryService.update(id, newCountry);
        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        return "country/countries";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        countryService.delete(id);
        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        return "country/countries";
    }
}