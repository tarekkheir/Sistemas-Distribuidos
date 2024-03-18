package com.example.demo.Services.Web;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.example.demo.Models.Club;
import java.util.List;

@Service
public class ClubService {

    private final List<Club> clubs = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Club> getAllClubs() {
        return clubs;
    }

    public Club getById(Long id) {
        for (Club club : clubs) {
            if (club.getId().equals(id)) {
                return club;
            }
        }
        return null;
    }

    public void add(Club club) {
        club.setId(idCounter++);
        clubs.add(club);
    }

    public void update(Long id, Club newClubData) {
        for (Club club : clubs) {
            if (club.getId().equals(id)) {
                club.setName(newClubData.getName());
                return;
            }
        }
    }

    public void delete(Long id) {
        clubs.removeIf(club -> club.getId().equals(id));
    }
}
