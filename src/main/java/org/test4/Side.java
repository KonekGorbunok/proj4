package org.test4;

public class Side {
    private int X;
    private int Y;

    public int getY() {
        return Y;
    }

    public int getX() {
        return X;
    }

    public Side(int x, int y) {
        X = x;
        Y = y;
    }

    @Override
    public String toString(){
        return "X: " + this.X + " Y: " + this.Y;
    }
}