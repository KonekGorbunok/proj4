package org.test4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            System.out.println("Укажите путь к файлу, включая наименование файла с расширением.");
            System.out.println("Например: C:\\sample.txt");
            Scanner fPath = new Scanner(System.in);
            Scanner scanner = new Scanner(new File(fPath.nextLine()));

            Box box = Box.getBox();

            for (int i = 0; i < 6; i++) {
                box.addSide(new Side(scanner.nextInt(), scanner.nextInt()));
            }

            System.out.println(box.toString());

            System.out.println(box.isPossibleBox() ? "Возможно" : "Невозможно" );
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}