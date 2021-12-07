package de.mathisneunzig.advancedIT.aufgaben;

import java.util.ArrayList;
import java.util.List;

import de.mathisneunzig.advancedIT.thread.Aufgabe10Thread;
import de.mathisneunzig.advancedIT.util.FifoQueue;

public class Aufgabe10 {
	
	public static void start() throws InterruptedException {
		
		FifoQueue<String> queue = new FifoQueue<>();
		
		List<Aufgabe10Thread> l = new ArrayList<>();
		
		for(int i = 0; i<2; i++) {
			Aufgabe10Thread t = new Aufgabe10Thread(i+1, queue);
			l.add(t);
			t.start();
		}
		
//		for(int i = 0; i<l.size(); i++) {
//			l.get(i).join();
//		}
		
	}
	
}
