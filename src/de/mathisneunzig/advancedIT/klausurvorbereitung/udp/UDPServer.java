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
				byte[] puffer = new byte[65535];
				DatagramPacket a = new DatagramPacket(puffer, puffer.length);
				s.receive(a);
				String response = new String(puffer, 0, puffer.length);
				s = new DatagramSocket(5999);
				DatagramPacket p = new DatagramPacket(response.getBytes(), response.length(), a.getAddress(), a.getPort());
				s.send(p);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
