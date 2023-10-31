package com.brianmanesis.tictactoe.ui;

import com.brianmanesis.tictactoe.constants.GameState;
import com.brianmanesis.tictactoe.constants.Symbol;
import com.brianmanesis.tictactoe.game.GameManager;

public class ConsoleUI implements IUserInterface{
    private final GameManager gameBoard;

    public ConsoleUI(GameManager gameBoard){
        this.gameBoard = gameBoard;
    }
    @Override
    public void update() {
        display();
    }
    public void display(){
        GameState state = gameBoard.getGameState();
        if(state == GameState.ACTIVE) this.displayBoard();
        else displayGameResult(state);
    }

    public void displayBoard(){
        Symbol[][] board = GameManager.getInstance().getBoard().getBoard();
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                if(board[row][col] == Symbol.Empty) System.out.print(" " + " | ");

                else System.out.print(board[row][col] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    public void displayGameResult(GameState result){
        System.out.println(result);
    }
}
