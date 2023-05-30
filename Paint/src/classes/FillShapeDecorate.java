/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.Circle;
import classes.Rectangle;
import classes.Shapes;
import java.awt.Color;
import java.awt.Graphics;
import Interface.Panel;

/**
 *
 * @author Lenovo
 */
public class FillShapeDecorate {
  static Shapes s;
  Color color;
    public FillShapeDecorate(Color color,Shapes s) {
        this.color = color;
        System.out.println("classes.FillShapeDecorate");
        this.s=s;
    }


    public static void fillDraw(Graphics g) {
        s.draw(g);
        System.out.println("Inside decorate");
        if(s instanceof Rectangle){
            Rectangle r=(Rectangle)s;
            g.fillRect(r.getX1(), r.getY1(), r.getX2()-r.getX1(), r.getY2()-r.getY1());
            r.draw(g);
        }
        else if(s instanceof Square){
            Square sq=(Square)s;
            g.fillRect(sq.getX1(), sq.getY1(), sq.getX2()-sq.getX1(), sq.getX2()-sq.getX1());
            sq.draw(g);
        }  
        else if(s instanceof Circle){
            Circle c = (Circle)s;
            g.fillOval(c.getX1(), c.getY1(),c.getX2()-c.getX1(), c.getX2()-c.getX1());
            c.draw(g);
            //Panel.addRefilled(c);
        }
        else if(s instanceof Triangle){
            Triangle t = (Triangle)s;
            g.fillPolygon(t.polyX, t.polyY, 3);
            t.draw(g);
        }
    }

    
}

