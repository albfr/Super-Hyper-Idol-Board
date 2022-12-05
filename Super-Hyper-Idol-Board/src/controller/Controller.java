package controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import panels.*;

public class Controller extends JPanel implements MouseListener {
   private Canvas canvas;
   private MenuOptions menuOptions;
   public Controller() {
      canvas = new Canvas(); // View
      menuOptions = new MenuOptions(); // Model
      
      menuOptions.editionPanel.create_class_button.addActionListener(event -> {
         canvas.createNewCanvasClass();
         canvas.repaint();
      });

      this.setBackground(Color.CYAN);
      this.setLayout(new BorderLayout(160, 40));      
      this.add(menuOptions, BorderLayout.WEST);
      this.add(canvas, BorderLayout.CENTER);
      this.addMouseListener(this);
      this.canvas.addMouseListener(this);
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      menuOptions.paintComponent(g);
      canvas.paintComponents(g);
   }

   public void setNewFocusedClass(int new_focus) {
      this.canvas.setNewFocusedClass(new_focus);
   }

   @Override
   public void mouseClicked(MouseEvent me) {
      setNewFocusedClass(canvas.clickedOnAnyClass(me.getX(), me.getY()));
      this.repaint();
   }
   @Override
   public void mousePressed(MouseEvent me) {}
   @Override
   public void mouseReleased(MouseEvent me) {}
   @Override
   public void mouseEntered(MouseEvent me) {}
   @Override
   public void mouseExited(MouseEvent me) {}
}