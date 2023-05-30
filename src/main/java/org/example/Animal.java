package org.example;

public abstract class Animal extends SimElement {
    private char symbol;

    public Animal(int row, int col, char symbol) {
        super(row, col);
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract void move(Board board);
}
