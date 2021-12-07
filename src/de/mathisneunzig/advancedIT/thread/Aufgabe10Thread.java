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
    	
    	try {
    		for(int i = 0; i<= 10; i+=4) {
	    		System.out.println("Put: "+id+": "+i);
	    		q.put(""+i);
	    		i++;
	    		System.out.println("Put: "+id+": "+i);
	    		q.put(""+i);
	    		i++;
	    		System.out.println("Put: "+id+": "+i);
	    		q.put(""+i);
	    		i++;
	    		System.out.println("Get: "+id+": "+q.get());
	    		System.out.println("Get: "+id+": "+q.get());
	    		System.out.println("Get: "+id+": "+q.get());
	    		System.out.println("Put: "+id+": "+i);
	    		q.put(""+i);
	    		i++;
	    		System.out.println("Get: "+id+": "+q.get());
    		}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
    	
    }
	
}
