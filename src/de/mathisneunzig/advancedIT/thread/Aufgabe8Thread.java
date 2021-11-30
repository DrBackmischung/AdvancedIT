package de.mathisneunzig.advancedIT.thread;

public class Aufgabe8Thread implements Runnable {
	
	private int id;
	
	public Aufgabe8Thread(int id) {
		this.id = id;
	}

    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 1000));
        } catch(Exception e) {}
        System.out.println("Thread" + this.id +" hat fertig.");
    }
	
}
