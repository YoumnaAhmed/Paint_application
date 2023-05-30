/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import classes.Circle;
import classes.Rectangle;
import classes.Square;
import classes.Line;
import classes.Triangle;

/**
 *
 * @author es-SalmaHasan2024
 */
public class Move {

    public static void moveRect(Rectangle r, int x, int y) {
        int halfLength = Math.abs(r.getX1() - r.getX2()) / 2;
        int halfWidth = Math.abs(r.getY1() - r.getY2()) / 2;
        r.setX1(x - halfLength);
        r.setY1(y - halfWidth);
        r.setX2(x + halfLength);
        r.setY2(y + halfWidth);
    }

    public static void moveSquare(Square s, int x, int y) {
        int halfSide = Math.abs(s.getX1() - s.getX2()) / 2;
        s.setX1(x - halfSide);
        s.setY1(y - halfSide);
        s.setX2(x + halfSide);
        s.setY2(y + halfSide);
    }

    public static void moveCircle(Circle c, int x, int y) {
        int radius = Math.abs(c.getX1() - c.getX2()) / 2;
        c.setX1(x - radius);
        c.setY1(y - radius);
        c.setX2(x + radius);
        c.setY2(y + radius);
    }

   public static void moveLine(Line l, int x, int y) {
       int midX=Math.abs(l.getX1()+l.getX2())/2;
        int midY=Math.abs(l.getY1()+l.getY2())/2;
      
        /*if(l.getX1()<l.getX2())
        minX=l.getX1();
        else
                minX=l.getX2();
     if(l.getY1()<l.getY2())
        minY=l.getY1();
        else
         minY=l.getY2();*/
     int shiftX=x-midX;
     int shiftY=y-midY;
     l.setX1(l.getX1()+shiftX);
     l.setY1(l.getY1()+shiftY);
     l.setX2(l.getX2() + shiftX);
     l.setY2(l.getY2()+ shiftY);
     
        
        }
     public static void moveTriangle(Triangle t, int x, int y) {
         int midX=(t.getX2()+t.getX3())/2;
         int midY=(t.getY1()+t.getY2())*2/3;
         int shiftX=(x)-midX;
         int shiftY=y-midY;
       t.setX1(t.getX1()+shiftX);
     t.setY1(t.getY1()+shiftY);
     t.setX2(t.getX2() + shiftX);
     t.setY2(t.getY2()+ shiftY);
     t.setX3(t.getX3() + shiftX);
     t.setY3(t.getY3()+ shiftY);
     }
}
