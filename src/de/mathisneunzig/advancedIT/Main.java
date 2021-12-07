package de.mathisneunzig.advancedIT;

import de.mathisneunzig.advancedIT.aufgaben.*;

public class Main {
	
	// Die auszuführende Aufgabe auskommentieren!
	public static void main(String[] args) {
		
//		Aufgabe8.start();
		
//		try {
//			System.out.print("Start Aufgabe 9...");
//			Aufgabe9.start();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		try {
			for(int i = 0; i<=1; i++) {
				try {
					Aufgabe10.start();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
	}
	
}
