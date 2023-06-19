package org.example;
import java.util.List;
import java.util.Random;

public class Hunter extends Animal {
    public Hunter(int row, int col, char symbol) {
        super(row, col, symbol);
    }

    @Override
    public void move(Board board) {
        int currentX = getX();
        int currentY = getY();

        List<Animal> animals = board.getAnimals();
        Animal closestPrey = null;
        double closestDistance = Double.MAX_VALUE;

        // Szukanie najbliższego obiektu Prey
        for (Animal animal : animals) {
            if (animal instanceof Prey) {
                double distance = calculateDistance(currentX, currentY, animal.getX(), animal.getY());
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestPrey = animal;
                }
            }
        }

        if (closestPrey != null) {
            int preyX = closestPrey.getX();
            int preyY = closestPrey.getY();

            // Obliczanie różnicy w położeniu między obiektem Hunter a obiektem Prey
            int dx = Integer.compare(preyX, currentX);
            int dy = Integer.compare(preyY, currentY);

            // Ograniczenie ruchu do maksymalnie 3 miejsc
            int maxMovement = 2;
            dx = Math.max(-maxMovement, Math.min(maxMovement, dx));
            dy = Math.max(-maxMovement, Math.min(maxMovement, dy));

            // Przesuwanie obiektu Hunter w kierunku najbliższego obiektu Prey
            int newX = currentX + dx;
            int newY = currentY + dy;

            if (board.isValidPosition(newX, newY)) {
                setX(newX);
                setY(newY);
            }
        }
    }

    private double calculateDistance(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

}