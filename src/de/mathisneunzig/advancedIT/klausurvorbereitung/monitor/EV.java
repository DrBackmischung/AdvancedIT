package de.mathisneunzig.advancedIT.klausurvorbereitung.monitor;

public class EV {
	
	/**
	 * Generelles E/V-Problem
	 */
	
	private boolean e = true;
	private boolean v = false;
	
	public synchronized void enterE() {
		try {
			while(!e) {
				wait();
			}
			e = false;
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void exitE() {
		v = true;
		notifyAll();
	}
	
	public synchronized void enterV() {
		try {
			while(!v) {
				wait();
			}
			v = false;
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void exitV() {
		e = true;
		notifyAll();
	}
	
}
