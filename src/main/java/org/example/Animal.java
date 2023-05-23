package org.example;

public class Animal extends SimElement{
    private char symbol;
    public Animal(int col, int row, char symbol){
        super(col, row);
    }

    char getSymbol(){
        return symbol;
    }
}
