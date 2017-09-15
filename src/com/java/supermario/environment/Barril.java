package com.java.supermario.environment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.java.supermario.constants.Constants;

public class Barril extends JFrame implements Constants{
	private Image barril;
	private URL barrilPath;
	private String path;
	private Thread th;
	private int contBarril;
	private int num, contFall;
	private int x,y;
	private boolean isFinal, fall, stop;
	private int CHANGE = 2;
	public Barril(){
		path = "sprites/barril1.png";
		contBarril = 1;
		num = 0;
		x = 300;
		y = 100;
		fall = false;
		contFall = 0;
	}


	@Override
	public void paint(Graphics g) {
		barrilPath = getClass().getResource(path);
		g.setColor(Color.white);
		try {
			barril = ImageIO.read(barrilPath);
			g.drawImage(barril, x, y,30,30, this);
		//	g.setColor(Color.WHITE);
			//g.drawRect(x + 5, y - 45,1, 40);
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.paint(g);
	}

	public boolean getIsFinal(){
		return isFinal;
	}

	public void moveBarril() {
		num++;
		//System.out.println("Contador queda " + contFall);
		if(num % CHANGE == 0){
			path = "sprites/barril" + contBarril + ".png";
			if(!fall){
				contBarril++;
				x += 15;
				if(contBarril > 4)
					contBarril = 1;
			}else if(fall){
				contBarril--;
				x -= 15;
				if(contBarril < 1)
					contBarril = 4;
			}
		}
	}

	public void setY(int y){
		this.y = y;
	}

	public void setYFall(int y){
		this.y = y;
		contFall++;
		switch (contFall) {
		case 10:
			fall = true;
			break;
		case 19:
			fall = false;
			break;
		case 27:
			fall = true;
			break;
		case 37:
			fall = false;
			break;
		case 47:
			fall = true;
			break;
			//		default:
			//			break;
		}
	}



	@Override
	public Rectangle bounds() {
		return (new Rectangle(x,y, 30, 30));
	}
	
	public Rectangle scoreBounds(){
		return (new Rectangle(x + 5, y - 16,1, 15));
	}
}
