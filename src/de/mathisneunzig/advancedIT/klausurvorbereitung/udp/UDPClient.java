package de.mathisneunzig.advancedIT.klausurvorbereitung.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	
	/**
	 * Client
	 */
	
	private static DatagramSocket s = null;
	private static BufferedReader br = null;
	
	public static void main(String[] args) {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				s = new DatagramSocket();
				String msg = br.readLine();
				if(msg == ".") break;
				DatagramPacket p = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getLocalHost(), 5999);
				s.send(p);
				byte[] puffer = new byte[65535];
				DatagramPacket a = new DatagramPacket(puffer, puffer.length);
				s.receive(a);
				String response = new String(puffer, 0, puffer.length);
				System.out.println(response);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
