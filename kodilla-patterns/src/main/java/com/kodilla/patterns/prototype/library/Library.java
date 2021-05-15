package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Library extends Prototype<Library> {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book book : books) {
            clonedLibrary.getBooks().add(book.clone());
        }
        return clonedLibrary;
    }

    @Override
    public String toString() {
        return getName() + " :\n"
                + getBooks()
                .stream()
                .map(Book::toString)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Library library = (Library) o;

        if (getName() != null ? !getName().equals(library.getName()) : library.getName() != null) return false;
        return getBooks() != null ? getBooks().equals(library.getBooks()) : library.getBooks() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getBooks() != null ? getBooks().hashCode() : 0);
        return result;
    }
}
