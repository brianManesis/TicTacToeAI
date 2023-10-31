package com.brianmanesis.tictactoe.build;

import com.brianmanesis.tictactoe.game.GameManager;
import com.brianmanesis.tictactoe.ui.ConsoleUI;
import com.brianmanesis.tictactoe.ui.IUserInterface;

public class GameBuilder {
    private final GameManager gameManager;
    private final IUserInterface ui;

    public GameBuilder(){
        this.gameManager = GameManager.getInstance();
        this.ui = new ConsoleUI(this.gameManager);
    }

    public GameManager build(){
        gameManager.addObserver(ui);
        return gameManager;
    }
}
