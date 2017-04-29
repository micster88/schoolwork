/*
Michael Kuczkuda
9/13/14
CSCI 431
Project 1 Scanner

This CalcScanner has a constructor that takes a file and and starts the reader.
It also has a method nextToken that looks at the file using a PushBackReader
then looks for a set grammar to see what the next token in the file is.  
*/
package calcscanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.util.Scanner;


public class CalcScanner {
    //My Global Variables of File, FileReader, and PushbackReader
    private File f;
    private FileReader r;
    private PushbackReader p;
    
    //Constructor that takes the input file and trys to use the readers, 
    //quiting the program if it can't
    CalcScanner(File f){
        this.f=f;
        String fileName=f.getName();
        System.out.println(fileName);
        try{
            r=new FileReader(f);
            p=new PushbackReader(r);
        }
        catch(FileNotFoundException e){
            System.out.println("No File Found");
            System.exit(0);
        }
    }
    //The nextToken Method that has a while loop with a nested Switch that changes
    //depending on the state it is in.  Then has another Switch for the correct
    //return statement, which is a number based on the lexemes 
    public int nextToken() throws IOException{
        int state=0;
        int c=p.read();
        while(c!=-1 && (state<5 || state>17) ){
            switch (state){
                case 0 :
                    if(Character.isDigit(c)){
                        state=1;
                        c=p.read();
                    }
                    else if(c=='\n'){
                        state=0;
                        c=p.read();
                    }
                    else if(c==(int)'w'){
                        state=18;
                        c=p.read();
                    }
                    else if(c==(int)'r'){
                        state=22;
                        c=p.read();
                    }
                    else if(Character.isLetter(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c==(int)'+'){
                        state=6;
                    }
                    else if(c==(int)'-'){
                        state=7;
                    }
                    else if(c==(int)'*'){
                        state=8;
                    }
                    else if(c==(int)'/'){
                        state=9;
                    }
                    else if(c==(int)'$'){
                        state=4;
                        c=p.read();
                    }
                    else if(c==(int)':'){
                        state=3;
                        c=p.read();
                    }
                    else if(c==(int)'='){
                        state=5;
                    }
                    else if(c==(int)'('){
                        state=10;
                    }
                    else if(c==(int)')'){
                        state=11;
                    }
                    else if(c==(int)' '){
                        state=0;
                        c=p.read();
                    }
                    else{
                        state=5;
                    }
                    break;
                case 1:
                   if(Character.isDigit(c)){
                        state=1;
                        c=p.read();
                    }
                    else if(c=='\n'){
                        state=12;
                    }
                    else if(c==(int)' '){
                        state=12;
                    }
                    else if(Character.isLetter(c)){
                        state=12;
                    }
                    else if(c==(int)'+'){
                        state=12;
                    }
                    else if(c==(int)'-'){
                        state=12;
                    }
                    else if(c==(int)'*'){
                        state=12;
                    }
                    else if(c==(int)'/'){
                        state=12;
                    }
                    else if(c==(int)'$'){
                        state=12;
                    }
                    else if(c==(int)':'){
                        state=12;
                    }
                    else if(c==(int)'='){
                        state=12;
                    }
                    else if(c==(int)'('){
                        state=12;
                    }
                    else if(c==(int)')'){
                        state=12;
                    }
                    else{
                        state=12;
                    }
                    break;
                case 2:
                    if(Character.isDigit(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c=='\n'){
                        state=14;
                    }
                    else if(c==(int)' '){
                        state=14;
                    }
                    else if(c==(int)'w'){
                        state=18; 
                    }
                    else if(c==(int)'r'){
                        state=22;
                    }
                    else if(Character.isLetter(c)){
                          state=2;
                          c=p.read();
                        
                    }
                    else if(c==(int)'+'){
                        state=14;
                    }
                    else if(c==(int)'-'){
                        state=14;
                    }
                    else if(c==(int)'*'){
                        state=14;
                    }
                    else if(c==(int)'/'){
                        state=14;
                    }
                    else if((char)c=='$'){
                        state=14;
                    }
                    else if(c==(int)':'){
                        state=14;
                    }
                    else if(c==(int)'='){
                        state=14;
                    }
                    else if(c==(int)'('){
                        state=14;
                    }
                    else if(c==(int)')'){
                        state=14;
                    }
                    else{
                        state=14;
                    }
                    break;
                case 3:
                    if(Character.isDigit(c)){
                        state=5;     
                    }
                    else if(c=='\n'){
                        state=5;
                    }
                    else if(c==(int)' '){
                        state=3;
                        c=p.read();
                    }
                    else if(c==(int)'w'){
                        state=18;
                        c=p.read();
                    }
                    else if(c==(int)'r'){
                        state=22;
                        c=p.read();
                    }
                    else if(Character.isLetter(c)){
                        state=5;
                    }
                    else if(c==(int)'+'){
                        state=5;
                    }
                    else if(c==(int)'-'){
                        state=5;
                    }
                    else if(c==(int)'*'){
                        state=5;
                    }
                    else if(c==(int)'/'){
                        state=5;
                        c=p.read();
                    }
                    else if((char)c=='$'){
                        state=5;
                    }
                    else if(c==(int)':'){
                        state=5;
                    }
                    else if(c==(int)'='){
                        state=16;
                    }
                    else if(c==(int)'('){
                        state=5;
                    }
                    else if(c==(int)')'){
                        state=5;
                    }
                    else if(c==(int)' '){
                        state=5;
                    }
                    else{
                        state=5;
                    }
                    break;
                case 4:
                    if(Character.isDigit(c)){
                        state=5;   
                    }
                    else if(c=='\n'){
                        state=5;
                    }
                    else if(c==(int)' '){
                        state=5;
                    }
                    else if(Character.isLetter(c)){
                        state=5;
                    }
                    else if(c==(int)'+'){
                        state=5;
                    }
                    else if(c==(int)'-'){
                        state=5;
                    }
                    else if(c==(int)'*'){
                        state=5;
                    }
                    else if(c==(int)'/'){
                        state=5;
                    }
                    else if(c==(int)'$'){
                        state=17;
                    }
                    else if(c==(int)':'){
                        state=5;
                    }
                    else if(c==(int)'='){
                        state=5;
                    }
                    else if(c==(int)'('){
                        state=5;
                    }
                    else if(c==(int)')'){
                        state=5;
                    }
                    else{
                        state=5;
                    }
                    break;
                //Write check States    
                case 18 :
                    if(Character.isDigit(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c=='\n'){
                        state=14;
                    }
                    else if(c==(int)'r'){
                        state=19;
                        c=p.read();
                    }
                    else if(Character.isLetter(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c==(int)'+'){
                        state=14;
                    }
                    else if(c==(int)'-'){
                        state=14;
                    }
                    else if(c==(int)'*'){
                        state=14;
                    }
                    else if(c==(int)'/'){
                        state=14;
                    }
                    else if(c==(int)'$'){
                        state=14;
                    }
                    else if(c==(int)':'){
                        state=14;
                    }
                    else if(c==(int)'='){
                        state=14;
                    }
                    else if(c==(int)'('){
                        state=14;
                    }
                    else if(c==(int)')'){
                        state=14;
                    }
                    else if(c==(int)' '){
                        state=14;
                    }
                    else{
                        state=14;
                    }
                    break;
                case 19 :
                    if(Character.isDigit(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c=='\n'){
                        state=14;
                    }
                    else if(c==(int)'i'){
                        state=20;
                        c=p.read();
                    }
                    else if(Character.isLetter(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c==(int)'+'){
                        state=14;
                    }
                    else if(c==(int)'-'){
                        state=14;
                    }
                    else if(c==(int)'*'){
                        state=14;
                    }
                    else if(c==(int)'/'){
                        state=14;
                    }
                    else if(c==(int)'$'){
                        state=14;
                    }
                    else if(c==(int)':'){
                        state=14;
                    }
                    else if(c==(int)'='){
                        state=14;
                    }
                    else if(c==(int)'('){
                        state=14;
                    }
                    else if(c==(int)')'){
                        state=14;
                    }
                    else if(c==(int)' '){
                        state=14;
                    }
                    else{
                        state=14;
                    }
                    break;
                case 20 :
                    if(Character.isDigit(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c=='\n'){
                        state=14;
                    }
                    else if(c==(int)'t'){
                        state=21;
                        c=p.read();
                    }
                    else if(Character.isLetter(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c==(int)'+'){
                        state=14;
                    }
                    else if(c==(int)'-'){
                        state=14;
                    }
                    else if(c==(int)'*'){
                        state=14;
                    }
                    else if(c==(int)'/'){
                        state=14;
                    }
                    else if(c==(int)'$'){
                        state=14;
                    }
                    else if(c==(int)':'){
                        state=14;
                    }
                    else if(c==(int)'='){
                        state=14;
                    }
                    else if(c==(int)'('){
                        state=14;
                    }
                    else if(c==(int)')'){
                        state=14;
                    }
                    else if(c==(int)' '){
                        state=14;
                    }
                    else{
                        state=14;
                    }
                    break;
                case 21 :
                    if(Character.isDigit(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c==(int)'e'){
                        state=15;
                    }
                    else if(Character.isLetter(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c=='\n'){
                        state=14;
                    }
                    else if(c==(int)'+'){
                        state=14;
                    }
                    else if(c==(int)'-'){
                        state=14;
                    }
                    else if(c==(int)'*'){
                        state=14;
                    }
                    else if(c==(int)'/'){
                        state=14;
                    }
                    else if(c==(int)'$'){
                        state=14;
                    }
                    else if(c==(int)':'){
                        state=14;
                    }
                    else if(c==(int)'='){
                        state=14;
                    }
                    else if(c==(int)'('){
                        state=14;
                    }
                    else if(c==(int)')'){
                        state=14;
                    }
                    else if(c==(int)' '){
                        state=14;
                    }
                    else{
                        state=14;
                    }
                    break;
                //read check states    
                case 22 :
                    if(Character.isDigit(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c==(int)'e'){
                        state=23;
                        c=p.read();
                    }
                    else if(c=='\n'){
                        state=14;
                    }
                    else if(Character.isLetter(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c==(int)'+'){
                        state=14;
                    }
                    else if(c==(int)'-'){
                        state=14;
                    }
                    else if(c==(int)'*'){
                        state=14;
                    }
                    else if(c==(int)'/'){
                        state=14;
                    }
                    else if(c==(int)'$'){
                        state=14;
                    }
                    else if(c==(int)':'){
                        state=14;
                    }
                    else if(c==(int)'='){
                        state=14;
                    }
                    else if(c==(int)'('){
                        state=14;
                    }
                    else if(c==(int)')'){
                        state=14;
                    }
                    else if(c==(int)' '){
                        state=14;
                    }
                    else{
                        state=14;
                    }
                    break;
                case 23 :
                    if(Character.isDigit(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c==(int)'a'){
                        state=24;
                        c=p.read();
                    }
                    else if(Character.isLetter(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c=='\n'){
                        state=14;
                    }
                    else if(c==(int)'+'){
                        state=14;
                    }
                    else if(c==(int)'-'){
                        state=14;
                    }
                    else if(c==(int)'*'){
                        state=14;
                    }
                    else if(c==(int)'/'){
                        state=14;
                    }
                    else if(c==(int)'$'){
                        state=14;
                    }
                    else if(c==(int)':'){
                        state=14;
                    }
                    else if(c==(int)'='){
                        state=14;
                    }
                    else if(c==(int)'('){
                        state=14;
                    }
                    else if(c==(int)')'){
                        state=14;
                    }
                    else if(c==(int)' '){
                        state=14;
                    }
                    else{
                        state=14;
                    }
                    break;
                case 24 :
                    if(Character.isDigit(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c==(int)'d'){
                        state=13;
                    }
                    else if(Character.isLetter(c)){
                        state=2;
                        c=p.read();
                    }
                    else if(c==(int)'+'){
                        state=14;
                    }
                    else if(c=='\n'){
                        state=14;
                    }
                    else if(c==(int)'-'){
                        state=14;
                    }
                    else if(c==(int)'*'){
                        state=14;
                    }
                    else if(c==(int)'/'){
                        state=14;
                    }
                    else if(c==(int)'$'){
                        state=14;
                    }
                    else if(c==(int)':'){
                        state=14;
                    }
                    else if(c==(int)'='){
                        state=14;
                    }
                    else if(c==(int)'('){
                        state=14;
                    }
                    else if(c==(int)')'){
                        state=14;
                    }
                    else if(c==(int)' '){
                        state=14;
                    }
                    else{
                        state=14;
                    }
                    break;
            }
        }
        
        switch(state){
            //Error State
            case 5:
                return -1;
            //+ State    
            case 6:
                return 3;
            //- State    
            case 7:
                return 4;
            //* State    
            case 8:
                return 6;
            /// State   
            case 9:
                return 5;
            //( State    
            case 10:
                return 1;
            //) State    
            case 11:
                return 2;
            //num State    
            case 12:    
                p.unread(c);
                return 7;
            //read State    
            case 13:
                return 9;
            //id State    
            case 14:
                p.unread(c);
                return 8;
            //write State    
            case 15:
                return 10;
            //:= State    
            case 16:
                return 11;
            //$$ State    
            case 17:
                return 0;
        }
        //if it somehow gets through without hitting a state returns -1
        return -1;
    }
}
