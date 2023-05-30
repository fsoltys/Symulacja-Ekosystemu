package org.example;
import java.util.Random;

public class Hunter extends Animal {
    public Hunter(int row, int col, char symbol) {
        super(row, col, symbol);
    }

    @Override
    public void move(Board board) {
        int currentX = getX();
        int currentY = getY();

        // Przesuwa drapieżnika o jedno pole w losowym kierunku
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
}
