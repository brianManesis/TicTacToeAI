package com.brianmanesis.tictactoe.game;

import com.brianmanesis.tictactoe.constants.Symbol;

public class TicTacToe {

    private final Symbol[][] board;
    public TicTacToe(){
        this.board = TicTacToe.initializeBoard();
    }
    public TicTacToe(Symbol[][] board){this.board = board;}
    public static Symbol[][] initializeBoard() {
        Symbol[][] board = new Symbol[GameUtilities.BOARD_SIZE][GameUtilities.BOARD_SIZE];
        for(int i = 0; i<GameUtilities.BOARD_SIZE; i++){
            for(int j = 0; j<GameUtilities.BOARD_SIZE; j++) board[i][j] = Symbol.Empty;
        }
        return board;
    }
    public boolean boardMove(int i, int j, Symbol player){
        if(i>2 || i<0 || j>2 || j<0) return false;
        if(board[i][j] != Symbol.Empty) return false;
        board[i][j] = player;
        return true;
    }
    public boolean undoMove(int i, int j){
        if(i>2 || i<0 || j>2 || j<0) return false;
        if(board[i][j] == Symbol.Empty) return false;
        board[i][j] = Symbol.Empty;
        return true;
    }
    public Symbol[][] getBoard() {
        return this.board;
    }
}
