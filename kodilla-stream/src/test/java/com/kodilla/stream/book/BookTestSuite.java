package com.kodilla.stream.book;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookTestSuite {

    @Test
    void testGetListUsingFor() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        long numberOfBooksPublishedAfter2007 = books.stream()
                .mapToInt(Book::getYearOfPublication)
                .filter(n -> n > 2007)
                .count();
        assertEquals(3, numberOfBooksPublishedAfter2007);
    }
}