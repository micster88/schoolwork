/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrkothello;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class board {

    public int[] board = new int[100];
    private char myColor;
    private int me = 1;
    private int opp = -1;
    private int empty = 0;
    private int edge = -2;
    private int pass = 0;
    private int[] spaceValues = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 3000, -250, 100, 50, 50, 100, -250, 3000, 0,
        0, -250, -250, 10, 10, 10, 10, -250, -250, 0,
        0, 100, 10, 50, 20, 20, 50, 10, 100, 0,
        0, 50, 10, 20, 10, 10, 20, 10, 50, 0,
        0, 50, 10, 20, 10, 10, 20, 10, 50, 0,
        0, 100, 10, 50, 20, 20, 50, 10, 100, 0,
        0, -250, -250, 10, 10, 10, 10, -250, -250, 0,
        0, 3000, -250, 100, 50, 50, 100, -250, 3000, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int turns = 0;
    static double timeAllocation[] = {0.015, 0.015, 0.015, 0.015, 0.025, 0.025, 0.025, 0.025, 0.025, 0.025,
        0.048, 0.048, 0.048, 0.048, 0.048, 0.048, 0.050, 0.051, 0.052, 0.053,
        0.044, 0.045, 0.049, 0.049, 0.049, 0.051, 0.053, 0.055, 0.057, 0.059,
        0.060, 0.060, 0.061, 0.062, 0.063, 0.064, 0.065, 0.065, 0.065, 0.065,
        0.167, 0.168, 0.169, 0.169, 0.171, 0.172, 0.173, 0.175, 0.180, 0.180,
        0.181, 0.187, 0.196, 0.199, 0.220, 0.220, 0.220, 0.220, 0.220, 0.220,
        0.220, 0.250, 0.250, 0.250, 0.250, 0.250, 0.250, 0.250, 0.250, 0.250
    };
    public int timeRemaining = 600;
    static Timer timer;
    public static boolean timeUP = false;
    int moveNumber = 0;

    public board(char color) {
        myColor = color;
        for (int i = 1; i < 9; i++) {
            for (int j = 10; j < 90; j = j + 10) {
                board[i + j] = empty;
            }
        }
        for (int i = 0; i < 10; i++) {
            board[i] = edge;
            board[i + 90] = edge;
        }
        for (int i = 10; i < 100; i = i + 10) {
            board[i] = edge;
            board[i + 9] = edge;
        }
        if (myColor == 'W') {
            board[44] = me;
            board[45] = opp;
            board[54] = opp;
            board[55] = me;
        } else if (myColor == 'B') {
            board[44] = opp;
            board[45] = me;
            board[54] = me;
            board[55] = opp;
        }
        System.out.println("R " + myColor);
    }

    public board() {
        //just creates a blank board
    }

    public board(board oldBoard) {
        System.arraycopy(oldBoard.board, 0, board, 0, oldBoard.board.length);
        turns = oldBoard.turns;
        myColor = oldBoard.myColor;

    }

    private LinkedList<Integer> generateMoves(int player) {
        LinkedList<Integer> generated = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
                if (board[i] == empty) {
                    boolean end = false;
                    int temp = i;
                    if (upleft(temp) == (player * -1)) {
                        while (end == false) {
                            temp = temp - 11;
                            if (upleft(temp) == empty || upleft(temp) == edge) {
                                end = true;
                            }
                            if (upleft(temp) == player) {
                                generated.push(i);
                            }
                        }
                    }
                    temp = i;
                    end = false;
                    if (up(temp) == (player * -1)) {
                        while (end == false) {
                            temp = temp - 10;
                            if (up(temp) == empty || up(temp) == edge) {
                                end = true;
                            }
                            if (up(temp) == player) {
                                generated.push(i);
                            }
                        }
                    }
                    temp = i;
                    end = false;
                    if (upright(temp) == (player * -1)) {
                        while (end == false) {
                            temp = temp - 9;
                            if (upright(temp) == empty || upright(temp) == edge) {
                                end = true;
                            }
                            if (upright(temp) == player) {
                                generated.push(i);
                            }
                        }
                    }
                    temp = i;
                    end = false;
                    if (left(temp) == (player * -1)) {
                        while (end == false) {
                            temp = temp - 1;
                            if (left(temp) == empty || left(temp) == edge) {
                                end = true;
                            }
                            if (left(temp) == player) {
                                generated.push(i);
                            }
                        }
                    }
                    temp = i ;
                    end = false;
                    if (right(temp) == (player * -1)) {
                        while (end == false) {
                            temp = temp + 1;
                            if (right(temp) == empty || right(temp) == edge) {
                                end = true;
                            }
                            if (right(temp) == player) {
                                generated.push(i);
                            }
                        }
                    }
                    temp = i;
                    end = false;
                    if (downleft(temp) == (player * -1)) {
                        while (end == false) {
                            temp = temp + 9;
                            if (downleft(temp) == empty || downleft(temp) == edge) {
                                end = true;
                            }
                            if (downleft(temp) == player) {
                                generated.push(i);
                            }
                        }
                    }
                    temp = i;
                    end = false;
                    if (down(temp) == (player * -1)) {
                        while (end == false) {
                            temp = temp + 10;
                            if (down(temp) == empty || down(temp) == edge) {
                                end = true;
                            }
                            if (down(temp) == player) {
                                generated.push(i);
                            }
                        }
                    }
                    temp = i;
                    end = false;
                    if (downright(temp) == (player * -1)) {
                        while (end == false) {
                            temp = temp + 11;
                            if (downright(temp) == empty || downright(temp) == edge) {
                                end = true;
                            }
                            if (downright(temp) == player) {
                                generated.push(i);
                            }
                        }
                    }
                }
            }
        return generated;
    }

    private int upleft(int i) {
        return board[i - 11];
    }

    private int up(int i) {
        return board[i - 10];
    }

    private int upright(int i) {
        return board[i - 9];
    }

    private int left(int i) {
        return board[i - 1];
    }

    private int right(int i) {
        return board[i + 1];
    }

    private int downleft(int i) {
        return board[i + 9];
    }

    private int down(int i) {
        return board[i + 10];
    }

    private int downright(int i) {
        return board[i + 11];
    }
    
    public int getMyMove() {
        timeUP = false;
        timer = new Timer();
        int timeForMove = (int) (timeAllocation[moveNumber] * (double) timeRemaining);
        timer.schedule(new InterruptTask(), timeForMove * 1000);
        double alpha = Double.MIN_VALUE;
        double beta = Double.MAX_VALUE;
        move bestmove = new move();
        bestmove.value = Double.MIN_VALUE;
        int maxdepth = 2;
        while (timeUP == false) {
            move move = alphabeta(this, 0, me, alpha, beta, maxdepth);
            bestmove = move;
            maxdepth = maxdepth + 2;
        }
        if (timeUP == false) {
            timer.cancel();
        }
        timeRemaining -= timeForMove;
        moveNumber++;
        return bestmove.move;
    }

    public boolean gameOver() {
        LinkedList mes=generateMoves(me);
        LinkedList opps=generateMoves(opp);
        return (mes.isEmpty()&&opps.isEmpty());
    }
    
    public void giveRefEndGame(){
        if (myColor == 'W') {
                    int t = 0;
                    for (int i = 0; i < 100; i++) {
                        if (board[i] == opp) {
                            t = t + 1;
                        }
                    }
                    System.out.println(t);
                }
        if (myColor == 'B') {
                    int t = 0;
                    for (int i = 0; i < 100; i++) {
                        if (board[i] == me) {
                            t = t + 1;
                        }
                    }
                    System.out.println(t);
                }
    }

    public void giveRefMyMove(int move) {
        if (move == 0) {
            System.out.println(myColor);
        } else {
            int col;
            char c = 'a';
            int row;
            row = move / 10;
            col = move % 10;
            if (col == 1) {
                c = 'a';
            }
            if (col == 2) {
                c = 'b';
            }
            if (col == 3) {
                c = 'c';
            }
            if (col == 4) {
                c = 'd';
            }
            if (col == 5) {
                c = 'e';
            }
            if (col == 6) {
                c = 'f';
            }
            if (col == 7) {
                c = 'g';
            }
            if (col == 8) {
                c = 'h';
            }
            System.out.println(myColor + " " + c + " " + row);

        }
    }

    public int getOppMove() {
        Scanner input = new Scanner(System.in);
        String st = input.nextLine();
        if (myColor == 'W') {
            st = st.replace("B", "");
        }
        if (myColor == 'B') {
            st = st.replace("W", "");
        }
        if (!st.isEmpty()) {
            char col = st.charAt(1);
            int row = Character.getNumericValue(st.charAt(3));
            row = row * 10;
            int move = 0;
            if (col == 'a' || col == 'A') {
                move = row + 1;
            }
            if (col == 'b' || col == 'B') {
                move = row + 2;
            }
            if (col == 'c' || col == 'C') {
                move = row + 3;
            }
            if (col == 'd' || col == 'D') {
                move = row + 4;
            }
            if (col == 'e' || col == 'E') {
                move = row + 5;
            }
            if (col == 'f' || col == 'F') {
                move = row + 6;
            }
            if (col == 'g' || col == 'G') {
                move = row + 7;
            }
            if (col == 'h' || col == 'H') {
                move = row + 8;
            }
            board[move] = opp;
            return move;
        } else {
            return pass;
        }
    }

    public void applyMove(int player, int move) {
        if (move != 0) {
            turns++;
            boolean end = false;
            board[move] = player;
            int temp = move;
            if (upleft(temp) == player * -1) {
                while (end == false) {
                    temp = temp - 11;
                    if (upleft(temp) == empty || upleft(temp) == edge) {
                        end = true;
                    }
                    if (upleft(temp) == player) {
                        while (end == false) {
                            board[temp] = player;
                            temp = temp + 11;
                            if (temp == move) {
                                end = true;
                            }
                        }
                    }
                }
            }
            temp = move;
            end = false;
            if (up(temp) == player * -1) {
                while (end == false) {
                    temp = temp - 10;
                    if (up(temp) == empty || up(temp) == edge) {
                        end = true;
                    }
                    if (up(temp) == player) {
                        while (end == false) {
                            board[temp] = player;
                            temp = temp + 10;
                            if (temp == move) {
                                end = true;
                            }
                        }
                    }
                }
            }
            temp = move;
            end = false;
            if (upright(temp) == player * -1) {
                while (end == false) {
                    temp = temp - 9;
                    if (upright(temp) == empty || upright(temp) == edge) {
                        end = true;
                    }
                    if (upright(temp) == player) {
                        while (end == false) {
                            board[temp] = player;
                            temp = temp + 9;
                            if (temp == move) {
                                end = true;
                            }
                        }
                    }
                }
            }
            temp = move;
            end = false;
            if (left(temp) == player * -1) {
                while (end == false) {
                    temp = temp - 1;
                    if (left(temp) == empty || left(temp) == edge) {
                        end = true;
                    }
                    if (left(temp) == player) {
                        while (end == false) {
                            board[temp] = player;
                            temp = temp + 1;
                            if (temp == move) {
                                end = true;
                            }
                        }
                    }
                }
            }
            temp = move;
            end = false;
            if (right(temp) == player * -1) {
                while (end == false) {
                    temp = temp + 1;
                    if (right(temp) == empty || right(temp) == edge) {
                        end = true;
                    }
                    if (right(temp) == player) {
                        while (end == false) {
                            board[temp] = player;
                            temp = temp - 1;
                            if (temp == move) {
                                end = true;
                            }
                        }
                    }
                }
            }
            temp = move;
            end = false;
            if (downleft(temp) == player * -1) {
                while (end == false) {
                    temp = temp + 9;
                    if (downleft(temp) == empty || downleft(temp) == edge) {
                        end = true;
                    }
                    if (downleft(temp) == player) {
                        while (end == false) {
                            board[temp] = player;
                            temp = temp - 9;
                            if (temp == move) {
                                end = true;
                            }
                        }
                    }
                }
            }
            temp = move;
            end = false;
            if (down(temp) == player * -1) {
                while (end == false) {
                    temp = temp + 10;
                    if (down(temp) == empty || down(temp) == edge) {
                        end = true;
                    }
                    if (down(temp) == player) {
                        while (end == false) {
                            board[temp] = player;
                            temp = temp - 10;
                            if (temp == move) {
                                end = true;
                            }
                        }
                    }
                }
            }
            temp = move;
            end = false;
            if (downright(temp) == player * -1) {
                while (end == false) {
                    temp = temp + 11;
                    if (downright(temp) == empty || downright(temp) == edge) {
                        end = true;
                    }
                    if (downright(temp) == player) {
                        while (end == false) {
                            board[temp] = player;
                            temp = temp - 11;
                            if (temp == move) {
                                end = true;
                            }
                        }
                    }
                }
            }

//Final will just take the best possible move from the myMovelist
        }
    }

    public double evaluate(int player) {
        int total = 0;
        int mes = 0;
        int opps = 0;
        for (int i = 0; i < 100; i++) {
            if (board[i] == me) {
                total = total + spaceValues[i];
                mes++;
            } else if (board[i] == opp) {
                total = total - spaceValues[i];
                opps++;
            }
        }
        if(!this.gameOver()){
            LinkedList<Integer> myMoves = generateMoves(me);
            LinkedList<Integer> oppMoves = generateMoves(opp);
            int movesDif = myMoves.size() - oppMoves.size();
            int scalar = 10;
            double tempValue = ((scalar * total) + (scalar * movesDif));
            return tempValue;
        }
        else{
            if(mes>opps){
                return 1000000000000000000.0;
            }
            else{
               return -1000000000000000000.0;
            }
        }
    }

    public void print() {
        if (myColor == 'W') {
            System.out.println("C   a b c d e f g h");
            int num = 1;
            for (int i = 10; i < 90; i = i + 10) {
                System.out.print("C " + num);
                for (int j = 0; j < 9; j++) {
                    if (board[i + j] == edge) {
                        System.out.print(" ");
                    }
                    if (board[i + j] == me) {
                        System.out.print("W ");
                    }
                    if (board[i + j] == opp) {
                        System.out.print("B ");
                    }
                    if (board[i + j] == empty) {
                        System.out.print("- ");
                    }
                }
                System.out.println();
                num++;
            }
        }
        if (myColor == 'B') {
            System.out.println("C   a b c d e f g h");
            int num = 1;
            for (int i = 10; i < 90; i = i + 10) {
                System.out.print("C " + num);
                for (int j = 0; j < 9; j++) {
                    if (board[i + j] == edge) {
                        System.out.print(" ");
                    }
                    if (board[i + j] == me) {
                        System.out.print("B ");
                    }
                    if (board[i + j] == opp) {
                        System.out.print("W ");
                    }
                    if (board[i + j] == empty) {
                        System.out.print("- ");
                    }
                }
                System.out.println();
                num++;
            }
        }
        //  System.out.println("C "+evaluate());
    }

    private move alphabeta(board currentBoard, int ply, int player, double alpha, double beta,
            int maxDepth) {//maxDepth Should only be Even Numbers
        if (ply >= maxDepth) {
            move temp = new move();
            temp.value = currentBoard.evaluate(player);
            return temp;
        } else {
            LinkedList<Integer> movesList = currentBoard.generateMoves(player);
            if (movesList.isEmpty()) {
                movesList.add(pass);
            }
            move bestMove = new move();
            bestMove.move = movesList.getFirst();
            while (timeUP == false) {
                for (Integer currentMove : movesList) {
                    board newBoard = new board(currentBoard);
                    newBoard.turns = currentBoard.turns;
                    newBoard.applyMove(player, currentMove);
                    move temp2 = new move(currentMove);
                    move temp = alphabeta(newBoard, ply + 1, -1 * player, -beta, -alpha, maxDepth);
                    temp2.value = -temp.value;
                    if (temp2.value >= alpha) {
                        bestMove = temp2;
                        alpha = temp2.value;
                        if (alpha > beta) {
                            return bestMove;
                        }
                    }
                }
            }
            return bestMove;
        }
    }

    class InterruptTask extends TimerTask {

        @Override
        public void run() {
            timeUP = true;
            timer.cancel();
        }
    }

}
