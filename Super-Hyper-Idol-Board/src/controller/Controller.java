package controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import canvasObjects.CanvasClass;
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

		menuOptions.editionPanel.delete_class_button.addActionListener(event -> {
			canvas.deleteCanvasClass(canvas.focused_class);
			canvas.repaint();
		});
	  
		menuOptions.editionPanel.change_name_button.addActionListener(event -> {
			// canvas.getFocusedCanvasClass().printLabelXY();
			canvas.getFocusedCanvasClass().setCanvasClassName(menuOptions.textFieldPanel.textField.getText());
			// canvas.getFocusedCanvasClass().printLabelXY();
			canvas.repaint();
		});
                
                //menuOptions.colorComboBox.addActionListener(event -> {
                //        canvas.getFocusedCanvasClass().setBoundColor(Color.BLACK);
                //});
		
		menuOptions.editionPanel.add_attribute_button.addActionListener(event -> {
			CanvasClass f = this.canvas.getFocusedCanvasClass();
			if (f != null) {
				f.addAttribute(menuOptions.textFieldPanel.textField.getText());
				this.canvas.repaint();
			}
		});
		menuOptions.editionPanel.add_method_button.addActionListener(event -> {
			CanvasClass f = this.canvas.getFocusedCanvasClass();
			if (f != null) {
				f.addMethod(menuOptions.textFieldPanel.textField.getText());
				this.canvas.repaint();
			}
		});

		this.setBackground(Color.CYAN);
		this.setLayout(new BorderLayout());      
		this.add(menuOptions, BorderLayout.WEST);
		this.add(canvas, BorderLayout.CENTER);
		this.addMouseListener(this);
		this.canvas.addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		menuOptions.paintComponent(g);
		canvas.paintComponent(g);
	}

	public void setNewFocusedClass(int new_focus) {
		this.canvas.setNewFocusedClass(new_focus);
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		setNewFocusedClass(canvas.clickedOnAnyClass(me.getX(), me.getY()));
		this.repaint();
		this.canvas.moving_class = this.canvas.clickedOnAnyClass(me.getX(), me.getY());
		this.repaint();
	}
	@Override
	public void mousePressed(MouseEvent me) {
		setNewFocusedClass(canvas.clickedOnAnyClass(me.getX(), me.getY()));
		this.canvas.moving_class = this.canvas.clickedOnAnyClass(me.getX(), me.getY());
		this.repaint();
	}
	@Override
	public void mouseReleased(MouseEvent me) {}
	@Override
	public void mouseEntered(MouseEvent me) {}
	@Override
	public void mouseExited(MouseEvent me) {}
}
