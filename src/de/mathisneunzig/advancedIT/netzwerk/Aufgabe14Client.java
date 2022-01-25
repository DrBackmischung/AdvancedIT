package de.mathisneunzig.advancedIT.netzwerk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Aufgabe14Client {
	
	public static void main(String[] args) {
		
		try(DatagramSocket s = new DatagramSocket(); BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			InetAddress host = InetAddress.getLocalHost();
			while(true) {
				System.out.print("> ");
				String msg = in.readLine();
				if(msg == null || msg == ".") break;
				int l = msg.length();
				if(l > 65507)
					throw new Exception("Zu größer Datensatz!");
				DatagramPacket p = new DatagramPacket(msg.getBytes(), l, host, 5999);
				s.send(p);
				byte[] puffer = new byte[65507];
				DatagramPacket i = new DatagramPacket(puffer, puffer.length);
				s.receive(i);
				String response = new String(i.getData(), 0, i.getLength());
				System.out.println(response);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
		
	}
	
}
