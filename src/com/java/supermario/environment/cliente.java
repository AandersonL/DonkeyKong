package com.java.supermario.environment;

public class cliente {
	public static void main(String[] args) {
		Network net = new Network();
		net.conecta("localhost", 4444);
	}
	
}
