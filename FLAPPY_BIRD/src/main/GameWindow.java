/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import javax.swing.*;

public class GameWindow {
    private JFrame w; 
    
    public GameWindow(GamePanel gamePanel){
        w = new JFrame();
        w.setResizable(false);
        w.add(gamePanel);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.pack();
        w.setLocationRelativeTo(null);
        w.setVisible(true);
    }
}
