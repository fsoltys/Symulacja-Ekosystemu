package org.example;

public class SimElement extends Main {
    private int x, y;

    public SimElement(int row, int column){
        x = row;
        y = column;
    }

    void setX(int x){
        this.x = x;
    }
    void setY(int y){this.y = y;}

    int getY(){
        return y;
    }
    int getX(){
        return x;
    }
}
