/*
Michael Kuczkuda
10/6/15
CSCI 431
Project 2 Parser

This Calc Parser looks at a File and sees if the File abides by the Grammar given.
This class has a construtor that sets the Calc Scannar to read the file.  Then a 
parse method that starts the parse, then other private helper methods to test the 
file.
*/
package calcscanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class CalcParser {
    //The Look Ahead int and Scanner 
    private int lookahead;
    private CalcScanner scan;
    //Constructor that sets the Scanner
    CalcParser(File f){
         scan=new CalcScanner(f);
    }
    //Sets the look ahead variable then goes to program
    public void parse() throws IOException{
        lookahead=scan.nextToken();
        program();
    }
    //Goes to Stmt_List then looks at the end of the program to end
    private void program() throws IOException{
        stmt_list();
        if(lookahead==0){
            System.out.println("Success");
        }
        else{
            System.out.println("Failure");
        }
    }
    //Looks if the look ahead is a id, read, or write
    private void stmt_list() throws IOException{
        while(lookahead==8 || lookahead==9 || lookahead==10){
            stmt();
        }
    }
    //again looks if its a Id, Read, or Write then tests it, and contiunes to 
    //expr or fails
    private void stmt() throws IOException{
        if(lookahead==8){
            match(8);
            match(11);
            expr();
        }
        else if(lookahead==9){
            match(9);
            match(8);
        }
        else if(lookahead==10){
            match(10);
            expr();
        }
        else{
           System.out.println("Failure");
           System.exit(0);
        }
    }
    //Goes to term and tests if its + or -
    private void expr() throws IOException{
        term();
        if(lookahead==3){
            match(3);
            term();
        }
        if(lookahead==4){
            match(4);
            term();
        }
    }
    //Goes to factor and test if its * or /
    private void term() throws IOException{
        factor();
        if(lookahead==6){
            match(6);
            factor();
        }
        if(lookahead==5){
            match(5);
            factor();
        }
    }
    //Tests if its (,), or an id then fails.
    private void factor() throws IOException{
       if(lookahead==1){
           match(1);
           expr();
           match(2);
       }
       else if(lookahead==8){
           match(8);
       }
       else if(lookahead==7){
           match(7);
       }
       else{
           System.out.println("Failure");
           System.exit(0);
       }
    }
    //Takes a token value then tests if that equals the lookahead, if so scans 
    //the next token else Fails then quits
    private void match(int token) throws IOException{
        if(lookahead==token){
            lookahead=scan.nextToken();
        }
        else{
            System.out.println("Failure");
            System.exit(0);
        }
    }
}
