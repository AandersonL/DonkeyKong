package com.java.supermario.utils;


import java.awt.Rectangle;

import javax.swing.JOptionPane;

import com.java.supermario.main.*;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.java.supermario.constants.*;
import com.java.supermario.environment.Boss;

public class Collisions implements Constants {
	private int posicaoY, posicaoAtual, posicaoBarril;
	private boolean isEscada;
	public Collisions(){
		posicaoY = 0;
		posicaoAtual = 0;
		isEscada = false;
	}

	public void checkCollision(){
		Rectangle player = Central.player1.bounds();
		Rectangle martelo = Central.background.marteloBounds();
		posicaoAtual = player.y;
		Rectangle ground;
		Rectangle escada;
		Rectangle barril;
		Rectangle score;
		int cont;
		int contBarril[];
		cont = 0;
		contBarril = new int[Boss.listaBarril.size()];

		for (int i = 0; i < COORDENADAS.length; i++) {	
			ground = new Rectangle(COORDENADAS[i][0], COORDENADAS[i][1], 52, 25);
			if(player.intersects(ground) && !Central.player1.getJump() && !Central.player1.getEscada()){
				posicaoY = ground.y - (44);
				Central.player1.setPosition(posicaoY);	
			}else{
				cont++;
			}
			for (int j = 0; j < Boss.listaBarril.size(); j++) {
				barril = Boss.listaBarril.get(j).bounds();
				barril.height += 5;
				posicaoBarril = barril.y;
				if(ground.intersects(barril)){
					posicaoY = ground.y - 30;
					Boss.listaBarril.get(j).setY(posicaoY);	
				}else
					contBarril[j]++;

				if(contBarril[j] == 106){
					posicaoBarril += 10;
					Boss.listaBarril.get(j).setYFall(posicaoBarril);
				}
			}
		}


		for (int i = 0; i < COORDENADAS_ESCADA_NORMAL.length; i++) {
			escada = new Rectangle(COORDENADAS_ESCADA_NORMAL[i][0], COORDENADAS_ESCADA_NORMAL[i][1] - 20, 35, 100);	
			if(player.intersects(escada)){
				Central.player1.setEscada(true, player, escada);
				cont++;
			}

		}
		if(cont == 106 && !Central.player1.getJump() && !Central.player1.getEscada()){
			posicaoAtual += 15;
			Central.player1.setPosition(posicaoAtual);
		}


		/* ABAIXO, COLISÕES COM OS BARRIS! */
		for (int i = 0; i < Boss.listaBarril.size(); i++) {
			barril = Boss.listaBarril.get(i).bounds();
			barril.x += 2;
			barril.y += 2;
			barril.width -= 5;
			barril.height -= 5;
			if(player.intersects(barril) && !Central.player1.getJump()){
				Central.player1.setLose(true);
			}
		}
		
		/* Pontuação */
		for(int i = 0; i < Boss.listaBarril.size();i++){
			score = Boss.listaBarril.get(i).scoreBounds();
			if(player.intersects(score) && Central.player1.getJump()){
				Central.player1.score();
				break;
			}
		}
		
		/* Colisão com o martelo(final do game :v)*/
		if(player.intersects(martelo)){
			System.out.println("Ae krl!");
			Central.background.isEnd = true;
		}

	}

}
