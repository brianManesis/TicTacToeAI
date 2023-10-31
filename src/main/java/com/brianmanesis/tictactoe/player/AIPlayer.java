package com.brianmanesis.tictactoe.player;

import com.brianmanesis.tictactoe.constants.GameState;
import com.brianmanesis.tictactoe.constants.Symbol;
import com.brianmanesis.tictactoe.game.GameManager;
import com.brianmanesis.tictactoe.game.GameUtilities;
import com.brianmanesis.tictactoe.game.TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class AIPlayer implements IPlayer{

    private final Symbol player;
    private static class Move {
        private final int row;
        private final int col;

        public Move(int i, int j){
            row = i;
            col = j;
        }
        public int getRow(){
            return this.row;
        }

        public int getCol(){
            return this.col;
        }
    }
    public AIPlayer(Symbol symbol) {
        this.player = symbol;
    }
    @Override
    public void playerMove(GameManager gameManager) {
        TicTacToe game = GameUtilities.getCopyOfGameBoard();
        Move bestMove = getBestMove(game, this.player);
        if (bestMove != null) {
            gameManager.gameMove(bestMove.getRow(), bestMove.getCol(), this.player);
        }
    }

    private Move getBestMove(TicTacToe game, Symbol playerSymbol) {
        Move bestMove = null;
        int bestScore = Integer.MIN_VALUE;
        List<Move> availableMoves = getAvailableMoves(game);
        Symbol opponent = playerSymbol == Symbol.X? Symbol.O:Symbol.X;
        for (Move move : availableMoves) {
            game.boardMove(move.getRow(), move.getCol(), playerSymbol);
            int score = miniMax(game, 0, false, opponent);
            game.undoMove(move.getRow(), move.getCol());

            if (score > bestScore) {
                bestScore = score;
                bestMove = move;
            }
        }
        return bestMove;
    }

    private int miniMax(TicTacToe game, int depth, boolean isMaximizingPlayer, Symbol playerSymbol) {
        GameState gameState = GameUtilities.checkGameStatus(game.getBoard());
        GameState playerWon = playerSymbol == Symbol.X? GameState.X_WON:GameState.O_WON;
        GameState opponentWon = playerSymbol == Symbol.X? GameState.O_WON:GameState.X_WON;
        if (gameState == playerWon) {
            return 10 - depth; // Adjust score based on depth
        } else if (gameState == opponentWon) {
            return depth - 10; // Adjust score based on depth
        } else if (gameState == GameState.DRAW) {
            return 0;
        }

        int bestScore = isMaximizingPlayer ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        Symbol opponentSymbol = playerSymbol == Symbol.X? Symbol.O: Symbol.X;

        List<Move> availableMoves = getAvailableMoves(game);

        for (Move move : availableMoves) {
            game.boardMove(move.getRow(), move.getCol(), playerSymbol);
            int score = miniMax(game, depth + 1, !isMaximizingPlayer, opponentSymbol);
            game.undoMove(move.getRow(), move.getCol());

            bestScore = isMaximizingPlayer ? Math.max(score, bestScore) : Math.min(score, bestScore);
        }
        return bestScore;
    }

    private List<Move> getAvailableMoves(TicTacToe board) {
        List<Move> availableMoves = new ArrayList<>();
        Symbol[][] currentBoard = board.getBoard();

        for (int i = 0; i < GameUtilities.BOARD_SIZE; i++) {
            for (int j = 0; j < GameUtilities.BOARD_SIZE; j++) {
                if (currentBoard[i][j] == Symbol.Empty) {
                    availableMoves.add(new Move(i, j));
                }
            }
        }
        return availableMoves;
    }
}
