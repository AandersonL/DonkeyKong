package com.java.supermario.utils;


import java.awt.Rectangle;

import javax.swing.JOptionPane;

import com.java.supermario.main.*;
import com.java.supermario.constants.*;

public class Collisions implements Constants {
	private int posicaoY;
	public Collisions(){
		posicaoY = 0;
	}

	public void checkCollision(){
		Rectangle player = Central.player1.bounds();
		Rectangle ground;
		Rectangle escada;
		for (int i = 0; i < COORDENADAS.length; i++) {	
			ground = new Rectangle(COORDENADAS[i][0], COORDENADAS[i][1], 52, 25);

			if(player.intersects(ground) && !Central.player1.getJump() && !Central.player1.getEscada()){
				posicaoY = ground.y - (44);
				Central.player1.setPosition(posicaoY);
			}
		}
		
		for (int i = 0; i < COORDENADAS_ESCADA_NORMAL.length; i++) {
			escada = new Rectangle(COORDENADAS_ESCADA_NORMAL[i][0], COORDENADAS_ESCADA_NORMAL[i][1] - 30, 35, 120);
			String saida = "Escada - X " + escada.x + " Escada Y - " + escada.y;
			saida+= "\nPlayer - X " + player.x;
			System.out.println(saida);
			if(player.intersects(escada))
				Central.player1.setEscada(true);
			else
				Central.player1.setEscada(false);
			
		}



	}

}
