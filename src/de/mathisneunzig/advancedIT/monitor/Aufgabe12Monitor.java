package de.mathisneunzig.advancedIT.monitor;

public class Aufgabe12Monitor {
	
	private boolean[] eating;
	private int max;
	
	public Aufgabe12Monitor(int max) {
		this.max = max;
		this.eating = new boolean[max];
		for(int i = 0; i<max; i++) {
			eating[i] = false;
		}
	}
	
	public synchronized void start(int i) {
		while(eating[(i+max-1) % max] || eating[(i+1) % max]) {
			System.out.println("Philosoph "+i+" hat hunger und will essen!");
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		eating[i] = true;
		System.out.println("Philosoph "+i+" isst!");
	}
	
	public synchronized void stop(int i) {
		eating[i] = false;
		System.out.println("Philosoph "+i+" denkt...");
		notifyAll();
	}
	
}
