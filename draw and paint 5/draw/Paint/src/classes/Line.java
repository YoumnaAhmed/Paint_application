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
 * @author Lenovo
 */
public class Line extends Shapes implements Cloneable {

    private int x1,x2,y1,y2;
    
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
    
    public Line(int x1,int y1,int x2,int y2,Color color) {
        super(color);
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        
    }
    
    @Override
     public void draw(Graphics g){
        g.setColor(getColor());
        g.drawLine(x1, y1, x2, y2);
     }

    @Override
    public boolean contains(int x, int y, Shapes s) {
        /*java.awt.Rectangle l = new java.awt.Rectangle(this.x1, this.y1, this.x2, this.y2);
        if(l.contains(x,y)){
            System.out.println("inside line");
            return true;
        }
        return false;*/
        
        if(x1!=x2 && y1!=y2)
            return (y-y1)/(y2-y1)==(x-x1)/(x2-x1);
        else if(y1==y2)
            return (y==y1 && ((x>=x1 && x<=x2) || (x<=x1 && x>=x2)));
        else
            return (x==x1 && ((y>=y1 && y<=y2) || (y<=y1 && y>=y2)));
      
    }
    public Object clone() throws CloneNotSupportedException {
  Line l =(Line)super.clone();
       return l;
    }
    
}
