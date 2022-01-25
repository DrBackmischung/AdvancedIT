package de.mathisneunzig.advancedIT.netzwerk;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Aufgabe14Server {
	
	private final static String PATH = System.getProperty("user.home") + "/Desktop/Messages/";
	
	public static void main(String[] args) {
		
		try(DatagramSocket s = new DatagramSocket(5999)) {
			System.out.println("Gestartet!");
			byte[] puffer = new byte[65507];
			DatagramPacket p = new DatagramPacket(puffer, puffer.length);
			while(true) {
				s.receive(p);
				String msg = new String(p.getData(), 0, p.getLength());
				String answer = generateAnswer(msg);
				DatagramPacket send = new DatagramPacket(answer.getBytes(), answer.length(), p.getAddress(), p.getPort());
				s.send(send);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String generateAnswer(String cmd) {
		
		if(cmd == null || cmd == ".") return null;
		
		String answer = "Error";
		String[] args = cmd.split(" ", 2);
		String[] params = args[1].split(",");
		BufferedReader br = null;
		PrintWriter pw = null;
		if(args.length != 2) {
			answer = "Error 406: Not Acceptable";
		} else if(args[0].equals("READ") && params.length == 2){
			try {
				int line = Integer.parseInt(params[1]);
				String file = PATH+params[0];
				br = new BufferedReader(new FileReader(file));
				for(int i = 0; i<line; i++) {
					br.readLine();
				}
				String s = br.readLine();
				if(s == null) {
					answer = "Error 404: Not found";
				} else  {
					answer = s;
				}
			} catch(FileNotFoundException e) {
				answer = "Error 404: Not found";
			} catch(IOException e) {
				answer = "Error 500: Internal Server Error";
				e.printStackTrace();
			} catch(IllegalArgumentException e) {
				answer = "Error 406: Not Acceptable";
			} catch(Exception e) {
				answer = "Error 500: Internal Server Error";
				e.printStackTrace();
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					answer = "Error 500: Internal Server Error";
					e.printStackTrace();
				}
			}
		} else if(args[0].equals("WRITE")){
			try {
				int line = Integer.parseInt(params[1]);
				String file = PATH+params[0];
				String data = params[2];
				br = new BufferedReader(new FileReader(file));
				pw = new PrintWriter(new FileWriter(file));
				int index = 0;
				while(true) {
					String s = br.readLine();
					if(index == line) {
						System.out.println(data);
						pw.println(data);
					} else if(s == null) {
						if(index < line) {
							System.out.println();
							pw.println();
						} else {
							System.out.println("Ende :)");
							break;
						}
					} else {
						pw.println(s);
					}
					index++;
				}
				pw.flush();
				answer = "Status 200: OK";
				
			} catch(FileNotFoundException e) {
				answer = "Error 404: Not found";
			} catch(IOException e) {
				answer = "Error 500: Internal Server Error";
				e.printStackTrace();
			} catch(IllegalArgumentException e) {
				answer = "Error 406: Not Acceptable";
			} catch(Exception e) {
				answer = "Error 500: Internal Server Error";
				e.printStackTrace();
			} finally {
				if(pw != null) pw.close();
				try {
					if(br != null) br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			answer = "Error 405: Method not allowed";
		}
		
		return answer;
		
	}

}
