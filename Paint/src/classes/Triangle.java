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
public class Triangle extends Shapes implements Cloneable {

    public int[] polyX = new int[3];
    public int[] polyY = new int[3];
    private int x1,x2,x3,y1,y2,y3;

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

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
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

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }
    public Triangle(Color currentColor) {
        super(currentColor);
    }

   
      public void initialize(){
     
      polyX[0]=this.x1;
      polyX[1]=this.x2;
      polyX[2]=this.x3;
      polyY[0]=this.y1;
      polyY[1]=this.y2;
      polyY[2]=this.y3;
      
      }
    @Override
    public boolean contains(int x, int y, Shapes s) {
        java.awt.Polygon t = new java.awt.Polygon(polyX, polyY, 3);
        if(t.contains(x, y))
        {
            System.out.println("inside triangle");
            return true;
        }

        return false;
    }

    @Override
    public void draw(Graphics g) {
        initialize();
        g.setColor(getColor());
        if(!isFilled())
        g.drawPolygon(polyX, polyY, 3);
        else
            
      g.fillPolygon(polyX, polyY, 3);
    }
      public Object clone() throws CloneNotSupportedException {
    Triangle t =(Triangle)super.clone();
    

       return t;
    }
}
