package com.webfrey.uniliga.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.webfrey.uniliga.entities.Game;
import com.webfrey.uniliga.entities.Team;
import com.webfrey.uniliga.repositories.GameRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GameService.class})
@ExtendWith(SpringExtension.class)
class GameServiceTest {
    @MockBean
    private GameRepository gameRepository;

    @Autowired
    private GameService gameService;

    @MockBean
    private TeamService teamService;

    /**
     * Method under test: {@link GameService#generateSeason()}
     */
    @Test
    void testGenerateSeason() {
        when(teamService.getTeams()).thenReturn(new ArrayList<>());
        assertTrue(gameService.generateSeason().isEmpty());
        verify(teamService).getTeams();
    }

    /**
     * Method under test: {@link GameService#generateSeason()}
     */
    @Test
    void testGenerateSeason2() {
        ArrayList<Team> teamList = new ArrayList<>();
        teamList.add(new Team());
        when(teamService.getTeams()).thenReturn(teamList);
        assertEquals(1, gameService.generateSeason().size());
        verify(teamService).getTeams();
    }

    /**
     * Method under test: {@link GameService#generateSeason()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateSeason3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.webfrey.uniliga.entities.Team.getName()" because "team1" is null
        //       at com.webfrey.uniliga.services.GameService.playNextRound(GameService.java:65)
        //       at com.webfrey.uniliga.services.GameService.generateSeason(GameService.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<Team> teamList = new ArrayList<>();
        teamList.add(null);
        when(teamService.getTeams()).thenReturn(teamList);
        gameService.generateSeason();
    }

    /**
     * Method under test: {@link GameService#generateSeason()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateSeason4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.webfrey.uniliga.entities.Team.getName()" because "team2" is null
        //       at com.webfrey.uniliga.services.GameService.playNextRound(GameService.java:66)
        //       at com.webfrey.uniliga.services.GameService.generateSeason(GameService.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<Team> teamList = new ArrayList<>();
        teamList.add(new Team());
        teamList.add(null);
        when(teamService.getTeams()).thenReturn(teamList);
        gameService.generateSeason();
    }

    /**
     * Method under test: {@link GameService#generateSeason()}
     */
    @Test
    void testGenerateSeason5() {
        ArrayList<Team> teamList = new ArrayList<>();
        teamList.add(new Team());
        teamList.add(new Team());
        teamList.add(new Team());
        when(teamService.getTeams()).thenReturn(teamList);
        assertEquals(6, gameService.generateSeason().size());
        verify(teamService).getTeams();
    }

    /**
     * Method under test: {@link GameService#saveSeason(List)}
     */
    @Test
    void testSaveSeason() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     GameService.gameRepository
        //     GameService.teamService

        gameService.saveSeason(new ArrayList<>());
    }

    /**
     * Method under test: {@link GameService#saveSeason(List)}
     */
    @Test
    void testSaveSeason2() {
        when(gameRepository.save((Game) any())).thenReturn(new Game());

        ArrayList<Game> gameList = new ArrayList<>();
        gameList.add(new Game());
        gameService.saveSeason(gameList);
        verify(gameRepository).save((Game) any());
    }

    /**
     * Method under test: {@link GameService#saveSeason(List)}
     */
    @Test
    void testSaveSeason3() {
        when(gameRepository.save((Game) any())).thenReturn(new Game());

        ArrayList<Game> gameList = new ArrayList<>();
        gameList.add(new Game());
        gameList.add(new Game());
        gameService.saveSeason(gameList);
        verify(gameRepository, atLeast(1)).save((Game) any());
    }

    /**
     * Method under test: {@link GameService#playNextRound(List, int)}
     */
    @Test
    void testPlayNextRound() {
        assertNull(gameService.playNextRound(new ArrayList<>(), 1));
        assertTrue(gameService.playNextRound(new ArrayList<>(), -1).isEmpty());
    }

    /**
     * Method under test: {@link GameService#playNextRound(List, int)}
     */
    @Test
    void testPlayNextRound2() {
        ArrayList<Team> teamList = new ArrayList<>();
        teamList.add(new Team());
        teamList.add(new Team());
        assertEquals(1, gameService.playNextRound(teamList, 1).size());
    }

    /**
     * Method under test: {@link GameService#playNextRound(List, int)}
     */
    @Test
    void testPlayNextRound3() {
        ArrayList<Team> teamList = new ArrayList<>();
        teamList.add(new Team());
        teamList.add(new Team());
        teamList.add(new Team());
        assertEquals(1, gameService.playNextRound(teamList, 1).size());
        assertEquals(3, teamList.size());
    }

    /**
     * Method under test: {@link GameService#playNextRound(List, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPlayNextRound4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.webfrey.uniliga.entities.Team.getName()" because "team1" is null
        //       at com.webfrey.uniliga.services.GameService.playNextRound(GameService.java:65)
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<Team> teamList = new ArrayList<>();
        teamList.add(null);
        teamList.add(new Team());
        gameService.playNextRound(teamList, 1);
    }

    /**
     * Method under test: {@link GameService#playNextRound(List, int)}
     */
    @Test
    void testPlayNextRound5() {
        Team team = mock(Team.class);
        when(team.getName()).thenReturn("Name");

        ArrayList<Team> teamList = new ArrayList<>();
        teamList.add(team);
        teamList.add(new Team());
        assertEquals(1, gameService.playNextRound(teamList, 1).size());
        verify(team).getName();
    }

    /**
     * Method under test: {@link GameService#playNextRound(List, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPlayNextRound6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.webfrey.uniliga.entities.Team.getName()" because "team2" is null
        //       at com.webfrey.uniliga.services.GameService.playNextRound(GameService.java:66)
        //   See https://diff.blue/R013 to resolve this issue.

        Team team = mock(Team.class);
        when(team.getName()).thenReturn("Name");

        ArrayList<Team> teamList = new ArrayList<>();
        teamList.add(team);
        teamList.add(null);
        gameService.playNextRound(teamList, 1);
    }
}

