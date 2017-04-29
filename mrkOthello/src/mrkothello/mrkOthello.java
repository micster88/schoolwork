
package mrkothello;

import java.util.Scanner;

public class mrkOthello {
    public static void main(String[] args) {
        int me=1;
        int opp=-1;
        int turn=opp;
        int move=0;
        Scanner input= new Scanner(System.in);
        String st=input.nextLine();
        st=st.replace("I ", "");
        char myColor=st.charAt(0);
        board gameBoard=new board(myColor);
        gameBoard.print();
        if(myColor=='B'){
            turn=me;
        }
        while(!gameBoard.gameOver()){
            if(turn==me){
                move=gameBoard.getMyMove();
                gameBoard.giveRefMyMove(move);
            }
            else{
                move=gameBoard.getOppMove();
            }
            gameBoard.applyMove(turn, move);
            gameBoard.print();
            turn=turn * (-1);
        }
        gameBoard.giveRefEndGame();
    }

    
}
