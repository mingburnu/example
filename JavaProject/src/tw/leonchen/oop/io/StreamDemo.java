package tw.leonchen.oop.io;

import java.io.*;

public class StreamDemo { 
    public static void main(String[] args) { 
        try { 
            System.out.print("輸入字元: "); 
            System.out.println("輸入字元十進位表示: " + 
                                    System.in.read()); 
            System.out.println("換行字元十進位表示: " + 
                                    System.in.read()); 
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        } 
    } 
} 