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

public class Stage0 extends JFrame implements Constants {
	private Image blocoUnico;
	private URL blocoUnicoPath;
	private URL escadaPath;
	private Image escadaNormal;
	private String path;
	private int x, y,xBounds,yBounds;
	public Stage0(){
		path = "sprites/chao.png";
		x = 4;
		y = 674;
		xBounds = 0;
		yBounds = 0;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		blocoUnicoPath = getClass().getResource(path);
		escadaPath = getClass().getResource("sprites/escadaNormal.png");
		try {
			blocoUnico = ImageIO.read(blocoUnicoPath);
			escadaNormal = ImageIO.read(escadaPath);
			for (int i = 0; i < COORDENADAS_ESCADA_NORMAL.length; i++) {
				g.drawImage(escadaNormal,COORDENADAS_ESCADA_NORMAL[i][0],COORDENADAS_ESCADA_NORMAL[i][1],35,78,this);
				g.setColor(Color.red);
				g.drawRect(COORDENADAS_ESCADA_NORMAL[i][0], COORDENADAS_ESCADA_NORMAL[i][1] - 30, 35, 120);
			}
			for (int i = 0; i < COORDENADAS.length; i++) {
				g.drawImage(blocoUnico, COORDENADAS[i][0], COORDENADAS[i][1],52,25, this);
				xBounds += COORDENADAS[i][0];
				yBounds += COORDENADAS[i][1];
//				setBounds(COORDENADAS[i][0], COORDENADAS[i][1]);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
