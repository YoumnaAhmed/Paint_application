/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.undo.*;
import javax.swing.text.*;
import javax.swing.event.*;

/**
 *
 * @author es-SalmaHasan2024
 */
public class UndoRedo {
    JButton b1, b2;
    UndoManager manager = new UndoManager();
    public UndoRedo() {
	manager = new UndoManager();
	b1 = new JButton("Undo");
	b2 = new JButton("Redo");
	
        b1.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
				try { manager.undo();} catch (Exception ex) {}
			}
		});
	b2.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				try { manager.redo();
				} catch (Exception ex) {}
			}
		});
		
		
		.addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				manager.addEdit(e.getEdit());
			}
		});
		p.add(pane);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		add(p);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		UndoRedo op = new UndoRedo();
	}
}
