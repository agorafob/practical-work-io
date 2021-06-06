package ua.ithillel.task3;

import java.io.*;
import java.util.*;

public class TaskCopy {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

//        System.out.println("Enter old file name:");
//        String oldFile = sc.nextLine();
//        System.out.println("Enter new file name");
//        String newFile = sc.nextLine();
//        copyFiles(oldFile, newFile);

        System.out.println("Enter java file name");
        String fileForReplacement = sc.nextLine();
        replacementInFile(fileForReplacement);

    }

    public static void copyFiles(String oldFile, String newFile) throws IOException {
        System.out.println("Start copying of file...");
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = new BufferedReader(new FileReader(oldFile));
            out = new BufferedWriter(new FileWriter(newFile));
            String s;
            while ((s = in.readLine()) != null) {
                out.write(s);
            }
        } catch (IOException e) {
            System.out.println("No such directory");
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
        System.out.println("Copying ended");
    }

    public static void replacementInFile(String fileName){
        System.out.println("Replacing...");
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String s;
            List<String> backup = new ArrayList<>();
            while ((s = in.readLine()) != null) {
                s=s.replace("public", "protected");
                backup.add(s);
            }
            in.close();
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            for (String line : backup) {
                out.write(line);
            }
            out.close();
        } catch (IOException e) {
            System.out.println("No such file");
        }
        System.out.println("Replacing completed");
    }
}