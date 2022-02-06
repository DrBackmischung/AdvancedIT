package de.mathisneunzig.advancedIT.klausurvorbereitung.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerThreadPerRequest {
	
	/**
	 * Thread per request Server
	 */
	
	private static DatagramSocket s = null;
	
	public static void main(String[] args) {
		try {
			while(true) {
				s = new DatagramSocket(5999);
				byte[] puffer = new byte[65535];
				DatagramPacket a = new DatagramPacket(puffer, puffer.length);
				s.receive(a);
				UDPThreadPerRequest t = new UDPThreadPerRequest(s, a);
				t.start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
