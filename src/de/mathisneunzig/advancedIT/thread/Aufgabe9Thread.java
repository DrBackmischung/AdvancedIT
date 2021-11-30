package de.mathisneunzig.advancedIT.thread;

public class Aufgabe9Thread extends Thread {
	private int start;
	private int end;
	private long result;
	private int[] liste;
	
	public Aufgabe9Thread(int start, int end, int[] liste) {
		this.start = start;
		this.end = end;
		this.liste = liste;
	}

    public void run() {
        summieren(start, end, liste);
    }
	
	public void summieren(int start, int end, int[] liste) {
		
		long l = 0;
		
		for(int i = start; i<=end; i++) {
			l += liste[i];
		}
		
		this.result = l;
	}
	
	public long getResult() {
		return result;
	}
	
}
