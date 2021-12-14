package de.mathisneunzig.advancedIT.aufgaben;

import java.util.concurrent.Semaphore;

import de.mathisneunzig.advancedIT.thread.Aufgabe11Thread;
import de.mathisneunzig.advancedIT.util.Philosoph;

public class Aufgabe11 {
	
	public static void start() throws InterruptedException {

		Semaphore sk = new Semaphore(1, true);
		Semaphore kf = new Semaphore(1, true);
		Semaphore fp = new Semaphore(1, true);
		Semaphore pa = new Semaphore(1, true);
		Semaphore as = new Semaphore(1, true);
		
		Aufgabe11Thread s = new Aufgabe11Thread(1, new Philosoph('S', "Sokrates"), as, sk);
		Aufgabe11Thread k = new Aufgabe11Thread(2, new Philosoph('K', "Kant"), sk, kf);
		Aufgabe11Thread f = new Aufgabe11Thread(3, new Philosoph('F', "Freud"), kf, fp);
		Aufgabe11Thread p = new Aufgabe11Thread(4, new Philosoph('P', "Platon"), fp, pa);
		Aufgabe11Thread a = new Aufgabe11Thread(5, new Philosoph('A', "Aristoteles"), pa, as);
		
		s.start();
		k.start();
		f.start();
		p.start();
		a.start();
		
	}
	
}
