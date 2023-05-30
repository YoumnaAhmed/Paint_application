/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author es-SalmaHasan2024
 */
public abstract class Shapes{
    private Color color;

    public Shapes(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public abstract boolean contains(int x, int y, Shapes s);
    /*public void resize(){
        
    }*/
    public abstract void draw(Graphics g);
    
    
}
