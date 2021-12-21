package de.mathisneunzig.advancedIT.thread;

import de.mathisneunzig.advancedIT.util.Gabel;
import de.mathisneunzig.advancedIT.util.Philosoph;

public class Aufgabe11Thread extends Thread {
	
	private int id;
	private Philosoph p;
	private Gabel links, rechts;
	
	public static final int DENKEN = 0;
	public static final int HUNGER = 1;
	public static final int ESSEN = 2;
	
	public Aufgabe11Thread(int id, Philosoph p, Gabel links, Gabel rechts) {
		this.id = id;
		this.p = p;
		this.links = links;
		this.rechts = rechts;
	}

    public void run() {
    	
    	System.out.println(p.getName()+" ("+p.getC()+") will essen!");
    	
    	try {
			links.acquire();
	    	rechts.acquire();
	    	
	    	System.out.println(p.getName()+" ("+p.getC()+") isst!");
	    	
	    	Thread.sleep(1000);
	    	
	    	System.out.println(p.getName()+" ("+p.getC()+") fertig :3");

	    	links.release();
	    	rechts.release();
	    	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    }
	
}
