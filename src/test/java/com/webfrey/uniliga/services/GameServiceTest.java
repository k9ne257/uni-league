package com.webfrey.uniliga.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.webfrey.uniliga.entities.Team;
import com.webfrey.uniliga.repositories.GameRepository;

import java.util.ArrayList;

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
}

