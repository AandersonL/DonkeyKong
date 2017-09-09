package com.java.supermario.environment;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import com.java.supermario.constants.Constants;
import com.java.supermario.main.Central;

public class MenuScreen extends JFrame implements Constants, MouseListener{

	private boolean singlePlayer, onlineG, multi, done;
	
	
	private Rectangle marioBox = Central.localManager.marioBox;
	private Rectangle kongBox = Central.localManager.kongBox;
	private Rectangle init = Central.localManager.initBox;
	private Rectangle reset = Central.localManager.reset;
	Rectangle player = new Rectangle(WIDTH_TELA/2 - 120, 250, 180, 50);
//	Rectangle onlineMode = new Rectangle(WIDTH_TELA/2 - 120, 350, 180, 50);
	Rectangle multiPlayer = new Rectangle(WIDTH_TELA/2 - 120, 450, 180, 50);



	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		//Fundo azul
		int alpha = 200; // 50% transparent
		Color myColour = new Color(0, 0, 0, alpha);
		g.setColor(myColour);
		g.fillRect(0, 0, WIDTH_TELA, HEIGTH_TELA);

		Font fonte = new Font("arial", Font.BOLD, 50);
		g.setFont(fonte);
		g.setColor(Color.WHITE);
		g.drawString("DONKEY KONG CLASSIC", WIDTH_TELA/2 - 350, HEIGTH_TELA/2 - 200);
		Font fonte2 = new Font("arial",Font.BOLD, 25);
		g.setFont(fonte2);
		g.drawString("Single Play", player.x + 10, player.y + 30);
		g2d.draw(player);
//		g.drawString("P1vsP2", player.x + 2, player.y + 130);
//		g2d.draw(onlineMode);
		g.drawString("P1vsP2", player.x + 40, player.y + 230);
		g2d.draw(multiPlayer);

	}

	public boolean isOnline(){
		return this.onlineG;
	}

	public boolean isSingle(){
		return this.singlePlayer;
	}

	public boolean isLocalMulti(){
		return this.multi;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX());

	}



	@Override
	public void mouseEntered(MouseEvent e) {


	}



	@Override
	public void mouseExited(MouseEvent e) {
		

	}



	@Override
	public void mousePressed(MouseEvent e) {
		int vez = Central.localManager.vez;
		done = false;
		int x = e.getX();
		int y = e.getY();
		if(Central.state == Central.State.MENU){
			if(player.contains(e.getX(), e.getY())){
				Central.state = Central.State.START;
//				if(Central.kong.savedPrinces()){
					Central.player1.init();
					Central.kong.reset();
					Central.martelo.init();
					Central.isSingle = true;
//				}
			}

//			if(onlineMode.contains(e.getX(), e.getY())){
//				Central.state = Central.State.ONLINE;
//			}

			if(multiPlayer.contains(e.getX(), e.getY())){
				Central.state = Central.state.MULTIPLAYER;
			}	
		}
		
		if(Central.state == Central.State.MULTIPLAYER ){
	
			if(!done && marioBox.contains(x, y) && vez == 1){
				Central.localManager.p1Mario = true;
				Central.localManager.vez++;
				vez++;
				done = true;
			}
			
			if(!done && marioBox.contains(x, y) && vez == 2 && !Central.localManager.p1Mario){
				Central.localManager.p2Mario = true;
				Central.localManager.ready = true;	
				done = true;
			}
			
			
			if(!done && kongBox.contains(x, y) && vez == 1){
				Central.localManager.p1Kong = true;
				Central.localManager.vez++;
				vez++;
				done = true;
			}
			
			
			if(!done && kongBox.contains(x, y) && vez == 2 && !Central.localManager.p2Kong){
				Central.localManager.p2Kong = true;
				Central.localManager.ready = true;
				done = true;
			}
			
			if(!done && init.contains(x,y) && vez >= 2){
				Central.state = Central.State.START;
				Central.isSingle = false;
			}
			System.out.println("Acabou? " + done);
			System.out.println("Vez - " + vez);
		}
	}


	@Override
	public void mouseReleased(MouseEvent e) {

	}
}
