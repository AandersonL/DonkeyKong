package com.java.supermario.environment;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.java.supermario.constants.Constants;

public class DefaultBackground extends JPanel implements Constants{
	public DefaultBackground(){
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH_TELA, HEIGTH_TELA);
		for(int i = 0 ; i < SOLO_X.length;i++){
			g.setColor(new Color(222,66,28));
			g.fillRect(SOLO_X[i], SOLO_Y[i], 200, 200);
		}
		
	}
}
