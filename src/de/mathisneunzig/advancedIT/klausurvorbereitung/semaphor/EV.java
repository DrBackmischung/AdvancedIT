package de.mathisneunzig.advancedIT.klausurvorbereitung.semaphor;

import java.util.concurrent.Semaphore;

public class EV {
	
	/**
	 * Generelles E/V Problem
	 */
	
	Semaphore empty = new Semaphore(1, true);
	Semaphore full = new Semaphore(0, true);
	Semaphore mutex = new Semaphore(1, true);
	
	public void e() {
		try {
			empty.acquire();
			mutex.acquire();
			// Code
			mutex.release();
			full.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void v() {
		try {
			full.acquire();
			mutex.acquire();
			// Code
			mutex.release();
			empty.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
