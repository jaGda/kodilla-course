package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Java", text -> text.concat(" world"));
        poemBeautifier.beautify("Java", String::toUpperCase);
        poemBeautifier.beautify("Java", "What is "::concat);
        poemBeautifier.beautify("Java", "Why "::concat);
    }
}
