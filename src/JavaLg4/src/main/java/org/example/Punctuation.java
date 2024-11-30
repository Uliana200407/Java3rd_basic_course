package org.example;

/**
 * Represents a punctuation symbol with a single character value.
 */
public class Punctuation {

    // The punctuation symbol
    private char symbol;

    /**
     * Constructor to initialize the Punctuation object with the specified symbol.
     *
     * @param symbol the character representing the punctuation symbol.
     */
    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Gets the value of the punctuation symbol.
     *
     * @return the character value of the punctuation symbol.
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Returns a string representation of the Punctuation object.
     *
     * @return a string representing the punctuation symbol.
     */
    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
