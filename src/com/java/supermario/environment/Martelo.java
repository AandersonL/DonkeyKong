package com.java.supermario.environment;

import com.java.supermario.constants.Constants;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Martelo extends JFrame implements Constants {
	private String marteloPath;
	private URL marteloPathUrl;
	private Image marteloImg;
	public static boolean isEnd, finalScene;
	private int cont, contImage, contFinal;
	private int x,y;

	public Martelo() {
		marteloPath = "sprites/martelo1.png";
		isEnd = false;
		finalScene = false;
		cont = 0;
		contImage = 1;
		contFinal = 0;
		x = 400;
		y = 30;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		marteloPathUrl = getClass().getResource(marteloPath);
		try {
			marteloImg = ImageIO.read(marteloPathUrl);
		} catch (IOException e) {
		}
		if(contFinal < 5)
			g.drawImage(marteloImg, x, y,50,50, this);
		g.setColor(Color.WHITE);
//		g.drawRect(x, y, 50, 50);
		if(isEnd)
			endAnimation();
	}

	public void endAnimation(){
		if(!finalScene){
			cont++;
			marteloPath = "sprites/martelo" + contImage + ".png";	
			contImage++;
			if(contImage > 4)
				contImage = 1;
			System.out.println("Sprite num -> " + contImage);
			if(cont % 2 == 0)
				x -= 30;
		}else{
			marteloPath = "sprites/martelo5.png";
			contFinal++;
		}

	}

	public Rectangle marteloBounds(){
		return (new Rectangle(x,y,50,50));
	}	
}
