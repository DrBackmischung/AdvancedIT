package de.mathisneunzig.advancedIT.klausurvorbereitung.semaphor;

import java.util.concurrent.Semaphore;

public class Betriebsmittel {
	
	/**
	 * Beispiel: Betriebsmittelverwaltung dreier Betriebsmittel
	 * Damit keine Deadlocks entstehen müssen die Reihenfolgen beachtet werden:
	 * Drive, Disc, Printer
	 */
	
	Semaphore drive = new Semaphore(1, true);
	Semaphore disc = new Semaphore(1, true);
	Semaphore printer = new Semaphore(1, true);
	
	public void getDriveDisc() {
		try {
			drive.acquire();
			disc.acquire();
			// Code
			drive.release();
			disc.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void getDrivePrinter() {
		try {
			drive.acquire();
			printer.acquire();
			// Code
			drive.release();
			printer.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void getDiscPrinter() {
		try {
			disc.acquire();
			printer.acquire();
			// Code
			disc.release();
			printer.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
