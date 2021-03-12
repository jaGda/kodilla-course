package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public List<Shape> getShapes() {
        return shapes;
    }

    public boolean addFigure(Shape... shape) {
        return false;
    }

    public boolean removeFigure(Shape shape) {
        return false;
    }

    public Shape getFigure(int n) {
        return null;
    }

    public String showFigures() {
        return null;
    }
}
