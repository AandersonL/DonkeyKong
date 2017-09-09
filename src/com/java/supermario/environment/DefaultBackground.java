package com.java.supermario.environment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
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
		
	}
	

	

}
