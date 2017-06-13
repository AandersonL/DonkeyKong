package com.java.supermario.environment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.java.supermario.constants.Constants;

public class Player extends JFrame implements Constants{
	private URL url;
	private Image sprite;
	private String path; //Caminho da imagem
	private boolean left, down, right, jump;
	private boolean isStop, firstMove,isLeft, isRigth;
	private int heigth, width;
	private int x, y;
	private int contJump;
	private int contWal;

	public Player(){
		init();
	}

	public void init(){
		jump = false; 
		left = false;
		down = false;
		right = false;
		isStop = true;
		firstMove = true;
		isLeft = true;
		isRigth = false;
		x = 800;
		y = 600;
		width = 45;
		heigth = 45;
		contJump = 0;
		contWal = 1;
		setSprites();	
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		url = getClass().getResource(path);
		try {
			sprite = ImageIO.read(url);
			g.drawImage(sprite,x,y,width,heigth, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setSprites(){
		if(isLeft && !left){
			path="sprites/MarioStopLeft.png";
		}

		if(isRigth && !right){
			path="sprites/MarioStopRigth.png";

		}

		if(right){
			path="sprites/MarioWalkRigth" + contWal + ".png";
			contWal++;
			if(contWal > 2)
				contWal = 1;	
			isLeft = false;
			isRigth = true;
		}

		if(left){
			path="sprites/MarioWalkLeft" + contWal + ".png";
			contWal++;
			if(contWal > 2)
				contWal = 1;

			isLeft = true;
			isRigth = false;
		}
				

	}

	public void move(){	
		if(left)
			x -= 15;

		if(right)
			x += 15;

		if(jump){
			path = "sprites/marioJump.png";	
			if(contJump > 120){
				this.y += (int) 40 * 1.5;
				this.contJump += (int) 40 * 1.5;
				if(contJump > 240){

					this.contJump = 0;
					this.jump = false;

					this.y = 600;
					width = 45;
					heigth = 45;
				}
			}else{
				this.y -= (int) 40 * 1.5;
				this.contJump += (int) 40 * 1.5;
			}
		}
	}


	public void setDown(boolean down){
		this.down = down;
	}

	public void setLeft(boolean left){
		this.left = left;

	}

	public void setRight(boolean right){
		this.right = right;
	}

	public void setJump(boolean jump){
		this.jump = jump;
	}
}
