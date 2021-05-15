package com.kodilla.patterns.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeFactoryTestSuit {

    private final ShapeFactory shapeFactory = new ShapeFactory();

    @Test
    void testFactoryCircle() {
        //Given
        //When
        Shape circle = shapeFactory.makeShape(ShapeFactory.CIRCLE);
        //Then
        assert circle != null;
        assertEquals(Math.PI * Math.pow(4.50, 2.0), circle.getArea(), 0);
        assertEquals("The rounded circle", circle.getName());
    }

    @Test
    void testFactorySquare() {
        //Given
        //When
        Shape square = shapeFactory.makeShape(ShapeFactory.SQUARE);
        //Then
        assert square != null;
        assertEquals(28.0, square.getCircumference(), 0);
        assertEquals("The angular square", square.getName());
    }

    @Test
    void testFactoryRectangle() {
        //Given
        //When
        Shape rectangle = shapeFactory.makeShape(ShapeFactory.RECTANGLE);
        //Then
        assert rectangle != null;
        assertEquals(37.50, rectangle.getArea(), 0);
        assertEquals("The long rectangle", rectangle.getName());
    }
}