package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(10, 10);

        // Tworzenie obiektów zwierząt

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

        // Przed ruchem
        System.out.println("Plansza przed ruchem:");
        board.printBoard();
        int i = 0;
        while (i < 20) {
            for (Animal animal : board.getAnimals()) {
                animal.move(board);
            }
            board.updateBoard();
            System.out.println("\n");
            board.printBoard();
            i++;
        }
        int preyPopulation = 0;
        int hunterPopulation = 0;
        for(Animal animal: board.getAnimals()){
           if(animal instanceof Prey){preyPopulation++;}
           if(animal instanceof Hunter){hunterPopulation++;}
        }
        // Po ruchu
        board.printBoard();
        System.out.println("Plansza po ruchu:");
        System.out.printf("Populacja po ruchu\nDrapiezniki: %d\nOfiary: %d", hunterPopulation, preyPopulation);
    }
}
