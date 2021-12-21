package de.mathisneunzig.advancedIT.aufgaben;

import de.mathisneunzig.advancedIT.thread.Aufgabe11Thread;
import de.mathisneunzig.advancedIT.util.Gabel;
import de.mathisneunzig.advancedIT.util.Philosoph;

public class Aufgabe11 {
	
	public static void start() throws InterruptedException {

		Gabel sk = new Gabel(1, true);
		Gabel kf = new Gabel(1, true);
		Gabel fp = new Gabel(1, true);
		Gabel pa = new Gabel(1, true);
		Gabel as = new Gabel(1, true);
		
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
