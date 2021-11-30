package de.mathisneunzig.advancedIT.aufgaben;

import java.util.ArrayList;
import java.util.List;

import de.mathisneunzig.advancedIT.thread.Aufgabe8Thread;

public class Aufgabe8 {
	
	/*
	 * Aufgabe 8 (Bearbeitungszeit: max. 30 min)
		Bitte ¨andern Sie die Klasse MyThread1 von Folie 31 so, dass der main-Thread unmittelbar nach Beendigung
		aller Threads die Nachricht ”Alle fertig.” auf dem Bildschirm ausgibt. Achten Sie dabei darauf, dass auch
		weiterhin alle Threads nebenl¨aufig ablaufen!
	 */
	
	public static void start() {
		
		List<Thread> l = new ArrayList<>();
		for(int i = 1; i<10; i++) {
			Aufgabe8Thread advT = new Aufgabe8Thread(i);
			Thread t = new Thread(advT);
			l.add(t);
			t.start();
		}
		
		for(int i = 0; i<l.size(); i++) {
			try {
				l.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Fertig!");
		
	}
	
}
