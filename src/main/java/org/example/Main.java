package org.example;

import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
            Board board = new Board(10,10);
            Cheetah ch1 = new Cheetah(1, 1, 'd');
            board.placeAnimal(ch1);
            board.printBoard();
        }
        public static void toFile(){

    }

}
