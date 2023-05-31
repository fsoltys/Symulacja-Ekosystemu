package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(10, 10);

        // Tworzenie obiektów zwierząt
        Prey antelope = new Antelope(3, 4, 'A');
        Prey zebra = new Zebra(5, 6, 'Z');
        Hunter jackal = new Jackal(7, 8, 'J');
        Hunter lion = new Lion(9, 9, 'L');

        // Umieszczanie zwierząt na planszy
        board.placeAnimal(antelope);
        board.placeAnimal(zebra);
        board.placeAnimal(jackal);
        board.placeAnimal(lion);

        // Przed ruchem
        System.out.println("Plansza przed ruchem:");
        board.printBoard();

        // Metoda move() dla wszystkich zwierząt
        List<Animal> animals = board.getAnimals();
        for (Animal animal : animals) {
            if (animal instanceof Prey) {
                Prey prey = (Prey) animal;
                prey.move(board);
            } else if (animal instanceof Hunter) {
                Hunter hunter = (Hunter) animal;
                hunter.move(board);
            }
        }

        // Aktualizacja
        board.updateBoard();

        // Po ruchu
        System.out.println("Plansza po ruchu:");
        board.printBoard();
    }

        public static void toFile(){

    }

}
