package com.example.demo.Controllers.REST;
import com.example.demo.Models.City;
import com.example.demo.Services.REST.ClubRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Models.Club;

import java.util.List;


@RestController
@RequestMapping("/api/club")
public class ClubRESTController {

    @Autowired
    private ClubRESTService clubRESTService;
    @GetMapping("/show")
    public ResponseEntity<List<Club>> show() {
        List<Club> clubs = clubRESTService.getAllClubs();
        return ResponseEntity.status(200).body(clubs);
    }
    @GetMapping("/show/{id}")
    public ResponseEntity<Club> showById(@PathVariable Long id) {
        Club club = clubRESTService.getClubById(id);
        if (club == null) return ResponseEntity.status(404).body(null);
        return ResponseEntity.status(200).body(club);
    }
    @PostMapping("/add")
    public ResponseEntity<Club> add(@RequestBody Club club) {
        Club res = clubRESTService.add(club);
        if (res == null) return ResponseEntity.status(400).body(null);
        return ResponseEntity.status(201).body(res);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Club newClub) {
        Boolean patched = clubRESTService.updatePATCH(id, newClub);
        String res = patched ? "Club updated successfully !"
                                : "No club found for this id or error in the request";
        if (!patched) return ResponseEntity.status(404).body(res);
        return ResponseEntity.status(201).body(res);
    }
        @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Boolean deleted = clubRESTService.delete(id);
        String res = deleted ? "Club deleted successfully !"
                                : "No club found for this id or error in the request";
        if (!deleted) return ResponseEntity.status(404).body(res);
        return ResponseEntity.status(201).body(res);
    }
}