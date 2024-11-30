package org.example;

/**
 * Represents a letter with a single character value.
 */
public class Letter {

    // The letter value
    private char value;

    /**
     * Constructor to initialize the Letter object with the specified character value.
     *
     * @param value the character value of the letter.
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Gets the value of the letter.
     *
     * @return the character value of the letter.
     */
    public char getValue() {
        return value;
    }

    /**
     * Returns a string representation of the Letter object.
     *
     * @return a string representing the letter value.
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
