package application.utils;

import java.util.Scanner;

import static java.lang.System.*;

public class Input {
    private static Scanner scanner = new Scanner(in);

    public static int getInt(){
        if(scanner.hasNextInt()){
            return scanner.nextInt();
        }
        scanner.next();
        out.println("Это не число. Повторите ввод!");
        return getInt();
    }

    public static int getInt(String message){
        out.println(message);
        return getInt();
    }

    public static String getString(){
        return scanner.next();
    }

    public static String getString(String message){
        out.println(message);
        return getString();
    }
}