package de.mathisneunzig.advancedIT.aufgaben;

import de.mathisneunzig.advancedIT.thread.Aufgabe11Thread;
import de.mathisneunzig.advancedIT.util.Gabel;
import de.mathisneunzig.advancedIT.util.Philosoph;

public class Aufgabe11 {
	
	/*
	 * Aufgabe 11 (Bearbeitungszeit: max. 90 min)
	  	Fu¨nf Philosophen sitzen gemeinsam an einem runden Tisch, an dem sie unabh¨angig voneinander von Zeit
		zu Zeit Spaghetti essen. Jeder Philosoph hat rechts neben seinem Teller nur eine Gabel, ben¨otigt aber zum
		Essen zwei Gabeln, also auch die seines linken Nachbarn. Aus diesem Grund k¨onnen nicht alle Philosophen
		gleichzeitig essen, sondern sie mu¨ssen sich bezu¨glich ihrer kritischen Abschnitte Essen synchronisieren
		
		a) Formulieren Sie die Synchronisationsbedingungen mittels eines Synchronisationsgraphen.
		b) Geben Sie Java-L¨osungen unter Verwendung des Semaphorkonzepts an, wobei Sie die Philosophen
		jeweils als Threads implementieren sollten.
	 */
	
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
