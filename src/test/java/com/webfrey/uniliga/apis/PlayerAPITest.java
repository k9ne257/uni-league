package com.webfrey.uniliga.apis;

import static org.mockito.Mockito.mock;

import com.webfrey.uniliga.entities.Player;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PlayerAPITest {
    /**
     * Method under test: {@link PlayerAPI#getAllPlayer()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPlayer() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new PlayerAPI()).getAllPlayer();
    }

    /**
     * Method under test: {@link PlayerAPI#getPlayerById(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPlayerById() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new PlayerAPI()).getPlayerById(1);
    }

    /**
     * Method under test: {@link PlayerAPI#getPlayerByName(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPlayerByName() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new PlayerAPI()).getPlayerByName("Name");
    }

    /**
     * Method under test: {@link PlayerAPI#insertPlayer(Player)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInsertPlayer() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        PlayerAPI playerAPI = new PlayerAPI();
        playerAPI.insertPlayer(new Player(1, "Name", "Nick Name", "Team", 1));
    }

    /**
     * Method under test: {@link PlayerAPI#insertPlayer(Player)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInsertPlayer2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new PlayerAPI()).insertPlayer(mock(Player.class));
    }
}

