package de.mathisneunzig.advancedIT.netzwerk;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Aufgabe13Server {
	
	public static void main(String[] args) {
		
		try(DatagramSocket s = new DatagramSocket(4999)) {
			System.out.println("Gestartet!");
			byte[] puffer = new byte[65507];
			DatagramPacket p = new DatagramPacket(puffer, puffer.length);
			while(true) {
				s.receive(p);
				String msg = new String(p.getData(), 0, p.getLength());
				System.out.println(p.getAddress().getHostName()+" > "+msg);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
