/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Michael Kuczkuda
 */
public class MineSweeper {

    public int rows;
    public int columns;
    public int mineAmount;
    public boolean loss;
    public Cell[][] cells;
//My Inner Class Cell Contains a Int and String for the Value of that spot as well as the - and M value for the Mines

    private class Cell {

        private int value = 0;
        private String piece = " - ";

        //I made 2 Constructors to call for a give value and a String but also a blank Constructor
        public Cell(int value, String piece) {
            this.value = value;
            this.piece = piece;
        }

        public Cell() {

        }
//I made gets and sets for both the Value and Piece sets allowing me to manipulate the values

        public int getValue() {
            return value;
        }

        public String getPiece() {
            return piece;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setPiece(String piece) {
            this.piece = piece;
        }
//I also made a toString so I could easily print the values

        public String toString() {
            return piece;
        }
    }
//I made two constuctors for the creation of a game then a blank game

    public MineSweeper(int rows, int columns, int mineAmount) {
        this.rows = rows;
        this.columns = columns;
        this.mineAmount = mineAmount;
        cells = new Cell[rows][columns];
        loss = false;
    }

    public MineSweeper() {

    }
//my set game method sets the Cells, then sets the mines, then changes the value of the Cells based on the mines around them

    public void setGame() {
        int mines = 0;
        int value = 0;
        //sets cells
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = new Cell();
            }
        }
        //sets mines
        while (mines <= mineAmount) {
            Random gen = new Random();
            int rows1 = 0;
            int columns1 = 0;
            while (rows1 <= 0) {
                rows1 = gen.nextInt(rows - 1);
            }
            while (columns1 <= 0) {
                columns1 = gen.nextInt(columns - 1);
            }
            cells[rows1][columns1].setValue(-1);
            mines++;
        }
        //Sets the values around the mines increase by one but also looks at the cell to see if the cell is a mine
        for (int i = 1; i < cells.length - 1; i++) {
            for (int j = 1; j < cells.length - 1; j++) {
                if (cells[i][j].getValue() == -1) {
                    if (cells[i + 1][j + 1].getValue() != -1) {
                        value = cells[i + 1][j + 1].getValue();
                        value++;
                        cells[i + 1][j + 1].setValue(value);
                        value = 0;
                    }
                    if (cells[i][j + 1].getValue() != -1) {
                        value = cells[i][j + 1].getValue();
                        value++;
                        cells[i][j + 1].setValue(value);
                        value = 0;
                    }
                    if (cells[i + 1][j].getValue() != -1) {
                        value = cells[i + 1][j].getValue();
                        value++;
                        cells[i + 1][j].setValue(value);
                        value = 0;
                    }
                    if (cells[i - 1][j + 1].getValue() != -1) {
                        value = cells[i - 1][j + 1].getValue();
                        value++;
                        cells[i - 1][j + 1].setValue(value);
                        value = 0;
                    }
                    if (cells[i + 1][j - 1].getValue() != -1) {
                        value = cells[i + 1][j - 1].getValue();
                        value++;
                        cells[i + 1][j - 1].setValue(value);
                        value = 0;
                    }
                    if (cells[i - 1][j - 1].getValue() != -1) {
                        value = cells[i - 1][j - 1].getValue();
                        value++;
                        cells[i - 1][j - 1].setValue(value);
                        value = 0;
                    }
                    if (cells[i][j - 1].getValue() != -1) {
                        value = cells[i][j - 1].getValue();
                        value++;
                        cells[i][j - 1].setValue(value);
                        value = 0;
                    }
                    if (cells[i - 1][j].getValue() != -1) {
                        value = cells[i - 1][j].getValue();
                        value++;
                        cells[i - 1][j].setValue(value);
                        value = 0;
                    }
                }
            }
        }

    }

