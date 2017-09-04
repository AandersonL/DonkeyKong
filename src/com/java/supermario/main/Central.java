package com.java.supermario.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;
import org.json.*;
import javax.swing.Timer;
import javax.swing.JFrame;
import com.java.supermario.constants.Constants;
import com.java.supermario.environment.Boss;
import com.java.supermario.environment.DefaultBackground;
import com.java.supermario.environment.LocalManager;
import com.java.supermario.environment.MenuScreen;
import com.java.supermario.environment.Network;
import com.java.supermario.environment.OnlineManager;
import com.java.supermario.environment.Player;
import com.java.supermario.environment.Sound;
import com.java.supermario.environment.Stage0;
import com.java.supermario.utils.Collisions;


public class Central extends JFrame implements Constants, ActionListener, KeyListener{
	private static boolean isStart;
	private boolean isMario;
//	private boolean isServidor;
	public static boolean isSingle;
	private MenuScreen settings;
	public static Player player1;
	public static Boss kong;
	public static DefaultBackground background;
	public static OnlineManager manager;
	public static LocalManager localManager;
	public static Stage0 stageZero;
	private Timer timer;
	private Collisions collisions;
	private Image img;
	private Graphics gfx;
//	private Network network;
//	private JSONObject dataFinal;
	public static enum State{
		MENU,
		START,
		ONLINE,
		MULTIPLAYER,
		CLOSE,
		SCORE
	};
	public static State state;
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
		isMario = false;
		isStart = false;
		isSingle = true;
		player1 = new Player();
		kong = new Boss();
		background = new DefaultBackground();
		stageZero = new Stage0();
		collisions = new Collisions();
//		network = new Network();
		manager = new OnlineManager();
		localManager = new LocalManager();
		settings = new MenuScreen();
		this.addMouseListener(settings);
		timer = new Timer(90, this);
		timer.start();
		state = State.MENU;	
	}

	@Override
	public void paint(Graphics g) {
		try{
			super.paint(gfx);
			//		gfx.drawString("Dados " + network.retornaDados(), 200, 300);

			background.paint(gfx);
			stageZero.paint(gfx);
			kong.paint(gfx);
			player1.paint(gfx);	
			if(state == State.MENU){
				settings.paint(gfx);
			}
			if(state == State.MULTIPLAYER){
				localManager.paint(gfx);
			}
				
			g.drawImage(img, 0, 0, this);
		}catch (Exception e) {
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		player1.setSprites();
		
		if(!kong.getAction())
			kong.setSprite();
		else
			kong.lancaBarril();
		
		if(state == State.START){
			player1.move();
			collisions.checkCollision();
			endGame();
//			onlineData();
//			onlineControl();
			
		}
			
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		//Mario
		if(state == State.START){
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

			if(e.getKeyCode() == e.VK_F && !isSingle)
				kong.lancaBarril();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(state == State.START){
			if(e.getKeyCode() == e.VK_DOWN)
				player1.setDown(false);

			if(e.getKeyCode() == e.VK_LEFT)
				player1.setLeft(false);

			if(e.getKeyCode() == e.VK_RIGHT)
				player1.setRight(false);

			if(e.getKeyCode() == e.VK_UP)
				player1.setUp(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

//	public void onlineData(){
//		JSONObject jsonData = new JSONObject();
//		//Player
//		jsonData.put("x", player1.getX());
//		jsonData.put("y", player1.getY());
//		jsonData.put("jump", player1.getJump());
//		jsonData.put("rightPlayer", player1.getRigth());
//		jsonData.put("leftPlayer", player1.getLeft());
//		jsonData.put("jump", player1.getJump());
//		network.setData(jsonData);
//
//	}

//	public void onlineControl(){
//		try{
//			JSONObject finalData = new JSONObject(network.retornaDados());
//			int xPlayer = finalData.getInt("x");
//			boolean rigthPlayer = finalData.getBoolean("rightPlayer");
//			boolean leftPlayer = finalData.getBoolean("leftPlayer");
//			boolean jump = finalData.getBoolean("jump");
//			if(isServidor){
//				player1.setAllDataOnline(xPlayer, rigthPlayer, leftPlayer,jump);
//			}
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
	public void endGame(){
		if(player1.getLife()){
			state = State.MENU;	
			player1.init();
			kong.reset();
		}
	}

}
