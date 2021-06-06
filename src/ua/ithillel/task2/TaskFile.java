package ua.ithillel.task2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TaskFile {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bin = null;
        try{
            bin=new BufferedInputStream(new FileInputStream(args[0]));
            int i;
            while ((i=bin.read())!=-1){
                System.out.print((char)i);
            }

        }catch (Exception e){
            System.out.println("No such directory");
        }
        finally {
            if(bin!=null){
                bin.close();
            }
        }
    }
}
