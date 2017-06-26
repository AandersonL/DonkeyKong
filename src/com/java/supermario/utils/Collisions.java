package com.java.supermario.utils;


import java.awt.Rectangle;

import javax.swing.JOptionPane;

import com.java.supermario.main.*;
import com.java.supermario.constants.*;

public class Collisions implements Constants {
	private int posicaoY, posicaoAtual;
	private boolean isEscada;
	public Collisions(){
		posicaoY = 0;
		posicaoAtual = 0;
		isEscada = false;
	}

	public void checkCollision(){
		Rectangle player = Central.player1.bounds();
		posicaoAtual = player.y;
		Rectangle ground;
		Rectangle escada;
		int cont;
		cont = 0;
		for (int i = 0; i < COORDENADAS.length; i++) {	
			ground = new Rectangle(COORDENADAS[i][0], COORDENADAS[i][1], 52, 25);
			if(player.intersects(ground) && !Central.player1.getJump() && !Central.player1.getEscada()){
				posicaoY = ground.y - (44);
				Central.player1.setPosition(posicaoY);	
			}else{
				cont++;
			}
		}
		
		
		for (int i = 0; i < COORDENADAS_ESCADA_NORMAL.length; i++) {
			escada = new Rectangle(COORDENADAS_ESCADA_NORMAL[i][0], COORDENADAS_ESCADA_NORMAL[i][1] - 20, 35, 100);	
			if(player.intersects(escada)){
				System.out.println("ta na escada");	
				Central.player1.setEscada(true, player, escada);
				cont++;
			}
			
		}
		
		System.out.println("Tem " + COORDENADAS.length + " Blocos");
		System.out.println(cont);
		
		if(cont == 106 && !Central.player1.getJump() && !Central.player1.getEscada()){
			posicaoAtual += 15;
			Central.player1.setPosition(posicaoAtual);
		}



	}

}
