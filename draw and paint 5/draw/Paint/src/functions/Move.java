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
        int halfLength = Math.abs(l.getX1() - l.getX2()) / 2;
        l.setX1(x - halfLength);
        l.setY1(y - halfLength);
        l.setX2(x + halfLength);
        l.setY2(y + halfLength);

    }
}
