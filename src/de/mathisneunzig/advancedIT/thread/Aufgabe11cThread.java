package de.mathisneunzig.advancedIT.thread;

import de.mathisneunzig.advancedIT.aufgaben.Aufgabe11c;
import de.mathisneunzig.advancedIT.util.Philosoph;

public class Aufgabe11cThread extends Thread {
	
	private int id;
	private Philosoph p;
	
	public Aufgabe11cThread(int id, Philosoph p) {
		this.id = id;
		this.p = p;
	}
	
	public long getId() {
		return this.id;
	}
	
	public Philosoph getP() {
		return p;
	}

    public void run() {
    	
    	for(int i = 0; i<1; i++) {
    		try {
            	
            	System.out.println(p.getName()+" ("+p.getC()+") denkt nach...");
            	sleep((int) (Math.random() * 4000));
    	    	System.out.println(p.getName()+" ("+p.getC()+") hat jetzt hunger!");
    	    	Aufgabe11c.mutex.acquire();
    	    	
    	    	if(Aufgabe11c.zustand[(id+4)%5] != Aufgabe11c.ESSEN && Aufgabe11c.zustand[(id+1)%5] != Aufgabe11c.ESSEN) {
    	    		Aufgabe11c.zustand[id] = Aufgabe11c.ESSEN;
    	    		Aufgabe11c.p[id].release();
    	    	} else {
    	    		Aufgabe11c.zustand[id] = Aufgabe11c.HUNGER;
    		    	System.out.println(p.getName()+" ("+p.getC()+") wartet auf freie Gabeln...");
    	    	}
    	    	Aufgabe11c.mutex.release();
    	    	Aufgabe11c.p[id].acquire();
    	    	System.out.println(p.getName()+" ("+p.getC()+") isst!");

    	    	Thread.sleep(1000);
    	    	
    	    	Aufgabe11c.mutex.acquire();
    	    	
    	    	System.out.println(p.getName()+" ("+p.getC()+") fertig :3");
	    		Aufgabe11c.zustand[id] = Aufgabe11c.DENKEN;
	    		
	    		if(Aufgabe11c.zustand[(id+4)%5] == Aufgabe11c.HUNGER && Aufgabe11c.zustand[(id+3)%5] != Aufgabe11c.ESSEN) {
    	    		Aufgabe11c.zustand[(id+4)%5] = Aufgabe11c.ESSEN;
    	    		Aufgabe11c.p[(id+4)%5].release();
        	    	System.out.println(p.getName()+" ("+p.getC()+") weckt seinen Nachbarn "+Aufgabe11c.getNameForId((id+4)%5)+"...der ist beim Warten einfach eingeschlafen :D");
    	    	} 
	    		
	    		if(Aufgabe11c.zustand[(id+1)%5] == Aufgabe11c.HUNGER && Aufgabe11c.zustand[(id+2)%5] != Aufgabe11c.ESSEN) {
    	    		Aufgabe11c.zustand[(id+1)%5] = Aufgabe11c.ESSEN;
    	    		Aufgabe11c.p[(id+1)%5].release();
        	    	System.out.println(p.getName()+" ("+p.getC()+") weckt seinen Nachbarn "+Aufgabe11c.getNameForId((id+1)%5)+"...der ist beim Warten einfach eingeschlafen :D");
    	    	} 
    	    	
    	    	Aufgabe11c.mutex.release();
    	    	
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    	
    }
	
}
