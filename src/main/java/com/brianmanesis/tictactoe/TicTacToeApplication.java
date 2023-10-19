package com.brianmanesis.tictactoe;

import com.brianmanesis.tictactoe.constants.Symbol;
import com.brianmanesis.tictactoe.game.GameUtilities;

public class TicTacToeApplication {

    public static void main(String[] args) {
        System.out.println(GameUtilities.checkGameStatus(new Symbol[][] {
                {Symbol.O,Symbol.O,Symbol.X},
                {Symbol.X,Symbol.X,Symbol.O},
                {Symbol.O,Symbol.X,Symbol.O}
        }));
    }
}
