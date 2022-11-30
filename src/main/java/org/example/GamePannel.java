package org.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GamePannel extends JPanel implements ActionListener {

    public final int width=800;
    public final int height=800;
    public final int grid=50;
    public final int delay=60;
    public final  int []snakeX=new int[128];
    public final  int []snakeY=new int[128];

    Timer timer;
    int snakeBody=6;
    int appleX;
    int appleY;

    int appleEaten=0;

    static char direction='r';
    Random random;
    boolean running;
     public  GamePannel()
     {
        this.random=new Random();
        this.setBackground(Color.black);
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(width,height));

        start();
     }
    public  void start(){
        newApple();
        running = true;
        timer=new Timer(delay,this);
        timer.start();
    }

    /**
     * 產生Apple
     */
    public void newApple(){
         //grid =50;
         appleX=(random.nextInt(width/grid-1)+1)*grid;
         appleY=(random.nextInt(height/grid-1)+1)*grid;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g); //複寫
    }
    public void draw(Graphics g){
        g.setColor(Color.cyan);
        for (int i =1; i <height/grid; i++) {

            g.drawLine(grid*i, 0, grid*i, 800);
            g.drawLine(0, grid*i, 800, grid*i);
        }

        //畫蘋果
        g.setColor(Color.red);
        g.fillOval(appleX,appleY,grid,grid);


        //畫蛇
        for(int i=0;i<snakeBody;i++){
            if(i==0){
                g.setColor(Color.GREEN);
                g.fillRect(snakeX[i],snakeY[i],grid,grid);
            }
            else{
                g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                g.fillRect(snakeX[i],snakeY[i],grid,grid);
            }
        }
    }

    public void gameOver(){}

    public void move(){

        for(int i=snakeBody;i>0;i--){
            snakeX[i]=snakeX[i-1];
            snakeY[i]=snakeY[i-1];
        }

        switch (direction) {
            case 'u' -> snakeY[0] = snakeY[0] - grid;
            case 'd' -> snakeY[0] = snakeY[0] + grid;
            case 'l' -> snakeX[0] = snakeX[0] - grid;
            case 'r' -> snakeX[0] = snakeX[0] + grid;
            default -> {}
        }

    }

    public void checkApple(){
         if(snakeX[0]==appleX&&snakeY[0]==appleY){
             newApple();
             appleEaten++;
             snakeBody++;
         }


    }

    //蛇碰到自己 或是牆壁四周
    public void checkSnakeCollision(){
        for(int i=snakeBody;i>0;i--){
            if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                running = false;
                break;
            }
        }
        if(snakeX[0]<0||snakeX[0]>width||snakeY[0]<0||snakeY[0]>height){
            running=false;
        }
        if(!running){
            timer.stop();
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
         if(running){
             move();
             checkApple();
             checkSnakeCollision();
         }
        repaint();
    }

}

