package rct.engine;

import be.pxl.rct.engine.GameEngine;
import be.pxl.rct.exceptions.CommandNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameEngineQuitHelpTest {

    @Test
    public void quitGameEngineSetRunningToFalse() throws CommandNotFoundException {
        GameEngine gameEngine = new GameEngine();
        assertTrue(gameEngine.isRunning());
        gameEngine.executeCommand("quit");

        assertFalse(gameEngine.isRunning());
    }
}