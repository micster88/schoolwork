/*
Michael Kuczkuda
10/6/15
CSCI 431
Project 2 Parser

This test class tests my Calc Parser, asking the user to input a file then 
parsing it.
*/
package calcscanner;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name of your File.txt, please use "
                    + "the location as well");
        String filename=sc.nextLine();
        File users= new File(filename);
        CalcParser parse=new CalcParser(users);
        System.out.println("Parse");
        parse.parse();
        System.out.println("Thank You");    
    }
}
