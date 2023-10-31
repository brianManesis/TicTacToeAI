package com.brianmanesis.tictactoe;

import com.brianmanesis.tictactoe.build.GameBuilder;
import com.brianmanesis.tictactoe.game.GameManager;

public class TicTacToeApplication {

    public static void main(String[] args) {
        GameManager game = new GameBuilder().build();

        game.start();
    }
}
