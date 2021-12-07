package de.mathisneunzig.advancedIT.aufgaben;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.mathisneunzig.advancedIT.thread.Aufgabe9Thread;

public class Aufgabe9 {
	
	private static int size = 262144000*2*2;
	
	public static void start() throws InterruptedException {
		
		/*
		 * Aufgabe 9 (Bearbeitungszeit: max. 90 min)
			(a) Schreiben Sie ein Java-Programm, das ein Array der Gr¨oße 2 097 152 (= 221) mit Integer-Werten > 0
			fu¨llt. Bilden Sie dann die Gesamtsumme und geben sie diese aus.
			Messen Sie die Zeit in Millisekunden, die das Programm nur fu¨r die Summenbildung ben¨otigt hat.
			(b) Wiederholen Sie das Vorgehen mit 2, 4, 8, 16, 32, 64 und 128 Worker-Threads, die jeweils die Summe
			u¨ber einen eigenen Teil des Arrays bilden und an den Haupt-Thread zuru¨ckgeben und messen Sie ebenfalls
			jeweils die fu¨r die Summenbildung ben¨otigte Zeit.
			Hinweis: U¨bergeben Sie eine fortlaufende ID an die Worker, so dass jeder Worker berechnen kann, welchen
			Ausschnitt des Arrays er bearbeiten muss.
			(c) Diskutieren Sie die Ergebnisse!
		 */

		int[] liste = init();
		System.out.println("Fertig!");
		System.out.println("=========================================");
		calculate(liste, 1);
		System.out.println("=========================================");
		calculate(liste, 2);
		System.out.println("=========================================");
		calculate(liste, 4);
		System.out.println("=========================================");
		calculate(liste, 8);
		System.out.println("=========================================");
		calculate(liste, 16);
		System.out.println("=========================================");
		calculate(liste, 32);
		System.out.println("=========================================");
		calculate(liste, 64);
		System.out.println("=========================================");
		calculate(liste, 128);
		System.out.println("=========================================");
		
	}
	
	public static void calculate(int[] liste, int anzahlWorker) throws InterruptedException {
		
		System.out.println("Berechnung mit "+anzahlWorker+" Thread(s):");
		System.out.print("Vorbereitung...");
		System.out.println("abgeschlossen!");
		
		long start = System.currentTimeMillis();
		System.out.println("Startzeit: "+start);
		
		List<Aufgabe9Thread> l = new ArrayList<>();
		
		for(int i = 0; i<anzahlWorker; i++) {
			int step = size/anzahlWorker;
			Aufgabe9Thread t = new Aufgabe9Thread(i*step, (i*step)+step-1, liste);
			l.add(t);
			t.start();
		}
		
		for(int i = 0; i<l.size(); i++) {
			l.get(i).join();
		}
		
		long r = 0;
		
		for(int i = 0; i<l.size(); i++) {
			r += l.get(i).getResult();
		}
		
		System.out.println("Ergebnis: "+r);
		
		long end = System.currentTimeMillis();
		System.out.println("Endzeit: "+end);
		System.out.println("Dauer: "+(end-start)+"ms");
		
	}
	
	public static int[] init() {
		Random r = new Random();
		int[] liste = new int[size];
		for(int i = 0; i<liste.length; i++) {
			liste[i] = r.nextInt(200);
		}
		return liste;
	}

}
