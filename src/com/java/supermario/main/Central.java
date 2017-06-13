package com.java.supermario.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import javax.swing.JFrame;

import com.java.supermario.constants.Constants;
import com.java.supermario.environment.DefaultBackground;
import com.java.supermario.environment.MenuScreen;
import com.java.supermario.environment.Player;

public class Central extends JFrame implements Constants, ActionListener, KeyListener {
	private boolean isStart;
	Timer timer;
	private MenuScreen menu;
	Player player1;
	DefaultBackground background;
	private Image img;
	private Graphics gfx;
	public Central(){
		this.setTitle("Super Mario");
		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		img = createImage(1000,700);
		gfx = img.getGraphics();
		player1 = new Player();
		background = new DefaultBackground();
		menu = new MenuScreen();
		isStart = false;
		timer = new Timer(90, this);
		timer.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(gfx);
		if(isStart){
			menu.paint(gfx);
		}else{	
			background.paint(gfx);
			player1.paint(gfx);		
		}
		g.drawImage(img, 0, 0, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		repaint();
		player1.setSprites();
		player1.move();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_DOWN)
			player1.setDown(true);

		if(e.getKeyCode() == e.VK_LEFT)
			player1.setLeft(true);

		if(e.getKeyCode() == e.VK_RIGHT)
			player1.setRight(true);

		if(e.getKeyCode() == e.VK_SPACE)
			player1.setJump(true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == e.VK_DOWN)
			player1.setDown(false);

		if(e.getKeyCode() == e.VK_LEFT)
			player1.setLeft(false);

		if(e.getKeyCode() == e.VK_RIGHT)
			player1.setRight(false);

		//		if(e.getKeyCode() == e.VK_SPACE)
		//			player1.setJump(false);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}


}
