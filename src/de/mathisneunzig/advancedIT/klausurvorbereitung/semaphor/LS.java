package de.mathisneunzig.advancedIT.klausurvorbereitung.semaphor;

import java.util.concurrent.Semaphore;

public class LS {
	
	/**
	 * Generelles L/S-Problem
	 */
	
	Semaphore writer = new Semaphore(1, true);
	Semaphore mutex = new Semaphore(1, true);
	int readCounter = 0;
	
	public void write() {
		try {
			writer.acquire();
			// Schreiben
			writer.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void read() {
		try {
			mutex.acquire();
			readCounter ++;
			if(readCounter == 1) {
				writer.acquire();
			}
			mutex.release();
			// Lesen
			mutex.acquire();
			readCounter --;
			if(readCounter == 0) {
				writer.release();
			}
			mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
