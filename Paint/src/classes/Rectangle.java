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
public class Rectangle extends Shapes implements Cloneable {
    private int x1,x2,y1,y2;

    public Rectangle(int x1, int y1, int x2, int y2, Color color) {
        super(color);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g){
       if(!isFilled())
        {g.setColor(getColor());
        if (x1 > x2 && y1 > y2) 
            g.drawRect(x2, y2, Math.abs(x2-x1), Math.abs(y2-y1));
        else if(x1 > x2 && y2 > y1)
            g.drawRect(x2, y1, Math.abs(x2-x1), Math.abs(y2-y1));
        else if(x1 < x2 && y1 > y2)
            g.drawRect(x1, y2, Math.abs(x2-x1), Math.abs(y2-y1));
        else 
        g.drawRect(x1, y1, x2-x1, y2-y1);
        }
        else
        {g.setColor(getColor());
        if (x1 > x2 && y1 > y2) 
            g.fillRect(x2, y2, Math.abs(x2-x1), Math.abs(y2-y1));
        else if(x1 > x2 && y2 > y1)
            g.fillRect(x2, y1, Math.abs(x2-x1), Math.abs(y2-y1));
        else if(x1 < x2 && y1 > y2)
            g.fillRect(x1, y2, Math.abs(x2-x1), Math.abs(y2-y1));
        else 
        g.fillRect(x1, y1, x2-x1, y2-y1);
            
        }
    }

    @Override
    public boolean contains(int x, int y, Shapes s) {
        java.awt.Rectangle rec = new java.awt.Rectangle(this.x1, this.y1, Math.abs(this.x2 - this.x1), Math.abs(this.y2 - this.y1));
        if(rec.contains(x, y))
        {
            System.out.println("inside rectangle");
            return true;
        }

        return false;
    }
public Object clone() throws CloneNotSupportedException {
    Rectangle r=(Rectangle)super.clone();
       return r;
    }


    
}
