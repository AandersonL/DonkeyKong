package com.java.supermario.constants;

public interface Constants {
	//Configurações da tela de menu
	
	int MENU_BOX_X = 150;
	int MENU_BOX_Y = 50;
	
	int WIDTH_TELA = 1000;
	int HEIGTH_TELA = 700;
	double GRAVITY = .98;
	//Solo
	int[] SOLO_X = { 0 ,60,120,180,220,280,340,400,460,520,580,640,700,760,820,880,920,980};
	int[] SOLO_Y = { 640,640,640,640,640,640,640,640,640,640,640,640,640,640,640,640,640,640 };
	//Nome do jogo
	
	int[] NOME_JOGO_X = {170,190,210,190,210,190,170,170,170,170,190,210,/*Aqui acaba o S*/
						240,250,260,270,255,/*Aqui acaba a letra U*/
						300,320,322,/*Aqui acaba a letra P*/
						350,350,350,350,/*Aqui acaba a letra E*/
						410,420,450,434,434,/*Aqui acaba a letra R, fim da primeira linha*/
						170,170,220,270};
	
	int[] NOME_JOGO_Y = {150,150,150,130,130,120,120,110,100,90,90,90,/*Aqui acaba o S*/
						90,170,170,90,160,/*Aqui acaba a letra U*/
						90,90,90,/*Aqui acaba a letra P*/
						90,90,130,170,/*Aqui acaba a letra E*/
						90,90,100,110,140,/*Aqui acaba a letra R, fim da primeira linha*/
						270,270,270,270};
	
	int[] WIDTH_NOME_JOGO = {20,20,20,20,20,20,20,20,20,20,20,20,/*Aqui acaba o S*/
						20,20,20,20,20,/*Aqui acaba a letra U*/
						20,20,20,/*Aqui acaba a letra P*/
						20,50,50,50,/*Aqui acaba a letra E*/
						20,50,20,20,35,/*Aqui acaba a letra R, fim da primeira linha*/
						25,120,25,25};
	
	int[] HEIGTH_NOME_JOGO = {40,40,40,40,40,40,20,20,20,20,20,20,/*Aqui acaba o S*/
						100,20,20,100,20,/*Aqui acaba a letra U*/
						100,20,50,/*Aqui acaba a letra P*/
						100,20,20,20,/*Aqui acaba a letra E*/
						100,30,30,30,50,/*Aqui acaba a letra R, fim da primeira linha*/
						160,30,160,160};
}
