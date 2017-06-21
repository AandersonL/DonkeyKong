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

public class Player extends JFrame implements Constants{
	private URL url;
	private Image sprite;
	private String path; //Caminho da imagem
	private boolean left, down, right, jump, up;
	private boolean isEscada,isLeft, isRigth,sob;
	private int heigth, width;
	private int x, y;
	private int contJump, contSubida;;
	private int contWal;
	
	public Player(){
		init();
	}

	public void init(){
		jump = false; 
		left = false;
		down = false;
		right = false;
		isEscada = false;
		isLeft = false;
		isRigth = true;
		sob = false;
		x = 25;
		y = 630;
		contSubida = 0;
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
			g.setColor(Color.WHITE);
			g.drawString("Contador subida - " + contSubida, 200, 200);
//			g.drawRect(x, y, width, 50);
			
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
		if(isEscada && sob){
			path = "sprites/marioEscada1.png";
		}
		if(right && !sob){
			path="sprites/MarioWalkRigth" + contWal + ".png";
			contWal++;
			if(contWal > 2)
				contWal = 1;	
			isLeft = false;
			isRigth = true;
		}

		if(left && !sob){
			path="sprites/MarioWalkLeft" + contWal + ".png";
			contWal++;
			if(contWal > 2)
				contWal = 1;

			isLeft = true;
			isRigth = false;
		}
		
		if(up && isEscada && sob){
			path = "sprites/marioEscada" + contWal + ".png";
			contWal++;
			
			if(contWal > 2 && contSubida < 8)
				contWal = 1;
			
			else if(contWal == 5){
				isEscada = false;
				contWal = 1;
				contSubida = 0;
				sob = false;
			}
			contSubida++;
				
		}	
				

	}

	public void move(){	
		if(left && contSubida == 0)
			x -= 10;

		if(right && contSubida == 0)
			x += 10;
		
		if(up && isEscada){
			y -= 5;
			sob = true;
			
		}
			
		
		if(down && isEscada)
			y += 7;
		
		if(x > 945)
			x = 945;
		
		if (x < 5)
			x = 5;
		
		if(jump){
			
			if(right || isRigth)
				path = "sprites/marioJumpRigth.png";
			else if(left || isLeft)
				path = "sprites/marioJump.png";
			
			if(contJump > 40){
				this.y += (int) 20 * .5;
				this.contJump += (int) 20 * .5;
				if(contJump > 100){

					this.contJump = 0;
					this.jump = false;
					this.y = 630;
					width = 45;
					heigth = 45;
				}
			}else{
				this.y -= (int) 20 * .5;
				this.contJump += (int) 20 * .5;
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
	
	public void setUp(boolean up){
		this.up = up;
	}

	public void setJump(boolean jump){
		this.jump = jump;
	}
	
	public void setPosition(int y){
		this.y = y;
	}
	
	public void setEscada(boolean isEscada){
		this.isEscada = isEscada;
	}
	
	public boolean getEscada(){
		return this.isEscada;
	}
	
	public boolean getJump(){
		return this.jump;
	}
	
	@Override
	public Rectangle bounds() {
		// TODO Auto-generated method stub
		return (new Rectangle(x,y, width, 50));
	}
}
