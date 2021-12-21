package de.mathisneunzig.advancedIT.aufgaben;

import java.util.concurrent.Semaphore;

import de.mathisneunzig.advancedIT.thread.Aufgabe11cThread;
import de.mathisneunzig.advancedIT.util.Philosoph;

public class Aufgabe11c {
	
	public static Semaphore[] p = new Semaphore[5];
	public static Semaphore mutex = new Semaphore(1, true);
	public static int[] zustand = new int[5];
	public static Aufgabe11cThread[] a = new Aufgabe11cThread[5];
	
	public static final int DENKEN = 0;
	public static final int HUNGER = 1;
	public static final int ESSEN = 2;
	
	public static void start() throws InterruptedException {
		
		a[0] = new Aufgabe11cThread(0, new Philosoph('S', "Sokrates"));
		a[1] = new Aufgabe11cThread(1, new Philosoph('K', "Kant"));
		a[2] = new Aufgabe11cThread(2, new Philosoph('F', "Freud"));
		a[3] = new Aufgabe11cThread(3, new Philosoph('P', "Platon"));
		a[4] = new Aufgabe11cThread(4, new Philosoph('A', "Aristoteles"));
		
		for(@SuppressWarnings("unused") int i : zustand) {
			i = DENKEN;
		}
		
		for(int i = 0; i<5; i++) {
			p[i] = new Semaphore(0, true);
		}
		
		for(Aufgabe11cThread t : a) {
			t.start();
		}
		
		for(Aufgabe11cThread t : a) {
			t.join();
		}
		
	}
	
	public static String getNameForId(int id) {
		for(Aufgabe11cThread t : a) {
			Philosoph p = t.getP();
			if(t.getId() == id) {
				return p.getName();
			}
		}
		return null;
	}
	
}