//Prints the board with numbers on top and the left side, as well as the - version
    public void Print() {
        StringBuilder sb = new StringBuilder("");
        if (loss != true) {
            System.out.println("  1  2  3  4  5  6  7  8");
            for (int i = 1; i < cells.length - 1; i++) {
                sb.append(i);
                for (int j = 1; j < cells.length - 1; j++) {
                    sb.append(cells[i][j].toString());
                }
                sb.append(" \n");
            }
            System.out.println(sb.toString());
        }
    }
//The Run method actually runs the game and askes the player to input the Row, Column and if its a mine

    public void Run() {
        if (loss != true) {
            int i = 0;
            int j = 0;
            int guess = 0;
            int mine = 0;
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Row:  ");
            i = input.nextInt();
            System.out.println("Enter Column:  ");
            j = input.nextInt();
            System.out.println("Mine or nonMine? -1 for Mine, anyother letter for nonMine  ");
            guess = input.nextInt();
            mine = cells[i][j].getValue();
            //Looks at the guess if its not a mine 
            if (guess != -1) {
                //Looks at the piece and losses if its a mine
                if (mine == -1) {
                    for (int a = 1; a < cells.length - 1; a++) {
                        for (int b = 1; b < cells.length - 1; b++) {
                            if (cells[a][b].getValue() == -1) {
                                cells[i][j].setPiece(" M ");
                            } else {
                                cells[i][j].setPiece(" " + cells[i][j].getValue() + " ");
                            }
                        }
                    }
                    loss = true;
                    System.out.println("GAME OVER");
                    MineSweeper game = new MineSweeper();
                    game.Replay();
                } else {
                    cells[i][j].setPiece(" " + cells[i][j].getValue() + " ");
                }
            } else {
                //Looks at the piece and losses if its not a mine
                if (mine == -1) {
                    cells[i][j].setPiece(" B ");
                } else {
                    for (int a = 1; a < cells.length - 1; a++) {
                        for (int b = 1; b < cells.length - 1; b++) {
                            if (cells[a][b].getValue() == -1) {
                                cells[i][j].setPiece(" M ");
                            } else {
                                cells[i][j].setPiece(" " + cells[i][j].getValue() + " ");
                            }
                        }
                    }
                    loss = true;
                    System.out.println("GAME OVER");
                    MineSweeper game = new MineSweeper();
                    game.Replay();
                }
            }
        }
    }
//Peaks at the board and askes you to peak before it starts of playing

    public void Peak() {
        StringBuilder sb = new StringBuilder("");
        int peak = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Peak? 1(yes) or -1 (no)");
        peak = input.nextInt();
        if (peak == 1) {
            System.out.println("  1  2  3  4  5  6  7  8");
            for (int i = 1; i < cells.length - 1; i++) {
                sb.append(i);
                for (int j = 1; j < cells.length - 1; j++) {
                    if (cells[i][j].getValue() == -1) {
                        sb.append(" M ");
                    } else {
                        sb.append(" " + cells[i][j].getValue() + " ");
                    }
                }
                sb.append(" \n");
            }
            System.out.println(sb.toString());
        }
    }
//Replays the game if the user chooses

    public void Replay() {
        int replay;
        Scanner input = new Scanner(System.in);
        System.out.println("Play Again? 1(yes) or -1 (no)");
        replay = input.nextInt();
        if (replay == 1) {
            MineSweeper game = new MineSweeper();
            game.Play();
        } else {
            System.out.println("Thank you for playing");
        }
    }
//Plays the game with the values of a 10 by 10 but only uses 8 by 8, with 10 mines and invokes all the other methods

    public void Play() {
        MineSweeper game;
        game = new MineSweeper(10, 10, 10);
        game.setGame();
        game.Peak();
        do {
            game.Print();
            game.Run();
        } while (loss != true);
        game.Replay();
    }
//Makes a new game, and invokes the play method

    public static void main(String[] args) {
        MineSweeper myGame = new MineSweeper();
        myGame.Play();
    }

}
