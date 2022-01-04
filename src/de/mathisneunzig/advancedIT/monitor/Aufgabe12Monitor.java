package de.mathisneunzig.advancedIT.monitor;

public class Aufgabe12Monitor {
	
	private int[] state;
	private int max;
	
	private final int WAITING = 0;
	private final int EATING = 0;
	
	public Aufgabe12Monitor(int max) {
		this.max = max;
		this.state = new int[max];
		for(int i = 0; i<max; i++) {
			state[i] = WAITING;
		}
	}
	
	public synchronized void start(int i) {
		while(state[(i+max-1)% max] == EATING || state[(i+1)%max] == EATING) {
			System.out.println("Philosoph "+i+" hat hunger und will essen!");
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		state[i] = EATING;
		System.out.println("Philosoph "+i+" isst!");
	}
	
	public synchronized void stop(int i) {
		state[i] = WAITING;
		System.out.println("Philosoph "+i+" denkt...");
		notifyAll();
	}
	
}
