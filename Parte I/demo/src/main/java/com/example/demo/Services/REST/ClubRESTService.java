package com.example.demo.Services.REST;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.example.demo.Models.Club;
import java.util.List;

@Service
public class ClubRESTService {

    private final List<Club> clubs = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Club> getAllClubs() {
        return clubs;
    }

    public Club getClubById(Long id) {
        for (Club club : clubs) {
            if (club.getId().equals(id)) {
                return club;
            }
        }
        return null;
    }

    public Club add(Club club) {
        if (club.getName() == null ||
                club.getCountry() == null ||
                club.getCity() == null)
            return null;
        club.setId(idCounter++);
        clubs.add(club);
        return club;
    }

    public Boolean updatePATCH(Long id, Club newClubData) {
        if (newClubData.getName() == null) return false;
        for (Club club : clubs) {
            if (club.getId().equals(id)) {
                club.setName(newClubData.getName());
                return true;
            }
        }
        return false;
    }

    public Boolean delete(Long id) {
        int tmp = clubs.size();
        clubs.removeIf(club -> club.getId().equals(id));
        if (tmp > clubs.size()) return true;
        return false;
    }
}
