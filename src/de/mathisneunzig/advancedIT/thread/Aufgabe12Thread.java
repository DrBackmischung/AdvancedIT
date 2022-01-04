package de.mathisneunzig.advancedIT.thread;

import de.mathisneunzig.advancedIT.monitor.Aufgabe12Monitor;

public class Aufgabe12Thread extends Thread {
	
	private int id;
	private Aufgabe12Monitor table;
	
	public Aufgabe12Thread(int id, Aufgabe12Monitor table) {
		this.id = id;
		this.table = table;
	}
	
	public void run() {
		for(int i = 0; i<3; i++) {
			try {
				Thread.sleep(1000 + id*100);
			} catch(Exception e) {
				e.printStackTrace();
			}
			table.start(id);
			try {
				Thread.sleep(2000 + id*100);
			} catch(Exception e) {
				e.printStackTrace();
			}
			table.stop(id);
		}
	}

}
