/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Rectangle;
import java.util.Random;

public class Obstacle {
    int x, y, width, height;
    Rectangle topPipe, bottomPipe;
    int distance = 100;
    boolean isPassedOn = false;

    public Obstacle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        topPipe = new Rectangle(x, y, width, height);
        bottomPipe = new Rectangle(x, height + distance, width, height);
    }

    public void resetToNewPosition(int newX) {
        topPipe.x = newX;
        bottomPipe.x = newX;
        x = newX;
        topPipe.y = -(new Random().nextInt(140) + 100);
        bottomPipe.y = topPipe.y + height + distance;
        isPassedOn = false;
    }

    public boolean intersect(Rectangle rectangle) {
        return rectangle.intersects(topPipe) || rectangle.intersects(bottomPipe);
    }

    public boolean passedOn(Rectangle rectangle) {
        return rectangle.x > x + width && !isPassedOn;
    }

    public void moveX(int dx) {
        x -= dx;
        topPipe.x -= dx;
        bottomPipe.x -= dx;
    }

}
