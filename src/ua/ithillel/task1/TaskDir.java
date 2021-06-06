package ua.ithillel.task1;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class TaskDir {
    public static void main(String[] args) {
        File file;
        try {
            file = new File(args[0]);
        }catch (Exception e){
            file = new File("C:\\PROJECT_HILEL_2ND\\practical-work-io\\src\\ua\\ithillel\\task1");
        }

        if (file.exists()) {
            String[] list = file.list();
            System.out.println(Arrays.toString(list));
        } else {
            System.out.println("No such directory");
        }
    }
}
