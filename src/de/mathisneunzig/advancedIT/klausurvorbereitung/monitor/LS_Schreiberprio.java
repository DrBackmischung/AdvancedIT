package de.mathisneunzig.advancedIT.klausurvorbereitung.monitor;

public class LS_Schreiberprio {
	
	/**
	 * Generelles L/S-Problem
	 */
	
	private int readCounter = 0;
	private int writeCounter = 0;
	
	public synchronized void enterRead() {
		try {
			while(writeCounter > 0) {
				wait();
			}
			readCounter++;
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void exitRead() {
		readCounter--;
		notifyAll();
	}
	
	public synchronized void enterWrite() {
		try {
			writeCounter++;
			while(readCounter > 0) {
				wait();
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void exitWrite() {
		writeCounter--;
		notifyAll();
	}
	
}
