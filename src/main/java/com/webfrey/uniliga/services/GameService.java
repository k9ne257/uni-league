package com.webfrey.uniliga.services;

import com.webfrey.uniliga.entities.Game;
import com.webfrey.uniliga.entities.Team;
import com.webfrey.uniliga.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamService teamService;


    public List<Game> generateSeason(){
        List<Game> games = new ArrayList<Game>();

        List<Team> teams = teamService.getTeams();

        if (teams.size() % 2 == 1) {
            Team dummyTeam = new Team();
            dummyTeam.setName("Dummy");
            teams.add(dummyTeam);
        }

        int currentRound = 1;

        for (int i = 1; i <= teams.size() - 1; i++) {
            games.addAll(playNextRound(teams, currentRound));
            currentRound++;
        }
        return games;
    }

    void saveSeason(List<Game> games){
        games.forEach(game -> gameRepository.save(game));
    }

    public List<Game> playNextRound(List<Team> teams, int currentRound) {
        int numRounds = teams.size() - 1;

        if (currentRound > numRounds) {
            System.out.println("Tournament is over.");
            return null;
        }

        System.out.println("Round " + currentRound + ":");

        List<Game> gameList = new ArrayList<>();
        for (int i = 0; i < teams.size() / 2; i++) {
            int j = teams.size() - 1 - i;
            Team team1 = teams.get(i);
            Team team2 = teams.get(j);
            Game game = new Game();

            game.setTeam_A(team1.getName());
            game.setTeam_B(team2.getName());
            game.setDate(LocalDate.now());
            game.setReferee("Ke");
            game.setTime(LocalTime.now());
            gameList.add(game);
//            System.out.println(team1.getName() + " vs. " + team2.getName());
            // Play the game and record the results, if desired
        }
        rotateTeams(teams);
        return gameList;
    }

    private List<Team>  rotateTeams(List<Team> teams) {
        if (teams.size() < 3) {
            return teams;
        }

        Team temp = teams.get(1);
        teams.set(1, teams.get(teams.size() - 1));
        for (int i = teams.size() - 1; i > 1; i--) {
            teams.set(i, teams.get(i - 1));
        }
        teams.set(2, temp);
        return teams;
    }

}
