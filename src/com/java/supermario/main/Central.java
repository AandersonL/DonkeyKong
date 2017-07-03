package com.java.supermario.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import org.json.*;
import javax.swing.Timer;
import javax.swing.JFrame;
import com.java.supermario.constants.Constants;
import com.java.supermario.environment.Boss;
import com.java.supermario.environment.DefaultBackground;
import com.java.supermario.environment.MenuScreen;
import com.java.supermario.environment.Network;
import com.java.supermario.environment.Player;
import com.java.supermario.environment.Stage0;
import com.java.supermario.utils.Collisions;


public class Central extends JFrame implements Constants, ActionListener, KeyListener {
	private boolean isStart;
	Timer timer;
	private boolean isServidor;
	private MenuScreen menu;
	public static Player player1;
	public static Boss kong;
	DefaultBackground background;
	public static Stage0 stageZero;
	private Collisions collisions;
	private Image img;
	private Graphics gfx;
	private Network network;
	private JSONObject dataFinal;
	public Central(){
		Scanner scan;
		this.setTitle("Donkey Kong Arcade");
		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		img = createImage(1000,700);
		gfx = img.getGraphics();
		player1 = new Player();
		kong = new Boss();
		background = new DefaultBackground();
		stageZero = new Stage0();
		menu = new MenuScreen();
		collisions = new Collisions();
		isStart = false;
		network = new Network();
		timer = new Timer(90, this);
		
		scan = new Scanner(System.in);
		System.out.println("Quer ser servidor?");
		String esc = scan.nextLine();
		if(esc.equals("y")){
			network.escuta();
			isServidor = true;
		}
			
		else{
			network.conecta("localhost", 4444);
			isServidor = false;
		}
			
		timer.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(gfx);
		gfx.drawString("Dados " + network.retornaDados(), 200, 300);
		if(isStart){
			menu.paint(gfx);
		}else{			
			background.paint(gfx);
			stageZero.paint(gfx);
			kong.paint(gfx);
			player1.paint(gfx);	
			
		}
		
		g.drawImage(img, 0, 0, this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		player1.setSprites();
		player1.move();
		
		if(!kong.getAction())
			kong.setSprite();
		else
			kong.lancaBarril();
		
		collisions.checkCollision();
		repaint();
		onlineData();
		onlineControl();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//Mario
		if(e.getKeyCode() == e.VK_DOWN)
			player1.setDown(true);

		if(e.getKeyCode() == e.VK_LEFT)
			player1.setLeft(true);

		if(e.getKeyCode() == e.VK_RIGHT)
			player1.setRight(true);

		if(e.getKeyCode() == e.VK_SPACE)
			player1.setJump(true);
		
		if(e.getKeyCode() == e.VK_UP)
			player1.setUp(true);
		//Donkey Kong
		
		if(e.getKeyCode() == e.VK_F)
			kong.lancaBarril();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == e.VK_DOWN)
			player1.setDown(false);

		if(e.getKeyCode() == e.VK_LEFT)
			player1.setLeft(false);

		if(e.getKeyCode() == e.VK_RIGHT)
			player1.setRight(false);
		
		if(e.getKeyCode() == e.VK_UP)
			player1.setUp(false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void onlineData(){
		JSONObject jsonData = new JSONObject();
		jsonData.put("x", player1.getX());
		jsonData.put("y", player1.getY());
		jsonData.put("jump", player1.getJump());
		network.setData(jsonData);
		network.enviaDados();
	}
	
	public void onlineControl(){
		
	}


}
