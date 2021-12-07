package de.mathisneunzig.advancedIT.thread;

import de.mathisneunzig.advancedIT.util.FifoQueue;

public class Aufgabe10Thread extends Thread {
	
	private int id;
	private FifoQueue<String> q;
	
	public Aufgabe10Thread(int id, FifoQueue<String> q) {
		this.id = id;
		this.q = q;
	}

    public void run() {
    	
    	for(int i = 0; i<= 100; i++) {
    		System.out.println("Put: "+id+": "+i);
    		q.put(""+i);
    		System.out.println("Get: "+id+": "+q.get());
    	}
    	
    }
	
}
