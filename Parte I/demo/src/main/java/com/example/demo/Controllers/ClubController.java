package com.example.demo.Controllers;
import com.example.demo.Services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Models.Club;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
@RequestMapping("/club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping("/form")
    public String form() {
        return "club/clubAdd";
    }

    @GetMapping("/show")
    public String show(Model model) {
        List<Club> clubs = clubService.getAllClubs();
        model.addAttribute("clubs", clubs);
        return "club/clubs";
    }
    @GetMapping("/show/{id}")
    public String showById(@PathVariable Long id, Model model) {
        Club club = clubService.getById(id);
        model.addAttribute("club", club);
        return "club/club";
    }
    @GetMapping("/edit/{id}")
    public String editById(@PathVariable Long id, Model model) {
        Club club = clubService.getById(id);
        model.addAttribute("club", club);
        return "club/clubEdit";
    }
    @PostMapping("/add")
    public RedirectView add(Club club, Model model) {
        clubService.add(club);
        return new RedirectView("/club/show", true);
    }
    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @RequestBody Club newClub,
                         Model model) {
        Club club = clubService.getById(id);
        if (!club.getName().equals(newClub.getName())) clubService.update(id, newClub);
        model.addAttribute("club", newClub);
        return "club/club";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        clubService.delete(id);
        List<Club> clubs = clubService.getAllClubs();
        model.addAttribute("clubs", clubs);
        return "club/clubs";
    }
}