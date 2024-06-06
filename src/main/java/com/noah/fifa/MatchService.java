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

    public List<Matches> findAllMatches(){
        return mrepo.findAll();
    }

    public String getGroupWinners(String group) {
        return "";
    }

    public String getOverallWinner() {
        return "";
    }

    public List<Team> getAllTeams() {
        return null;
    }

    private Team findOrAddTeam(String teamName, String group){
        for(Team t: teams){
            if( t.getName().toLowerCase().equals(teamName.toLowerCase()) ){
                return t;
            }
        }
        return null;
    }

    public List<Team> play(){
        List<Matches> ma= mrepo.findAll();
        for(Matches m: ma){
            Team home=findOrAddTeam(m.getTeam(), m.getCategory());
            Team away=findOrAddTeam(m.getOpponent(), m.getCategory());
            playMatch(home, away, m.getGoals(), m.getGoalsOpponent());
        }
        return this.teams;
    }

    private void playMatch(Team home, Team other, int goals, int oGoals) {
        if (home != null && other != null) {
            if (oGoals > goals) {
                home.setLosses(home.getLosses() + 1);
                other.setWins(other.getWins() + 1);
            } else if (goals > oGoals) {
                home.setWins(home.getWins() + 1);
                other.setLosses(other.getLosses() + 1);
            } else {
                home.setTies(home.getTies() + 1);
                other.setTies(other.getTies() + 1);
            }
        }
    }
}