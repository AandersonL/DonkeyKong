package com.java.supermario.environment;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.java.supermario.constants.Constants;

public class Boss extends JFrame implements Constants, Runnable {
	private String path;
	private String princessPath;
	private String helpPath;
	private URL imagePath;
	private URL barrilUpPath;
	private Image sprite;
	private Image barrilUp;
	private URL princess;
	private Image prince;
	private URL help;
	private Image helpImg;
	private int contSprite, contBarril, contPricess;
	private int numTroca, num;
	private int heigth, width;
	private int pts;
	private int div;
	private boolean action;
	private Graphics gf;
	public static ArrayList<Barril> listaBarril;
	public Boss(){
		contSprite = 1;
		contPricess = 1;
		setSprite();
		numTroca = 0;
		contBarril = 1;
		action = false;
		pts = 0;
		div = 5;
		heigth = 99;
		width = 130;
		Thread th1 = new Thread(this);
		th1.start();
		listaBarril = new ArrayList<Barril>();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		gf = g;
		imagePath = getClass().getResource(path);
		barrilUpPath = getClass().getResource("sprites/barrilUp.png");
		princess = getClass().getResource(princessPath);
		help = getClass().getResource(helpPath);
		try {
			sprite = ImageIO.read(imagePath);
			barrilUp = ImageIO.read(barrilUpPath);
			prince = ImageIO.read(princess);
			helpImg = ImageIO.read(help);
		} catch (IOException e) {
			e.printStackTrace();
		} catch(java.lang.IllegalArgumentException e){

		}
		for (int i = 0; i < COORDENADAS_BARRIL_UP.length; i++) {
			g.drawImage(barrilUp, COORDENADAS_BARRIL_UP[i][0] + 100, COORDENADAS_BARRIL_UP[i][1],35,35, this);
		}
		for (int i = 0; i < listaBarril.size(); i++) {
			listaBarril.get(i).paint(g);
			listaBarril.get(i).moveBarril();
			
		}
		
		g.drawImage(sprite, 200, 29,width,heigth, this);
		g.drawImage(prince, 10, 80,40,50, this);
		g.drawImage(helpImg, 65, 70,30,20, this);
	}

	public void setSprite(){
		numTroca++;
		if(numTroca % 4 == 0){
			width = 130;
			path = "sprites/kong" + contSprite + ".png";
			contSprite++;
			if(contSprite > 2)
				contSprite = 1;
		}
	}

	public void lancaBarril(){
		action = true;
		numTroca++;
		if(numTroca % div == 0){
			if(contBarril > 3 && contBarril < 6){
				width = 145;
			}
			path = "sprites/kongBarril" +contBarril + ".png";
			contBarril++;
			if(contBarril == 4){
				listaBarril.add(new Barril());
			}
			if(contBarril > 6){
				contBarril = 1;
				action = false;
			}

		}

	}

	public boolean getAction(){
		return this.action;
	}

	@Override
	public void run() {
		while(true){
			num++;
			if(num % 4 == 0){
				princessPath = "sprites/princess" + contPricess + ".png";
				helpPath = "sprites/help" + contPricess + ".png";
				contPricess++;
				if(contPricess > 2)
					contPricess = 1;
			}
			try {
				Thread.sleep(90);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
