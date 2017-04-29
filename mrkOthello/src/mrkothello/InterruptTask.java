/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mrkothello;

import java.util.TimerTask;

/**
 *
 * @author Macintosh
 */
class InterruptTask extends TimerTask {
      public void run() {
	  board.timeUP = true;
          board.timer.cancel();
      }
}
