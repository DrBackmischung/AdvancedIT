package de.mathisneunzig.advancedIT.klausurvorbereitung.monitor;

public class Sauna {
	
	/**
	 * Beispiel: Sauna
	 * Entweder Frauen oder Männer, aber nicht gleichzeitig
	 */
	
	int maleCounter = 0;
	int femaleCounter = 0;
	
	public synchronized void enterMale() {
		try {
			while(femaleCounter > 0) {
				wait();
			}
			maleCounter ++;
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void exitMale() {
		maleCounter --;
		notifyAll();
	}
	
	public synchronized void enterFemale() {
		try {
			while(maleCounter > 0) {
				wait();
			}
			femaleCounter ++;
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void exitFemale() {
		femaleCounter --;
		notifyAll();
	}
	
}
