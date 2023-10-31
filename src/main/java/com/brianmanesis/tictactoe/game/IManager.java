package com.brianmanesis.tictactoe.game;

import com.brianmanesis.tictactoe.ui.IUserInterface;

public interface IManager {
    void addObserver(IUserInterface observer);

    void notifyObservers();
}
