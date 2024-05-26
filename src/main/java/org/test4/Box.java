package org.test4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box {
    private static final Box instance = new Box();
    private boolean impossibleBox = false;
    //список только уникальных листов
    private final List<Side> sides = Collections.synchronizedList(new ArrayList<>(6));

    private Box() {}
    public static Box getBox(){
        return instance;
    }

    @Override
    public String toString(){
        return "sides: " + sides.toString();
    }

    public void addSide(Side side){
        //проверяем, есть ли такой объект с учётом поворота стороны
        if (sides.size() < 7){
            if (sides.isEmpty()){
                sides.add(side);
                return;
            }

            boolean contains = false;
            for (Side value : sides) {
                if (value.getX() == side.getX()) {
                    if (value.getY() == side.getY()) {
                        contains = true;
                        break;
                    }
                } else if (value.getX() == side.getY()) {
                    if (value.getY() == side.getX()) {
                        contains = true;
                        break;
                    }
                }
            }
            if(!contains){
                sides.add(side);
            }
        }
    }

    public boolean isPossibleBox(){
        // если 1 элемент, то это куб
        if (sides.size() == 1){
            return true; // 6 одинаковых сторон
        // 2 элементра это 4+2
        } else if (sides.size() == 2) {
            return isBox4x2();
        // 3 элементра это 2 + 2 + 2
        } else if (sides.size() == 3) {
            return isBox2x2x2();
        }
        return false;
    }
    //если это вариант 4+2, то оставшиеся 2 стороны должны быть квадратами
    private boolean isBox4x2(){
        if (sides.get(0).getX() == sides.get(0).getY()){
            return sides.get(0).getX() == sides.get(1).getX() || sides.get(0).getX() == sides.get(1).getY();
        } else if (sides.get(1).getX() == sides.get(1).getY()) {
            return sides.get(1).getX() == sides.get(0).getX() || sides.get(1).getX() == sides.get(0).getY();
        }
        return false;
    }

    private boolean isBox2x2x2(){
        if (sides.get(0).getX() == sides.get(1).getX()){
            if(sides.get(0).getY() == sides.get(2).getX()){
                return sides.get(1).getY() == sides.get(2).getY();
            } else if (sides.get(0).getY() == sides.get(2).getY()) {
                return sides.get(1).getY() == sides.get(2).getX();
            } else {
                return false;
            }
        } else if (sides.get(0).getX() == sides.get(1).getY()){
            if (sides.get(0).getY() == sides.get(2).getX()){
                return sides.get(1).getX() == sides.get(2).getY();
            } else if (sides.get(0).getY() == sides.get(2).getY()) {
                return sides.get(1).getX() == sides.get(2).getX();
            } else {
                return false;
            }
        } else if (sides.get(0).getY() == sides.get(1).getX()) {
            if (sides.get(0).getX() == sides.get(2).getX()){
                return sides.get(1).getY() == sides.get(2).getY();
            } else if (sides.get(0).getX() == sides.get(2).getY()) {
                return sides.get(1).getY() == sides.get(2).getX();
            } else {
                return false;
            }
        } else if (sides.get(0).getY() == sides.get(1).getY()) {
            if (sides.get(0).getX() == sides.get(2).getY()){
                return sides.get(1).getX() == sides.get(2).getX();
            } else if (sides.get(0).getX() == sides.get(2).getX()) {
                return sides.get(1).getX() == sides.get(2).getY();
            } else {
                return false;
            }
        }
        return false;
    }
}