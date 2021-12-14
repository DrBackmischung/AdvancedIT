package de.mathisneunzig.advancedIT.util;

import java.util.concurrent.Semaphore;

public class Gabel extends Semaphore {
	public Gabel(int wert, boolean fifo) {
		super(wert, fifo);
	}
}
