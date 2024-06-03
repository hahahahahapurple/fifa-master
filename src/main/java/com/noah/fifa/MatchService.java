package com.noah.fifa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {
    @Autowired
    private MatchRepo mrepo;

    private List<Team> teams = new ArrayList<Team>();

    public String getGroupWinners(String group) {
        return "";
    }

    public String getOverallWinner() {
        return "";
    }

    public List<Team> getAllTeams() {
        return null;
    }

    private Team findOrAddTeam(String teamName) {
        return null;
    }

    private void playMatch(Team home, Team other, int goals, int oGoals) {
        if(oGoals > goals) {
            home.setLosses(home.getLosses() - 1);
            other.setWins(other.getWins() + 1);
        } else if (oGoals < goals) {
            home.setWins(home.getWins() + 1);
            other.setLosses(other.getLosses() - 1);
        } else {
            home.setTies(home.getTies() + 1);
            other.setTies(other.getTies() + 1);
        }
    }
}
