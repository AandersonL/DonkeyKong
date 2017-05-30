package com.java.supermario.environment;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import com.java.supermario.constants.Constants;

public class MenuScreen extends JPanel implements Constants {
	private int width;
	private int heigth;

	public MenuScreen(){
		this.width = getWidth()/2;
		this.heigth = getHeight()/2;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//Fundo azul
		g.setColor(new Color(99,160,253));
		g.fillRect(0, 0, WIDTH_TELA, HEIGTH_TELA);

		//Caixa laranja
		g.setColor(new Color(222,66,28));
		g.fillRect(MENU_BOX_X, MENU_BOX_Y, 700, 400);	

		//Nome do jogo

		g.setColor(new Color(229, 155, 163));
		for (int i = 0; i < NOME_JOGO_X.length; i++) {
			g.fillRect(NOME_JOGO_X[i], NOME_JOGO_Y[i], WIDTH_NOME_JOGO[i], HEIGTH_NOME_JOGO[i]);
		}
		//Solo
		for (int i = 0; i < SOLO_X.length; i++) {
			g.setColor(new Color(222,66,28));
			g.fillRect(SOLO_X[i], SOLO_Y[i], 60, 150);

		}
	}
}
