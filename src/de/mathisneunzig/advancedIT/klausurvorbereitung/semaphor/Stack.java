package de.mathisneunzig.advancedIT.klausurvorbereitung.semaphor;

import java.util.concurrent.Semaphore;

public class Stack {
	
	/**
	 * Beispiel Stack (Kellerspeicher)
	 * Zwei Methoden, push und pop. Push legt ein Objekt auf den Stack drauf, pop nimmt ihn runter.
	 * Overflow und Unterlauf darf nicht passieren.
	 * Tipp: E/V Problem
	 */
	
	Object[] stack = null;
	int element = 0;
	int max = 0;
	
	Semaphore empty = null;
	Semaphore full = new Semaphore(0, true);
	
	public Stack(int max) {
		this.max = max;
		stack = new Object[max];
		empty = new Semaphore(max, true);
	}
	
	public void push(Object o) {
		try {
			empty.acquire();
			stack[element] = o;
			element ++;
			full.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Object pop() {
		try {
			full.acquire();
			Object o = stack[element];
			element--;
			empty.release();
			return o;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
