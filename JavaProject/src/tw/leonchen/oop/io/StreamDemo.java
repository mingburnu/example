package tw.leonchen.oop.io;

import java.io.*;

public class StreamDemo { 
    public static void main(String[] args) { 
        try { 
            System.out.print("��J�r��: "); 
            System.out.println("��J�r���Q�i����: " + 
                                    System.in.read()); 
            System.out.println("����r���Q�i����: " + 
                                    System.in.read()); 
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        } 
    } 
} 