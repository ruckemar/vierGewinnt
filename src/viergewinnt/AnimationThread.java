/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

import java.awt.Color;

/**
 *
 * @author Markus
 */
public class AnimationThread extends Thread {
    private final GUI gui;
    private final Game game;
    private final Integer turn;
    private final Integer x;    
    
    public AnimationThread(GUI gui, Game game,Integer turn, Integer x) {
        this.gui = gui;
        this.game = game;
        this.turn = turn;
        this.x = x;
    }

    @Override
    public void run(){       
        int d = 0;
        do{
            try {                
                for (int i = 0; i < 6; i++) {
                    if (game.getCurrentFieldStatus(x, i) != 0) {
                        d++;
                    } else {
                        if(i-1 >= 0)gui.getFieldElement(x, i-1).setBackground(Color.WHITE);
                        switch (turn) {
                            case 1:
                                gui.getFieldElement(x, i).setBackground(Color.RED);
                                break;                    
                            case 2:
                                gui.getFieldElement(x, i).setBackground(Color.YELLOW);
                                break;
                        }
                    }
                    Thread.sleep(500); 
                }                
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            if(isInterrupted()){
                break;
            }  
        }while(true && d >= 3);
    }    
}
