package de.mathisneunzig.advancedIT.aufgaben;

import de.mathisneunzig.advancedIT.monitor.Aufgabe12Monitor;
import de.mathisneunzig.advancedIT.thread.Aufgabe12Thread;

public class Aufgabe12 {
	
	/*
	 * Lösen Sie das 5-Philosophenproblem mit dem Java-Monitorkonzept.
	 */
	
	public static void start() throws InterruptedException {
		
		int max = 5;
		Aufgabe12Monitor table = new Aufgabe12Monitor(max);
		Aufgabe12Thread[] philos = new Aufgabe12Thread[max];
		for(int i = 0; i < max; i++) {
			philos[i] = new Aufgabe12Thread(i, table);
			philos[i].start();
		}
		for(int i = 0; i < max; i++) {
			philos[i].join();
		}
		
		System.out.println("Alle satt!");
		
	}
	
}
