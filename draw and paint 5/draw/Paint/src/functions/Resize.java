/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import classes.Circle;
import classes.Line;
import classes.Rectangle;
import classes.Square;
import classes.Triangle;


/**
 *
 * @author es-SalmaHasan2024
 */
public class Resize {
    public static void resizeRect(Rectangle r, int x, int y){
        int x1 = r.getX1();
        int x2 = r.getX2();
        int y1 = r.getY1();
        int y2 = r.getY2();
        if(Math.abs(x1-x) < Math.abs(x2-x)){ //point is nearer to left side
            if(Math.abs(y1-y) < Math.abs(y2-y)){ //point is nearer to upper side
                r.setX1(x);
                r.setY1(y);
            }
            else if(Math.abs(y1-y) > Math.abs(y2-y)){ //point is nearer to down side
                r.setX1(x);
                r.setY2(y);
                }   
            }
        else if(Math.abs(x1-x) > Math.abs(x2-x)){ // point is nearer to right side
            if(Math.abs(y1-y) < Math.abs(y2-y)){ //point is nearer to upper side
                r.setX2(x);
                r.setY1(y); 
            }
            else if(Math.abs(y1-y) > Math.abs(y2-y)){ //point is nearer to down side
                r.setX2(x);
                r.setY2(y);
            } 
        }        
    }
    
    public static void resizeSquare(Square s, int x, int y){
        int x1 = s.getX1();
        int x2 = s.getX2();
        int y1 = s.getY1();
        int y2 = s.getY2();
        if(Math.abs(x1-x) < Math.abs(x2-x)){ //point is nearer to left side
            if(Math.abs(y1-y) < Math.abs(y2-y)){ //point is nearer to upper side
                s.setX1(x);
                s.setY1(y);
            }
            else if(Math.abs(y1-y) > Math.abs(y2-y)){ //point is nearer to down side
                s.setX1(x);
                s.setY2(y);
                }   
            }
        else if(Math.abs(x1-x) > Math.abs(x2-x)){ // point is nearer to right side
            if(Math.abs(y1-y) < Math.abs(y2-y)){ //point is nearer to upper side
                s.setX2(x);
                s.setY1(y); 
            }
            else if(Math.abs(y1-y) > Math.abs(y2-y)){ //point is nearer to down side
                s.setX2(x);
                s.setY2(y);
            } 
        }   
    }
    
    public static void resizeCircle(Circle c, int x, int y){
        int x1 = c.getX1();
        int x2 = c.getX2();
        int y1 = c.getY1();
        int y2 = c.getY2();
        if(Math.abs(x1-x) < Math.abs(x2-x)){ //point is nearer to left side
            if(Math.abs(y1-y) < Math.abs(y2-y)){ //point is nearer to upper side
                c.setX1(x);
                c.setY1(y);
            }
            else if(Math.abs(y1-y) > Math.abs(y2-y)){ //point is nearer to down side
                c.setX1(x);
                c.setY2(y);
                }   
            }
        else if(Math.abs(x1-x) > Math.abs(x2-x)){ // point is nearer to right side
            if(Math.abs(y1-y) < Math.abs(y2-y)){ //point is nearer to upper side
                c.setX2(x);
                c.setY1(y); 
            }
            else if(Math.abs(y1-y) > Math.abs(y2-y)){ //point is nearer to down side
                c.setX2(x);
                c.setY2(y);
            } 
        }   
    }
    
    public static void resizeLine(Line l, int x, int y){
        int x1 = l.getX1();
        int x2 = l.getX2();
        int y1 = l.getY1();
        int y2 = l.getY2();
        
            if(Math.abs(x1-x) < Math.abs(x2-x)){ //top left is first point
                l.setX1(x);
                l.setY1(y);
                
            }
            else if(Math.abs(x1-x) > Math.abs(x2-x) ){
                    l.setX2(x);
                    l.setY2(y);
            }
            
       
    }
    public static void resizeTri(Triangle t, int x, int y){

        if(Math.abs(t.polyX[0]-x) < Math.abs(t.polyX[1]-x) && Math.abs(t.polyX[0]-x) < Math.abs(t.polyX[2]-x)){
            t.polyX[0]=x;
            t.polyY[0]=y;
        }
        else if(Math.abs(t.polyX[1]-x) < Math.abs(t.polyX[0]-x) && Math.abs(t.polyX[1]-x) < Math.abs(t.polyX[2]-x)){
            t.polyX[1]=x;
            t.polyY[1]=y;
        }
        else if(Math.abs(t.polyX[2]-x) < Math.abs(t.polyX[0]-x) && Math.abs(t.polyX[2]-x) < Math.abs(t.polyX[1]-x)){
            t.polyX[2]=x;
            t.polyY[2]=y;
        }
    }
    
    
}
