package com.java.supermario.environment;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.java.supermario.constants.Constants;
import com.java.supermario.main.Central;

public class Player extends JFrame implements Constants{
	private URL url;
	private Image sprite;
	private String path; //Caminho da imagem
	private URL pathScore;
	private Image imgScore;
	private boolean left, down, right, jump, up;
	private boolean isEscada,isLeft, isRigth,sob, lose, end, scoreImg;
	private int heigth, width;
	private int x, y, distanciaEscada, tempY;
	private int contJump, contSubida;
	private int contWal, contSprite;
	private int score, contScore;
	private Rectangle player, escada;

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
		lose = false;
		sob = false;
		end = false;
		player = new Rectangle();
		escada = new Rectangle();
		distanciaEscada = 0;
		score = 0;
		contScore = 0;
		scoreImg = false;
		x = 25;
		y = 630;
		contSubida = 0;
		tempY = y;
		width = 45;
		heigth = 45;
		contJump = 0;
		contWal = 1;
		contSprite = 0;
		setSprites();	
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		url = getClass().getResource(path);
		pathScore = getClass().getResource("sprites/100pts.png");
		try {
			sprite = ImageIO.read(url);
			imgScore = ImageIO.read(pathScore);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(java.lang.IllegalArgumentException e){

		}
		//		g.setColor(Color.white);
		//		g.drawString("Diferença - " + (player.y - escada.y), 200, 200);
		if(Central.state == Central.State.START){
			Font fonte = new Font("arial", Font.BOLD, 25);
			g.setColor(Color.WHITE);
			g.drawString("Score - " + score, 800, 50);
			
		}
		g.drawImage(sprite,x,y,width,heigth, this);
		if(scoreImg){
			contScore++;
			if(contScore > 5){
				scoreImg = false;
				contScore = 0;
			}
			
			if(contScore == 1)
				score += 100;
			g.drawImage(imgScore, x - 30, y + 5,30,25, this);
			


		}
		g.setColor(Color.white);
		//	g.drawRect(x,y,width,heigth);
	}

	public void setSprites(){
		if(!lose){
			if(!player.intersects(escada)){
				isEscada = false;
			}
			if(isLeft && !left){
				path="sprites/MarioStopLeft.png";
			}

			if(isRigth && !right){
				path="sprites/MarioStopRigth.png";

			}
			if(isEscada && sob && distanciaEscada < 48 && distanciaEscada > -53){
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

			if(up && isEscada){

				if(contWal != 0)
					path = "sprites/marioEscada" + contWal + ".png";
				contWal++;
				contSubida++;

				if(contWal > 2 && contSubida < 16)
					contWal = 1;
				else if((player.y - escada.y) <= -40){
					contSubida = 0;
					contWal = 0;
					isRigth = true;
					isEscada = false;
					sob = false;
				}
			}	

			if(down && isEscada){
				path = "sprites/marioEscada" + contWal + ".png";
				contWal++;
				if(contWal > 2)
					contWal = 1;
				else if((player.y - escada.y) >= 50){
					contWal = 1;
					isRigth = true;
					isEscada = false;
					sob = false;
					contSubida = 0;
				}
			}
		}else{
			contSprite++;
			if(contSprite % 4 == 0){
				path = "sprites/marioDeath" + contWal + ".png";
				contWal++;
				if(contWal > 5){
					end = true;
				}
			}
		}
	}

	public void move(){	
		if(!lose){
			if(left && !sob){
				x -= 10;	
				player.x -= 10;
			}

			if(right && !sob){
				x += 10;
				player.x += 10;
			}

			if(up && isEscada){
				y -= 5;
				sob = true;
			}

			if(down && isEscada){
				y += 5;
				sob = true;
			}


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
						this.y = this.tempY;
						width = 45;
						heigth = 45;
					}
				}else{
					this.y -= (int) 20 * .5;
					this.contJump += (int) 20 * .5;
				}
			}
		}
	}

	public void score(){
		scoreImg = true;
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
		this.tempY = y;
	}

	public void setLose(boolean lose){
		this.lose = lose;
	}
	public void setEscada(boolean isEscada, Rectangle player, Rectangle escada){
		this.isEscada = isEscada;
		this.player = player;
		this.escada = escada;
	}

	public void setAllDataOnline(int x, boolean rigth, boolean left,boolean jump){
		this.x = x;
		this.right = rigth;
		this.left = left;
		this.jump = jump;
	}

	public boolean getEscada(){
		return this.isEscada;
	}

	public boolean getJump(){
		return this.jump;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public boolean getRigth(){
		return this.right;
	}
	public boolean getLeft(){
		return this.left;
	}
	public boolean getLife(){
		return this.end;
	}

	@Override
	public Rectangle bounds() {
		// TODO Auto-generated method stub
		return (new Rectangle(x,y, width, 50));
	}
}
