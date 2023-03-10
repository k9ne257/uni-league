package com.webfrey.uniliga;

import com.webfrey.uniliga.entities.Team;
import com.webfrey.uniliga.repositories.GameRepository;
import com.webfrey.uniliga.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RoundRobinTournament {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamService teamService;

    private List<Team> teams;
    private int numRounds;
    private int currentRound;

    public RoundRobinTournament(List<Team> teams) {
        if (teams.size() % 2 == 1) {
            Team dummyTeam = new Team();
            dummyTeam.setName("Dummy");
            teams.add(dummyTeam);
        }
        this.teams = teams;
        this.numRounds = teams.size() - 1;
        this.currentRound = 1;
    }

    public void playNextRound() {
        if (currentRound > numRounds) {
            System.out.println("Tournament is over.");
            return;
        }
        System.out.println("Round " + currentRound + ":");
        for (int i = 0; i < teams.size() / 2; i++) {
             int j = teams.size() - 1 - i;
            Team team1 = teams.get(i);
            Team team2 = teams.get(j);
            System.out.println(team1.getName() + " vs. " + team2.getName());
            // Play the game and record the results, if desired
        }
        rotateTeams();
        currentRound++;
    }

    private void rotateTeams() {
        if (teams.size() < 3) {
            return;
        }
        Team temp = teams.get(1);
        teams.set(1, teams.get(teams.size() - 1));
        for (int i = teams.size() - 1; i > 1; i--) {
            teams.set(i, teams.get(i - 1));
        }
        teams.set(2, temp);
    }


    public static void main(String[] args) {
        List<Team> teams = new ArrayList<>();
        for(int i = 1; i<=8 ; i++){
            Team team = new Team();
            team.setName("Team " + i);
            teams.add(team);
        }

        RoundRobinTournament tournament = new RoundRobinTournament(teams);
        for (int i = 1; i <= tournament.numRounds; i++) {
            tournament.playNextRound();
        }
    }

}
