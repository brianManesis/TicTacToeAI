package com.brianmanesis.tictactoe.game;

import com.brianmanesis.tictactoe.constants.GameState;
import com.brianmanesis.tictactoe.constants.Symbol;
import com.brianmanesis.tictactoe.player.IPlayer;
import com.brianmanesis.tictactoe.player.Player;

public class Game {
    private GameState gameState;
    private final TicTacToe board;
    private final IPlayer x;
    private final IPlayer o;
    private Symbol turn;

    public Game(){
        this.gameState = GameState.ACTIVE;
        this.board = new TicTacToe();
        this.x = new Player();
        this.o = new Player();
        this.turn = Symbol.X;
    }
    public GameState getGameState(){
        return GameUtilities.checkGameStatus(this.board.getBoard());
    }
}
