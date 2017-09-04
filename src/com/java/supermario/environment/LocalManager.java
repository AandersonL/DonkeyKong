package com.java.supermario.environment;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.java.supermario.constants.Constants;

public class LocalManager extends JFrame implements Constants {

	int vez;
	private URL kongPath, marioPath;
	private Image kongImg, marioImg;
	boolean p1Mario, p1Kong, p2Mario, p2Kong, ready;
	Rectangle marioBox = new Rectangle(WIDTH_TELA/2 - 230, 300, 180, 200);
	Rectangle kongBox = new Rectangle(WIDTH_TELA/2 + 70 , 300, 180, 200);
	Rectangle initBox = new Rectangle(450, 600, 130, 50);
	Rectangle reset = new Rectangle(WIDTH_TELA/2 - 230, 600, 130, 50);

	public LocalManager(){
		init();

	}

	public void init() {
		p1Kong = false;
		p1Mario = false;
		p2Kong = false;
		p2Mario = false;
		vez = 1;
		ready = false;
		kongPath = getClass().getResource("sprites/kongBox.png");
		marioPath = getClass().getResource("sprites/marioBox.png");
		try {
			kongImg = ImageIO.read(kongPath);
			marioImg = ImageIO.read(marioPath);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

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
		g2d.draw(marioBox);
		g2d.draw(kongBox);
		g2d.draw(reset);
		g.drawImage(kongImg, kongBox.x, kongBox.y, kongBox.width, kongBox.height, this);
		g.drawImage(marioImg, marioBox.x, marioBox.y, marioBox.width, marioBox.height, this);
		
		Font fonte1 = new Font("arial", Font.BOLD, 20);
		g.setFont(fonte1);
		g.drawString("Resetar", reset.x + 15, reset.y + 30);
		if(ready){
			g2d.draw(initBox);
			g.drawString("Iniciar", initBox.x + 30,initBox.y + 30);
		}
		g.drawString("Escolha seu personagem player " + vez, WIDTH_TELA/2 - 200, HEIGTH_TELA/2 - 150);
		
		if(p1Mario){
			g.drawString("Player 1", marioBox.x + 30, marioBox.y - 20);
		}else if(p1Kong){
			g.drawString("Player 1", kongBox.x + 30, kongBox.y - 20);
		}
		
		if(p2Mario){
			g.drawString("Player 2", marioBox.x + 30, marioBox.y - 20);
		}else if(p2Kong){
			g.drawString("Player 2", kongBox.x + 30, kongBox.y - 20);
		}
	}
	
	public String getP1(){
		if(p1Mario)
			return "mario";
		else if(p1Kong)
			return "kong";
		
		return "none";
	}
	
	public String getP2(){
		if(p2Mario)
			return "mario";
		else if(p2Kong)
			return "kong";
		
		return "none";
	}

}
