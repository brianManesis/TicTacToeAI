package com.brianmanesis.tictactoe.game;

import com.brianmanesis.tictactoe.constants.GameState;
import com.brianmanesis.tictactoe.constants.Symbol;
import com.brianmanesis.tictactoe.player.AIPlayer;
import com.brianmanesis.tictactoe.player.IPlayer;
import com.brianmanesis.tictactoe.player.Player;
import com.brianmanesis.tictactoe.ui.IUserInterface;

import java.util.ArrayList;
import java.util.List;

public class GameManager implements IManager{
    private static GameManager instance;
    private GameState gameState;
    private final TicTacToe board;
    private final IPlayer x;
    private final IPlayer o;
    private Symbol turn;
    private final List<IUserInterface> observers = new ArrayList<>();
    public GameManager(){
        this.gameState = GameState.ACTIVE;
        this.board = new TicTacToe();
        this.x = new Player(Symbol.X);
        this.o = new AIPlayer(Symbol.O);
        this.turn = Symbol.X;
    }
    public static GameManager getInstance() {
        if (instance == null) {
            synchronized (GameManager.class) {
                if (instance == null) {
                    instance = new GameManager();
                }
            }
        }
        return instance;
    }
    public void start(){
        while(this.gameState == GameState.ACTIVE){
            this.notifyObservers();
            IPlayer currentGo = this.turn == Symbol.X ? x:o;
            currentGo.playerMove(this);
            this.gameState = this.getGameState();
        }
    }
    public boolean gameMove(int i, int j, Symbol player){
        boolean made = this.board.boardMove(i,j,player);
        if(made){
            this.changeTurn();
        }
        return made;
    }
    public void changeTurn(){
        if(this.turn == Symbol.X) this.turn = Symbol.O;
        else this.turn = Symbol.X;
    }
    public TicTacToe getBoard(){
        return this.board;
    }
    public GameState getGameState(){
        return GameUtilities.checkGameStatus(this.board.getBoard());
    }

    @Override
    public void addObserver(IUserInterface observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (IUserInterface observer : observers) {
            observer.update();
        }
    }
}
