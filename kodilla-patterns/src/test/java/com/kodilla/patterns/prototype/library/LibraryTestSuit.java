package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTestSuit {

    @Test
    void testGetBook() {
        //Given
        //creating the library and assigning the books
        Library library = new Library("National Library");
        Book book1 = new Book(
                "W pustyni i w puszczy",
                "Henryk Sienkiewicz",
                LocalDate.of(1911, 1, 13)
        );
        Book book2 = new Book(
                "Pan Tadeusz",
                "Adam Mickiewicz",
                LocalDate.of(1834, 6, 28)
        );
        Book book3 = new Book(
                "Kordian",
                "Juliusz Slowacki",
                LocalDate.of(1834, 3, 4)
        );

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        //making a shallow copy of object library
        Library shallowCopy = null;
        try {
            shallowCopy = library.clone();
            shallowCopy.setName("National Library(shallow copy)");
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        //making a deep copy of object library
        Library deepCopy = null;
        try {
            deepCopy = library.deepCopy();
            deepCopy.setName("National Library(deep copy)");
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        //When
        library.getBooks().remove(book1);
        //Then
        System.out.println(library);
        System.out.println(shallowCopy);
        System.out.println(deepCopy);
        assertEquals(2, library.getBooks().size());
        assert shallowCopy != null;
        assertEquals(2, shallowCopy.getBooks().size());
        assert deepCopy != null;
        assertEquals(3, deepCopy.getBooks().size());
        assertEquals(shallowCopy.getBooks(), library.getBooks());
        assertNotEquals(shallowCopy.getBooks(), deepCopy.getBooks());
    }
}