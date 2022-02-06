package de.mathisneunzig.advancedIT.klausurvorbereitung.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPThreadPerFile extends Thread {
	
	/**
	 * Thread per request Thread
	 */
	
	private DatagramSocket s = null;
	private DatagramPacket r = null;
	private String filename;
	
	public UDPThreadPerFile(DatagramSocket s, DatagramPacket r, String filename) {
		this.s = s;
		this.r = r;
		this.filename = filename;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				String request = new String(r.getData(), 0, r.getData().length);
				// Code
				// mit dem Filenamen halt Daten auslesen
				s = new DatagramSocket(5999);
				DatagramPacket p = new DatagramPacket(request.getBytes(), request.length(), r.getAddress(), r.getPort());
				s.send(p);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
}
