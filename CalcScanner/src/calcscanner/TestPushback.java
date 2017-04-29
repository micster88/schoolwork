/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcscanner;

import java.io.PushbackReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestPushback {
      public static void main(String [] args) {
      // Make sure myFile.txt has at least 12 characters in it.
      String fileName = "test.txt";
      FileReader reader = null;

      try {
        reader = new FileReader(fileName);
      }
      catch(FileNotFoundException e) {
        System.out.println("File " + fileName + " does not exist. Quitting...");
        System.exit(0);
      }

      PushbackReader pbReader = new PushbackReader(reader);
      int c = 0;
      StringBuilder lexeme = new StringBuilder("");
      try {
        for (int i=0; i<12; i++) {
          c = pbReader.read();
          lexeme.append((char) c);
        }
        // Test of the unread. The lexeme should have the last character 
        // read repeated at the end.
        pbReader.unread(c);
        c = pbReader.read();
        lexeme.append((char) c);
      }
      catch(IOException e) {
        System.out.println("Something went wrong with a read. Quitting...");
        System.exit(0);
      }

      System.out.println(lexeme);
    }
  
}
