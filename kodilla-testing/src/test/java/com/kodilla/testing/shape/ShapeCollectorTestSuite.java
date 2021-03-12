package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: Shape collector test suite")
public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeEach
    void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.\n");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Nested
    @DisplayName("Tests adding elements to collection.")
    class TestsAddingElementsToCollection {
        @Test
        void testAddElement() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            boolean addCircle = shapeCollector.addFigure(new Circle(1));
            boolean addSquare = shapeCollector.addFigure(new Square(1));
            boolean addTriangle = shapeCollector.addFigure(new Triangle(1, 1));
            //Then
            assertAll(
                    () -> assertTrue(addCircle),
                    () -> assertTrue(addSquare),
                    () -> assertTrue(addTriangle),
                    () -> assertEquals(3, shapeCollector.getShapes().size())
            );
        }
    }

    @Nested
    @DisplayName("Tests removing elements from collection.")
    class TestsRemovingElementsFromCollection {
        @Test
        void testRemoveElement() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(2);
            Shape square = new Square(3);
            Shape triangle = new Triangle(2, 3);
            shapeCollector.addFigure(circle, square, triangle);
            //When
            boolean removeCircle = shapeCollector.removeFigure(circle);
            boolean removeSquare = shapeCollector.removeFigure(square);
            boolean removeTriangle = shapeCollector.removeFigure(triangle);
            //Then
            assertAll(
                    () -> assertTrue(removeCircle),
                    () -> assertTrue(removeTriangle),
                    () -> assertTrue(removeSquare),
                    () -> assertEquals(0, shapeCollector.getShapes().size())
            );
        }
    }

    @Nested
    @DisplayName("Tests getting elements from collection.")
    class TestsGettingElementsFromCollection {
        @Test
        void testGetElement() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(2);
            Shape square = new Square(3);
            Shape triangle = new Triangle(2, 3);
            shapeCollector.addFigure(circle, square, triangle);
            //When
            Shape shapeCircle = shapeCollector.getFigure(0);
            Shape shapeSquare = shapeCollector.getFigure(1);
            Shape shapeTriangle = shapeCollector.getFigure(2);

            //Then
            assertAll(
                    () -> assertEquals(circle.getShapeName(), shapeCircle.getShapeName()),
                    () -> assertEquals(square.getShapeName(), shapeSquare.getShapeName()),
                    () -> assertEquals(triangle.getShapeName(), shapeTriangle.getShapeName())
            );
        }

        @Test
        void testArrayBoundException() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(2);
            //When
            Exception exception = assertThrows(IndexOutOfBoundsException.class, () ->
                    shapeCollector.getFigure(1));
            //Then
            assertEquals("wrong index or empty list", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Tests showing names of collection elements.")
    class TestsShowingNamesOfCollectionItems {
        @Test
        void testShowNamesOfShapes() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(2);
            Shape square = new Square(3);
            Shape triangle = new Triangle(2, 3);
            shapeCollector.addFigure(circle, square, triangle);
            //When
            String result = shapeCollector.showFigures();
            String expectedResult = "CIRCLESQUARETRIANGLE";
            //Then
            assertEquals(expectedResult, result);
        }

    }
}
