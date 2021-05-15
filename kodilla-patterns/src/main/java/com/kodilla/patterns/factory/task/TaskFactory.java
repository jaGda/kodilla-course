package com.kodilla.patterns.factory.task;

public final class TaskFactory {
    public static final String SHOPPING = "SHOPPING_TASK";
    public static final String PAINTING = "PAINTING_TASK";
    public static final String DRIVING = "DRIVING_TASK";

    public final Task makeShape(final String task) {
        switch (task) {
            case SHOPPING:
                return new ShoppingTask("Buy vegetables", "carrots", 4.5);
            case PAINTING:
                return new PaintingTask("Paint the wall", "grey", "bedroom wall");
            case DRIVING:
                return new DrivingTask("Drive to Warsaw", "Warsaw", "train");
            default:
                return null;
        }
    }
}
