package ua.ithillel.task4;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class AccountingUser {
    private RandomAccessFile file;
    private List<String> database = new ArrayList<>();
    private int counter = 0;

    public AccountingUser(String path) throws IOException {
        file = new RandomAccessFile(path, "rw");
    }

    public void addUsers(String nameUser) throws IOException {
        if (database.size() != 0 && database.contains(nameUser)) {
            for (int i = 0; i < counter; i++) {
                if (database.get(i).equals(nameUser)) {
                    int c = Integer.parseInt(database.get(i + 1)) + 1;
                    database.set(i + 1, String.valueOf(c));
                }
            }
        } else {
            add(nameUser, counter);
        }
        write();
    }

    public void printFile() throws IOException {
        file.seek(0);
        String s;
        while ((s = file.readLine()) != null) {
            System.out.println(s);
        }
    }

    private void write() throws IOException {
        int counter = 0;
        for (int i = 0; i < database.size(); i += 2) {
            file.seek(counter);
            counter += database.get(i).length() + 1;
            counter += database.get(i + 1).length() + 1;
            file.writeBytes(database.get(i) + ":" + database.get(i + 1) + " ");
        }
    }

    public void finalizeInput() throws IOException {
        file.close();
    }

    private void add(String nameUser, int position) {
        database.add(position, nameUser);
        database.add(position + 1, "1");
        counter += 2;
    }
}
