package org.example;
import java.util.Random;

public abstract class Prey extends Animal {
    public Prey(int row, int col, char symbol) {
        super(row, col, symbol);
    }

    public void move(Board board) {
        int currentX = getX();
        int currentY = getY();

        // Przesuwa ofiarę o jedno pole w losowym kierunku
        Random random = new Random();
        int dx = random.nextInt(3) - 1; // -1, 0 lub 1
        int dy = random.nextInt(3) - 1; // -1, 0 lub 1

        int newX = currentX + dx;
        int newY = currentY + dy;

        if (board.isValidPosition(newX, newY)) {
            setX(newX);
            setY(newY);
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        return true;
    }
}
