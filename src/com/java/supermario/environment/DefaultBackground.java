package com.java.supermario.environment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.java.supermario.constants.Constants;

public class DefaultBackground extends JPanel implements Constants{
	private String marteloPath;
	private URL marteloPathUrl;
	private Image marteloImg;
	public static boolean isEnd;
	private int cont, contImage;
	private int x,y;
	public DefaultBackground(){
		marteloPath = "sprites/martelo1.png";
		isEnd = false;
		cont = 0;
		contImage = 1;
		x = 400;
		y = 30;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH_TELA, HEIGTH_TELA);
		marteloPathUrl = getClass().getResource(marteloPath);
		try {
			marteloImg = ImageIO.read(marteloPathUrl);
		} catch (IOException e) {
		}
		g.drawImage(marteloImg, x, y,50,50, this);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, 50, 50);
		if(isEnd)
			endAnimation();
	}
	
	public Rectangle marteloBounds(){
		return (new Rectangle(400,30,50,50));
	}
	
	public void endAnimation(){
		cont++;
		if(cont % 4 == 0){
			
			x -= 30;
			marteloPath = "sprites/martelo" + contImage + ".png";	
			contImage++;
			if(contImage > 2)
				contImage = 1;
			System.out.println("Contador imagem -> " + contImage);
		}
	}
}
