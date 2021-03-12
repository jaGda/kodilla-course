package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public List<Shape> getShapes() {
        return shapes;
    }

    public boolean addFigure(Shape... shape) {
        return shapes.addAll(Arrays.asList(shape));
    }

    public boolean removeFigure(Shape shape) {
        return shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n >= 0 && n < shapes.size()) return shapes.get(n);
        else throw new IndexOutOfBoundsException("wrong index or empty list");
    }

    public String showFigures() {
        return shapes.stream()
                .map(Shape::getShapeName)
                .reduce("", String::concat);
    }
}
