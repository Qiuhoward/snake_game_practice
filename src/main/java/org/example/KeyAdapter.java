package org.example;

import java.awt.event.KeyEvent;

import static org.example.GamePannel.direction;

public class KeyAdapter extends java.awt.event.KeyAdapter {
    public  void keyPressed(KeyEvent event){
       int code= event.getKeyCode();
        switch (code){
            case KeyEvent.VK_DOWN:
                if(direction!='u'){
                    direction='d';
                 }
                break;
            case KeyEvent.VK_UP:
                if(direction!='d'){
                    direction='u';
                }
                break; case KeyEvent.VK_LEFT:
                if(direction!='r'){
                    direction='l';
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(direction!='l'){
                    direction='r';
                }
                break;


        }
    }


}
