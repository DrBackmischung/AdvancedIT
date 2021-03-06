package de.mathisneunzig.advancedIT.klausurvorbereitung.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
	
	/**
	 * Single Threaded Server
	 */
	
	private static DatagramSocket s = null;
	
	public static void main(String[] args) {
		try {
			while(true) {
				s = new DatagramSocket(5999);
				byte[] puffer = new byte[65535];
				DatagramPacket a = new DatagramPacket(puffer, puffer.length);
				s.receive(a);
				String request = new String(puffer, 0, puffer.length);
				// Code
				DatagramPacket p = new DatagramPacket(request.getBytes(), request.length(), a.getAddress(), a.getPort());
				s.send(p);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
