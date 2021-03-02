package es.ieslavereda.Chess;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

import es.ieslavereda.Chess.model.common.*;

import es.ieslavereda.Chess.sockets.GameManager;

public class ChessServer {
	
	private HashMap<Integer, Game> waitingGame;
	private HashMap<Integer, Game> gamesPlaying;
	
	private int connectionActives;
	private int newIdGame;
	
	private int portNumber;
	private boolean listening;

	public ChessServer(int port) {
		
		connectionActives = 0;
		newIdGame = 1;
		portNumber = port;
		listening = true;
		waitingGame = new HashMap<Integer, Game>();
		gamesPlaying = new HashMap<Integer, Game>();
		
	}

	public static void main(String[] args) {
		
		int port;
		
		try {
			port = Integer.parseInt(args[0]);
			
		}catch (Exception e) {
			port = 6000;
		}
		
		ChessServer chs = new ChessServer(port);
		chs.run();

	}
	
	private void run() {
		
		System.out.println("ServerSocket trying to start on the port " + portNumber);
		
		try(ServerSocket ss = new ServerSocket(portNumber)){
			
			while(listening) {
				
				new Thread(new GameManager(ss.accept(),this)).start();
				System.out.println("Connection nº " + (++connectionActives));
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
	}

}
