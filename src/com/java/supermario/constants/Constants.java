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
	
	
	
	//Coodernadas da primeira fase
	
	int[][] COORDENADAS ={{4,674},{55,674},{106,674},{157,674},{208,674},{259,674},{310,674},{361,674},{412,674},{463,672},	//Aqui acaba o chao linear
					   	 {514,672},{565,669},{616,669},{667,665},{718,665},{769,661},{820,661},{871,659},{922,659},{973,657},{1024,657},
					   	 //Aqui começa o primeiro andar
					   	  {4,550},{55,550},{106,552},{157,552},{208,554},{259,554},{310,556},{361,556},{412,558},{463,558},{514,560}, {565,560},
					   	  {616,562},{667,562},{718,564},{769,564},	//Fim primeiro andar
						//Aqui começa o segundo andar
						  {106,450},{157,450},{208,448},{259,448},{310,446},{361,446},{412,444},{463,444},{514,442},{565,442},{616,440},{667,440},
						  {718,438},{769,438},{820,436},{871,436},{922,434},{973,434},
						//Aqui começa o terceiro andar
						  {4,340},{55,340},{106,342},{157,342},{208,344},{259,344},{310,346},{361,346},{412,348},{463,348},{514,350}, {565,350},
					   	  {616,352},{667,352},{718,354},{769,354},
					   	//Aqui começa o quarto andar
					   	  {106,250},{157,250},{208,248},{259,248},{310,246},{361,246},{412,244},{463,244},{514,242},{565,242},{616,240},{667,240},
						  {718,238},{769,238},{820,236},{871,236},{922,234},{973,234},
						  //Aqui começa o chao linear do teto
						  {4,128},{55,128},{106,128},{157,128},{208,128},{259,128},{310,128},{361,128},{412,128},{463,128},	//Aqui acaba o chao linear
					      {514,128},{565,128},{616,128},{667,132},{718,132},{769,136},{820,136},
					   	  };
	int[][] COORDENADAS_ESCADA_NORMAL = {{680,588},{170,474},{380,370},{250,270},{720,160}};
	
	
}
