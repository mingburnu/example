package tw.leonchen.oop.exception;

import java.io.*; 

public class UseException { 
    public static void main(String[] args) { 
        try { 
            int input; 
            BufferedReader buf = new BufferedReader( 
                                        new InputStreamReader(System.in)); 
            System.out.print(95); 
            input = Integer.parseInt(buf.readLine()); 
            System.out.println("input x 10 = " + (input*10)); 
        } 
        catch(IOException e) { 
            System.out.println("I/O錯誤"); 
        } 
        catch(NumberFormatException e) { 
            System.out.println("輸入格式有誤"); 
        } 
    } 
} 