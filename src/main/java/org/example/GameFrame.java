package org.example;

import javax.swing.*;

public class GameFrame extends JFrame {

   public  GameFrame(){
       this.add(new GamePannel());
       this.setTitle("snake_game");
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.pack(); // 將其尺寸設定為可以將frame所有元件包起來的大小
       this.setResizable(false);
       this.setVisible(true);
       this.setLocationRelativeTo(null);//自動置中
       this.addKeyListener(new KeyAdapter());
   }


}
