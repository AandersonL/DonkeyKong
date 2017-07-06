package com.java.supermario.environment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/*
 * 
 * 		USO: Instancia na sua clase de colisões, sempre que ocorrer uma colisão faça
 * 
 * 		song.song("<diretorio do som">);
 * 
 * 		Caso tenha algum bug do som não parar de tocar, eu resolvi isso usando um contador para o som:
 * 
 * 		if(sound == 0){
				song.song("src/com/java/pitfall/environment/utils/songs/jump.wav");
				sound++;
			}
			
		Então, quando ele termina o pula e zera as variaveis, eu volto a variavel 'sound' para 0, para que possa
		ser usada no proximo pulo(ou qualquer que seja a ação)
		
		obs: O formato que eu consegui usar o foi .wav . 
 * */
public class Sound {
	AudioStream BGM;
	
	//Efeitos sonoros
	public void song(String path){
		try
		{
			InputStream sound = new FileInputStream(path);
			BGM = new AudioStream(sound);
			AudioPlayer.player.start(BGM);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException error)
		{
			error.printStackTrace();
		}

	}
}

