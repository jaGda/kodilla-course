package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianAdapterTestSuit {

    @Test
    void publicationYearMedianTest() {
        // Given
        Set<Book> bookSet = Stream.of(
                        new Book("John Doe", "Blah blah", 1985, "8-page"),
                        new Book("John Smith", "Blah blah", 1965, "12-page"),
                        new Book("John Johnson", "Blah blah", 1745, "16-page"),
                        new Book("John Wiliams", "Blah blah", 2021, "24-page"),
                        new Book("John Jones", "Blah blah", 2005, "32-page"))
                .collect(Collectors.toCollection(HashSet::new));
        MedianAdapter adapter = new MedianAdapter();

        // When
        int median = adapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(median, 1985);
    }
}