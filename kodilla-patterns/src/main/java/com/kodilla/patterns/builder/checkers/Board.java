package com.kodilla.patterns.builder.checkers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Board {

    public final static int MIN_INDEX = 0;
    public final static int MAX_INDEX = 9;
    private final Figure[][] board = new Figure[10][];

    public Board() {
        IntStream.iterate(0, n -> n + 1)
                .limit(10)
                .forEach(i -> board[i] = new Figure[10]);
    }

    public Figure getFigure(int x, int y) {
        return board[x][y];
    }

    public void setFigure(Figure figure, int x, int y) {
        board[x][y] = figure;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int n = MIN_INDEX; n <= MAX_INDEX; n++) {
            result.append("|");
            for (int k = MIN_INDEX; k <= MAX_INDEX; k++) {
                if (board[n][k] == null) {
                    result.append("  ");
                } else {
                    result.append((board[n][k]).getColor().equals(Figure.BLACK) ? "b" : "w");
                    result.append((board[n][k]) instanceof Pawn ? "P" : "Q");
                }
                result.append("|");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
