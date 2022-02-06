package de.mathisneunzig.advancedIT.klausurvorbereitung.monitor;

public class Ampelschaltung {
	
	/**
	 * Zwei Einbahnstraﬂen kreuzen sich. Zwei Ampeln steuern die Zufahrt
	 * Ampelphasen:
	 * R R
	 * G R
	 * R R
	 * R G
	 */
	
	private int phase = 0;
	private boolean a1gruen = false;
	private boolean a2gruen = false;
	
	public synchronized void schalten() {
		if(phase == 0) {
			a1gruen = false;
			a2gruen = false;
			phase++;
		} else if(phase == 1) {
			a1gruen = true;
			a2gruen = false;
			phase++;
		} else if(phase == 2) {
			a1gruen = false;
			a2gruen = false;
			phase++;
		} else if(phase == 3) {
			a1gruen = false;
			a2gruen = true;
			phase = 0;
		}
		notifyAll();
	}
	
	public synchronized void a1() {
		try {
			while(!a1gruen) {
				wait();
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void a2() {
		try {
			while(!a2gruen) {
				wait();
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
