package be.pxl.rct;

import be.pxl.rct.engine.GameEngine;

import java.util.Scanner;

public class RollercoasterTycoon {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        GameEngine gameEngine = new GameEngine();
        gameEngine.init();
        gameEngine.start();
        while (gameEngine.isRunning()) {
            System.out.print("rct> ");
            gameEngine.executeCommand(keyboard.nextLine());
        }
    }
}
