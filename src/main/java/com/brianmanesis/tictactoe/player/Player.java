package com.brianmanesis.tictactoe.player;

import com.brianmanesis.tictactoe.constants.Symbol;
import com.brianmanesis.tictactoe.game.GameManager;

import java.util.Scanner;
public class Player implements IPlayer{

    private final Symbol player;
    private final Scanner sc;

    public Player(Symbol player){
        this.sc = new Scanner(System.in);
        this.player = player;
    }

    public void playerMove(GameManager board){
        int row, col;
        System.out.print("Player " + this.player + ", enter your move (row and column, e.g., 1 2): ");
        if (sc.hasNextInt()) {
            row = sc.nextInt();
            if (sc.hasNextInt()) {
                col = sc.nextInt();
                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    if (board.gameMove(row, col, this.player)) {
                        return;
                    } else {
                        System.out.println("Invalid move. Try again.");
                    }
                } else {
                    System.out.println("Row and column values must be between 0 and 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter row and column as two integers.");
                sc.next(); // Clear the input buffer
            }
        } else {
            System.out.println("Invalid input. Please enter row and column as two integers.");
            sc.next(); // Clear the input buffer
        }
    }
}
