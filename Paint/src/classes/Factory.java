/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;

/**
 *
 * @author HP
 */
public class Factory {

    /**
     *
     * @param x
     * @return
     */
    public Shapes CreateShape (int x, int x1, int y1, Color currentColor){
        Shapes s = null;
        if (x==0)
          s= new Line(x1, y1, x1, y1, currentColor);
        else if (x==1)
           s= new Rectangle(x1, y1, x1, y1, currentColor);
        else if (x==2)
          s= new Circle(x1,y1,x1,y1,currentColor);
        else if (x==3)
           s= new Square(x1,y1,x1,y1,currentColor);
        else if (x==4)
            s= new Triangle(currentColor);
        
            return s;
    }
    
}
