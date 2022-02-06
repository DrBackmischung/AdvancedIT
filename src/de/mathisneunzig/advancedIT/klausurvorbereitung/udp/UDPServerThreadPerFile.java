package de.mathisneunzig.advancedIT.klausurvorbereitung.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Map;

public class UDPServerThreadPerFile {
	
	/**
	 * Thread per request Server
	 */
	
	private static DatagramSocket s = null;
	private static Map<String, UDPThreadPerFile> threads;
	
	public static void main(String[] args) {
		threads = new HashMap<>();
		try {
			while(true) {
				s = new DatagramSocket(5999);
				byte[] puffer = new byte[65535];
				DatagramPacket a = new DatagramPacket(puffer, puffer.length);
				s.receive(a);
				String msg = new String(puffer, 0, puffer.length);
				// aus msg die File filtern
				String filename = "name";
				UDPThreadPerFile t = threads.get(filename);
				if(t == null) {
					t = new UDPThreadPerFile(s, a, filename);
					threads.put(filename, t);
				}
				// Dem Thread alle Daten in ne Queue neu mitgeben
				t.start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
