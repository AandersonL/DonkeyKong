package com.java.supermario.environment;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;

import jdk.nashorn.internal.parser.JSONParser;

public class Network implements Runnable{
	private JSONParser jsonData;
	private ServerSocket s;
	private Socket conecta;
	private int num;
	private int contThread;
	private Thread[] th;
	private Scanner recebe;
	private boolean conectado;
	private boolean end;
	private int contador;
	private String data;
	private JSONObject dataFinal;
	private String response;
	public Network(){
		end = false;
		response = "nada";
		num = 0;
		th = new Thread[2];
		conectado = false;
		contador = 0;
		data = "";
	}
	//Servidor
	public void escuta(){
		conecta = new Socket();
		while(!conectado){
			try{
				s = new ServerSocket(4444);
				System.out.println("Servidor Online");
				conecta = s.accept();
				th[0] = new Thread(this);
				th[0].start();
				th[1] = new Thread(this);
				th[1].start();
				conectado = true;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	//Fim servidor

	//Metodos hibridos, tanto para o cliente quanto para o servidor

	public void recebeDados(){
		try {
			recebe = new Scanner(conecta.getInputStream());		
			response = recebe.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void enviaDados(){
		PrintStream print;
		try {
			print = new PrintStream(conecta.getOutputStream());
			print.println(this.data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setData(JSONObject data){
		this.data = String.valueOf(data);
	}
	
	public String retornaDados(){
		return this.response;
	}

	
	@Override
	public void run() {
		int acao = contador;
		contador++;
		while(!end){
			if(acao == 1){
				recebeDados();
			}
				
			else{
				enviaDados();
			}
				
		}	
	}

	//Fim metodo hibrido

	//Cliente

	public void conecta(String host, int port){
		System.out.println("conectando..");
		while(!conectado){
			try{		
				conecta = new Socket(host,port);
				th[0] = new Thread(this);
				th[0].start();
				th[1] = new Thread(this);
				th[1].start();
				conectado = true;
				System.out.println("Conectado..");
			}catch (Exception e) {

			}
		}
	}
}
