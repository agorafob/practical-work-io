package ua.ithillel.task4;

import java.io.IOException;
import java.util.Scanner;

public class TaskUser {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите путь к файлу");
        String path = sc.nextLine();
        AccountingUser au = new AccountingUser(path);
        System.out.println("Введите имена пользователей, а затем 'stop'");
        String name;
        do {
            name = sc.nextLine();
            if (!name.equals("stop")) {
                au.addUsers(name);
            }
        }
        while (!name.equalsIgnoreCase("stop"));
        sc.close();
        au.printFile();
        au.finalizeInput();
    }
}
