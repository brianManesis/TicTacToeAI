package com.brianmanesis.tictactoe.game;

import com.brianmanesis.tictactoe.constants.GameState;
import com.brianmanesis.tictactoe.constants.Symbol;

import java.util.HashSet;
import java.util.Set;

public class GameUtilities {
    public static final int BOARD_SIZE = 3;

    public static GameState checkGameStatus(Symbol[][] board){
        if(checkRowForWin(board, Symbol.X)) return GameState.X_WON;
        if(checkRowForWin(board, Symbol.O)) return GameState.O_WON;
        if(checkColumnForWin(board, Symbol.X)) return GameState.X_WON;
        if(checkColumnForWin(board, Symbol.O)) return GameState.O_WON;
        if(checkDiagonalForWin(board, Symbol.X)) return GameState.X_WON;
        if(checkDiagonalForWin(board, Symbol.O)) return GameState.O_WON;
        if(isFull(board)) return GameState.DRAW;

        return GameState.ACTIVE;
    }

    private static boolean checkRowForWin(Symbol[][] board, Symbol search){
        Set lookup;

        for(int i = 0; i < GameUtilities.BOARD_SIZE; i++){

            lookup = new HashSet<Symbol>();

            for(int j = 0; j < GameUtilities.BOARD_SIZE; j++){
                lookup.add(board[i][j]);
            }
            if(lookup.contains(search) && lookup.size() == 1) return true;
        }
        return false;
    }

    private static boolean checkColumnForWin(Symbol[][] board, Symbol search){
        Set lookup;

        for(int i = 0; i < GameUtilities.BOARD_SIZE; i++){

            lookup = new HashSet<Symbol>();

            for(int j = 0; j < GameUtilities.BOARD_SIZE; j++){
                lookup.add(board[j][i]);
            }
            if(lookup.contains(search) && lookup.size() == 1) return true;
        }
        return false;
    }

    private static boolean checkDiagonalForWin(Symbol[][] board, Symbol search){
        Set leftDiagonal = new HashSet<Symbol>();
        Set rightDiagonal = new HashSet<Symbol>();

        int k = GameUtilities.BOARD_SIZE-1;

        for(int i = 0; i<GameUtilities.BOARD_SIZE; i++){
            leftDiagonal.add(board[i][i]);
            rightDiagonal.add(board[k][k]);
            k--;
        }
        if(leftDiagonal.contains(search) && leftDiagonal.size() == 1) return true;
        else if(rightDiagonal.contains(search) && rightDiagonal.size() == 1) return true;

        return false;
    }
    private static boolean isFull(Symbol[][] board){
        for(int i = 0; i<GameUtilities.BOARD_SIZE; i++){
            for(int j = 0; j<GameUtilities.BOARD_SIZE; j++){
                if(board[i][j] == Symbol.Empty) return false;
            }
        }
        return true;
    }
}
