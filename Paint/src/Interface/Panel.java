/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import classes.FillShapeDecorate;
import classes.Circle;
import classes.Factory;
import classes.Line;
import classes.Rectangle;
import classes.Shapes;
import classes.Square;
import classes.Triangle;
import functions.Move;
import functions.Resize;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener, MouseMotionListener {

    Color currentColor = Color.BLACK;
    int mode = -1;
    int x1, y1;
    int x2, y2;
    public Shapes selectedShape = null;
    Factory f = new Factory();
    ArrayList<Shapes> stackShapes = new ArrayList<Shapes>();
    ArrayList<Shapes> x = new ArrayList<Shapes>();
    

    public Panel() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void push(ArrayList<Shapes> ss, Shapes s){
        stackShapes.add(s);
    }
    public void pop(ArrayList<Shapes> ss){
        stackShapes.remove(stackShapes.size()-1);
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Iterator<Shapes> it = x.iterator();
        while(it.hasNext()){
            Shapes s = it.next();
            s.draw(g);
            if(s == selectedShape && mode==10){
                FillShapeDecorate fsd = new FillShapeDecorate(currentColor, s);
                FillShapeDecorate.fillDraw(g);
            }
        }
    }
    
    /*public static void addRefilled(Shapes s){
        x.add(s);
    }*/

    @Override
    public void mouseClicked(MouseEvent me) {
        //Select(me.getX(), me.getY());
    }

    @Override
    public void mousePressed(MouseEvent me) {
        x1 = me.getX();
        y1 = me.getY();
        if (mode == 0) {  //line
           Shapes l = f.CreateShape(0, x1, y1, currentColor);
            x.add(l);
            push(stackShapes,l);
            repaint();
        } else if (mode == 1) { //rectangle
            Shapes r = f.CreateShape(1, x1, y1, currentColor);
            x.add(r);
            push(stackShapes,r);
            repaint();
        }
        else if (mode == 2) { //circle
            Shapes c = f.CreateShape(2, x1, y1, currentColor);
            x.add(c);
            push(stackShapes,c);
            repaint();
        }
        else if (mode == 3) { //square
            Shapes sq = f.CreateShape(3, x1, y1, currentColor);
            x.add(sq);
            push(stackShapes,sq);
            repaint();
        }
        
         else if (mode == 4){ //triangle
            Triangle t = (Triangle)f.CreateShape(4, x1, y1, currentColor);
            t.setX1(x1);
            t.setY1(y1);
            t.setX2(x1);
            t.setY2(y1);
            t.setX3(x1);
            t.setY3(y1);
            x.add(t);
            push(stackShapes,t);
            repaint();
        }
        
        else if(mode == 5){ //selected
            for(int i=x.size()-1 ; i>=0 ;i--){
                if(x.get(i).contains(me.getX(), me.getY(), x.get(i))){
                    selectedShape = x.get(i);
                    break;
                 } 
             }
        }
         else if(mode==7) // delete
        {
            if(selectedShape==null)
            {  JOptionPane.showMessageDialog(null,"No shapes in the selected area to delete");}
            else
            {x.remove( selectedShape);
            repaint();
          }
        }     
          else if (mode==9) //copy
        {      if(selectedShape instanceof Rectangle)
        {   
            try {
            Rectangle r = (Rectangle)selectedShape;
            Rectangle r2 =(Rectangle) r.clone();
            
            x.add(r2);
          Move.moveRect(r2,x1,y1);
            repaint();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
        
            }
        
        else if(selectedShape instanceof Square){
       
            try {
                Square s = (Square)selectedShape;
                Square s2 =(Square) s.clone();
                
                x.add(s2);
                Move.moveSquare(s2,x1,y1);
                repaint();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
        else   if(selectedShape instanceof Circle){
             try {
         Circle c = (Circle)selectedShape;
           Circle c2 =(Circle) c.clone();
            x.add(c2);
          Move.moveCircle(c2,x1,y1);
            repaint();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(selectedShape instanceof Line){
            try{
            Line l = (Line)selectedShape;
            Line l2 =(Line) l.clone(); 
            x.add(l2);
            Move.moveLine(l2,x1,y1);
            repaint();
            }catch (CloneNotSupportedException ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
         else if(selectedShape instanceof Triangle){
            try{
            Triangle t = (Triangle)selectedShape;
            Triangle t2 =(Triangle) t.clone(); 
            x.add(t2);
            Move.moveTriangle(t2,x1,y1);
            repaint();
            }catch (CloneNotSupportedException ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        }
        else if(mode==10)
          {selectedShape.setFilled(true);
          repaint();}
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (mode == 0) { //line
            x2 = me.getX();
            y2 = me.getY();
            Shapes s = x.get(x.size() - 1);
            if (s instanceof Line) {
                Line l = (Line) s;
                l.setX2(x2);
                l.setY2(y2);
            }
            repaint();
        }
        else if (mode == 1) { //rectangle
            x2 = me.getX();
            y2 = me.getY();
            Shapes s = x.get(x.size() - 1);
            if (s instanceof Rectangle){
                Rectangle r = (Rectangle) s;
                r.setX2(x2);
                r.setY2(y2);
            }

            repaint();
        }
        else if(mode == 2){ //circle
            x2 = me.getX();
            y2 = me.getY();
            Shapes s = x.get(x.size() - 1);
            if (s instanceof Circle) {
                Circle c = (Circle) s;
                c.setX2(x2);
                c.setY2(y2);
            }

            repaint();
        }
        else if(mode == 3){ //square
            x2 = me.getX();
            y2 = me.getY();
            Shapes sq = x.get(x.size() - 1);
            if (sq instanceof Square) {
                Square squ = (Square) sq;
                squ.setX2(x2);
                squ.setY2(y2);
            }

            repaint();
        }
        else if(mode == 4){ //triangle
            x2 = me.getX();
            y2 = me.getY();
            if (x.get(x.size() - 1) instanceof Triangle) {
                Triangle t = (Triangle) x.get(x.size() - 1);
                if(x1<x2){ //point is to the right
                    t.setX2(x2);
                    t.setY2(y2);
                    int y3 = y2;
                    int x3 = x1+(x1-x2);
                    t.setX3(x3);
                    t.setY3(y3);
                }
                else { //point to the left
                    t.setX2(x2);
                    t.setY2(y2);
                    int y3 = y2;
                    int x3 = (2*x1)-x2;
                    t.setX3(x3);
                    t.setY3(y3);
                }
            repaint();
 
        }
        }
        else if (mode == 6){ //resize
            if (selectedShape != null){
                int x = me.getX();
                int y = me.getY();
                System.out.println(x + " , " + y);
                if(selectedShape instanceof Rectangle){
                    Rectangle r =(Rectangle)selectedShape;
                    Resize.resizeRect(r, x, y);              
                    repaint();
                }
                else if(selectedShape instanceof Square){
                    Square sq = (Square)selectedShape;
                    Resize.resizeSquare(sq, x, y);
                    repaint();
     
                }
                 else if(selectedShape instanceof Circle){
                    Circle c = (Circle)selectedShape;
                    Resize.resizeCircle(c, x, y);
                    repaint();
     
                }
                 else if(selectedShape instanceof Line){
                     Line l =(Line)selectedShape;
                     Resize.resizeLine(l, x, y);
                     repaint();
                 }
                 else if(selectedShape instanceof Triangle){
                     Triangle t = (Triangle)selectedShape;
                     Resize.resizeTri(t, x, y);
                     repaint();
                 }
              
            }
        }
        else if(mode==8) { //move
            x2 = me.getX();
            y2 = me.getY();
            if(selectedShape instanceof Rectangle)
        {
            Rectangle r = (Rectangle)selectedShape;
            Move.moveRect(r, x2, y2);    
            repaint();
        }
         if(selectedShape instanceof Square){
          Square s= (Square)selectedShape;
          Move.moveSquare(s, x2, y2);
              repaint();
      
         }
          if(selectedShape instanceof Circle){
           Circle c= (Circle)selectedShape;
            Move.moveCircle(c,x2,y2);
              repaint();
          }
          if(selectedShape instanceof Line){
          Line l= (Line)selectedShape;
          Move.moveLine(l, x2, y2);
              repaint();
      
         }
            if(selectedShape instanceof Triangle){
          Triangle t= (Triangle)selectedShape;
          Move.moveTriangle(t, x2, y2);
              repaint();
         }
           
          
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

}
