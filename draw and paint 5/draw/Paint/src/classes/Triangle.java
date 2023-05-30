/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import java.awt.Graphics;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.geometry.Point2D;
import java.util.ArrayList;

/**
 *
 * @author es-SalmaHasan2024
 */
public class Triangle extends Shapes implements Cloneable {
    private GraphicsContext graphicsContext;
    public int[] polyX = new int[3];
    public int[] polyY = new int[3];

    public Triangle(Color currentColor) {
        super(currentColor);
    }

   
    public void addPoint(int x, int y){
        for(int i=0;i<3;i++){
            polyX[i] = x;
            polyY[i] = y;
        }
    }
    
    public void addPoint2(int x, int y){
        polyX[1] = x;
        polyY[1] = y;
    }
    public void addPoint3(int x, int y){
        polyX[2] = x;
        polyY[2] = y;
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
        for(int i=0;i<3;i++){
            if(i==0)
            System.out.println("first: " + polyX[i] + " , " + polyY[i]);
            if(i==1)
            System.out.println("second: " + polyX[i] + " , " + polyY[i]);
            if(i==2)
            System.out.println("third: " + polyX[i] + " , " + polyY[i]);
        }
        g.setColor(getColor());
        g.drawPolygon(polyX, polyY, 3);
      
    }
      protected Object clone() throws CloneNotSupportedException {
    Triangle t =(Triangle)super.clone();

       return t;
    }
}
