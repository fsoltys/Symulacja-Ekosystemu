package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(10, 10);

        // Add animals to the board
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            Prey antelope = new Antelope(x, y, 'A');
            board.placeAnimal(antelope);
        }

        for (int i = 0; i < 5; i++) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            Prey zebra = new Zebra(x, y, 'Z');
            board.placeAnimal(zebra);
        }

        int x = random.nextInt(10);
        int y = random.nextInt(10);
        Hunter hyena = new Hyena(x, y, 'H');
        board.placeAnimal(hyena);

        x = random.nextInt(10);
        y = random.nextInt(10);
        Hunter lion = new Lion(x, y, 'L');
        board.placeAnimal(lion);

        // Add food to the board
        for (int i = 0; i < 3; i++) {
            x = random.nextInt(10);
            y = random.nextInt(10);
            Food food = new Food(x, y);
            board.placeFood(food);
        }

        // Print the initial board
        System.out.println("Initial board:");
        board.printBoard();

        // Update the board state for 20 iterations
        for (int i = 0; i < 20; i++) {
            for (Animal animal : board.getAnimals()) {
                animal.move(board);
            }
            board.updateBoard();
            System.out.println("\nIteration: " + (i + 1));
            board.printBoard();
        }

        // Calculate and print the population of prey and hunters
        int preyPopulation = 0;
        int hunterPopulation = 0;
        for (Animal animal : board.getAnimals()) {
            if (animal instanceof Prey) {
                preyPopulation++;
            }
            if (animal instanceof Hunter) {
                hunterPopulation++;
            }
        }
        System.out.println("\nFinal board:");
        board.printBoard();
        System.out.println("Prey population: " + preyPopulation);
        System.out.println("Hunter population: " + hunterPopulation);
    }
}
