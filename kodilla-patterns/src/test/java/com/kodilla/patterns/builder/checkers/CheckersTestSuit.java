package com.kodilla.patterns.builder.checkers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckersTestSuit {

    @Test
    void testCheckerBuilder() {
        //Given
        Checkers checkers = new Checkers.CheckersBuilder()
                .PlayerOne("John")
                .PlayerTwo("Theresa")
                .Figure(FigureFactory.PAWN, Figure.WHITE, 0, 3)
                .Figure(FigureFactory.QUEEN, Figure.WHITE, 9, 7)
                .Figure(FigureFactory.PAWN, Figure.BLACK, 0, 2)
                .build();
        System.out.println(checkers.getBoard());

        //When
        Figure figureOne = checkers.getBoard().getFigure(0, 3);
        Figure figureTwo = checkers.getBoard().getFigure(9, 7);
        Figure figureThree = checkers.getBoard().getFigure(0, 2);
        Figure figureFour = checkers.getBoard().getFigure(1, 1);

        //Then
        assertAll(
                () -> assertEquals(Figure.WHITE, figureOne.getColor()),
                () -> assertEquals(Figure.WHITE, figureTwo.getColor()),
                () -> assertEquals(Figure.BLACK, figureThree.getColor()),
                () -> assertNull(figureFour)
        );
    }
}