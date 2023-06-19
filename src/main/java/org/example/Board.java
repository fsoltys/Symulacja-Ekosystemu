package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board {
    private char[][] cells;
    private List<Animal> animals;

    public Board(int width, int height) {
        cells = new char[width][height];
        animals = new ArrayList<>();

        // Initialize all cells with empty value
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = 'O';
            }
        }
    }

    // Method to place an animal on the board
    public void placeAnimal(Animal animal) {
        int x = animal.getX();
        int y = animal.getY();

        if (isValidPosition(x, y)) {
            cells[x][y] = animal.getSymbol();
            animals.add(animal);
        }
    }

    // Public method to check if a position is valid on the board
    public boolean isValidPosition(int x, int y) {
        int width = cells.length;
        int height = cells[0].length;

        return x >= 0 && x < width && y >= 0 && y < height;
    }

    // Method to get the coordinates of all animals on the board
    public List<Animal> getAnimals() {
        return animals;
    }

    // Method to update the board state
    public void updateBoard() {
        // Clear the board
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = 'O';
            }
        }

        // Update the board with animal positions
        for (Animal animal : animals) {
            int x = animal.getX();
            int y = animal.getY();

            if (isValidPosition(x, y)) {
                cells[x][y] = animal.getSymbol();
            }
        }

        // Process hunter-prey interactions

        for (int i = 0; i< animals.size(); ++i) {
            Animal animal = animals.get(i);
            int x = animal.getX();
            int y = animal.getY();

            if (animal instanceof Hunter) {
                // Check if there is a prey at the same coordinates
                for (int j = 0; j<animals.size(); ++j) {
                    Animal otherAnimal = animals.get(j);
                    if (otherAnimal != animal && otherAnimal instanceof Prey && otherAnimal.getX() == x && otherAnimal.getY() == y) {
                        // Hunter eats the prey
                        animals.remove(otherAnimal);
                        if(i > j){i--;}
                        cells[x][y] = animal.getSymbol();
                        System.out.println("Hunter ate the prey at (" + x + ", " + y + ")");
                        j--;
                        break;
                    }

                }
            }
        }
    }
    // Method to print the board
    public void printBoard() {
        int width = cells.length;
        int height = cells[0].length;

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }
    }
}
