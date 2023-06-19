package org.example;

public abstract class Animal extends SimElement {
    private final char symbol;

    public Animal(int x, int y, char symbol) {
        super(x, y);
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }


    public abstract void move(Board board);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Animal other = (Animal) obj;
        return getX() == other.getX() && getY() == other.getY();
    }
}

