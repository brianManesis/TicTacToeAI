package com.brianmanesis.tictactoe.game;

import com.brianmanesis.tictactoe.constants.Symbol;

public class TicTacToe {

    private final Symbol[][] board;

    public TicTacToe(){
        this.board = TicTacToe.initializeBoard();
    }

    public static Symbol[][] initializeBoard() {
        return new Symbol[GameUtilities.BOARD_SIZE][GameUtilities.BOARD_SIZE];
    }

    public Symbol[][] getBoard() {
        return this.board;
    }
}
