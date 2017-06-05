package com.java.supermario.main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import javax.swing.JFrame;

import com.java.supermario.constants.Constants;
import com.java.supermario.environment.MenuScreen;

public class Central extends JFrame implements Constants, ActionListener, KeyListener {
	private boolean isStart;
	Timer timer;
	private MenuScreen menu;
	
	public Central(){
		this.setTitle("Super Mario");
		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu = new MenuScreen();
		isStart = false;
		timer = new Timer(100, this);
		timer.start();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(!isStart){
			menu.paint(g);
		}
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
	
	


}
