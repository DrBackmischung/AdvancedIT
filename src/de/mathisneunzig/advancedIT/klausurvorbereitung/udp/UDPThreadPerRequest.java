package de.mathisneunzig.advancedIT.klausurvorbereitung.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPThreadPerRequest extends Thread {
	
	/**
	 * Thread per request Thread
	 */
	
	private DatagramSocket s = null;
	private DatagramPacket r = null;
	
	public UDPThreadPerRequest(DatagramSocket s, DatagramPacket r) {
		this.s = s;
		this.r = r;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				String request = new String(r.getData(), 0, r.getData().length);
				// Code
				s = new DatagramSocket(5999);
				DatagramPacket p = new DatagramPacket(request.getBytes(), request.length(), r.getAddress(), r.getPort());
				s.send(p);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
}
