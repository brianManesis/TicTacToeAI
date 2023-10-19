package com.brianmanesis.tictactoe.ui;

public interface IUserInterface {

    interface EventListener{
        void moveMade();
    }
    interface View{
        void display();
    }
}
