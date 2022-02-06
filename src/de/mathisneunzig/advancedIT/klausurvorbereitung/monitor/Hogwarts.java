package de.mathisneunzig.advancedIT.klausurvorbereitung.monitor;

public class Hogwarts {
	
	/**
	 * Beispiel: Alle 4 Häuser wollen gleichzeitig zaubern.
	 * G < S < R < H ist die Priorisierung
	 */
	
	private final int Gryffindor = 0;
	private final int Slytherin = 1;
	private final int Ravenclaw = 2;
	private final int Huffelpuff = 3;
	
	private int countG = 0;
	private int countS = 0;
	private int countR = 0;
	private int countH = 0;
	
	private boolean isActive = false;
	
	public synchronized void enterSpell(int haus) {
		try {
			
			if(haus == 0)
				countG++;
			else if(haus == 1)
				countS++;
			else if(haus == 2)
				countR++;
			else if(haus == 3)
				countH++;
			
			while(isActive) {
				while(haus <= Ravenclaw && countH > 0) {
					while(haus <= Slytherin && countR > 0) {
						while(haus == Gryffindor && countS > 0) {
							wait();
						}
						wait();
					}
					wait();
				}
				wait();
			}
			
			isActive = true;
			
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void exitSpell(int haus) {
		if(haus == 0)
			countG--;
		else if(haus == 1)
			countS--;
		else if(haus == 2)
			countR--;
		else if(haus == 3)
			countH--;
		notifyAll();
	}
	
}
