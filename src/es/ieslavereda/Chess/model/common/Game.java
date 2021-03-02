package es.ieslavereda.Chess.model.common;

import java.util.Scanner;

public class Game {
	
	private Tablero board;
	
	public Game(Tablero board) {
		
		this.board = board;
		start();
		
	}

	private void start() {
	
		System.out.println("Let's go!!");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		Color turn = Color.WHITE;
		
	
		
		do {
			
			System.out.println(board.print(turn));
			
			switch(turn) {
			
				case WHITE: System.out.println("Turno de las Blancas");
							movePiece(turn);
							break;
							
				case BLACK: System.out.println("Turno de las Negras");
							movePiece(turn);
							break;
			}
			
			turn = Color.values()[(turn.ordinal() + 1) % Color.values().length];
	
			
			
			
		}while(board.whiteKingIsAlive() && board.blackKingIsAlive());
		
		
		if (board.whiteKingIsAlive())
			System.out.println(Color.WHITE + " wins.");
		else
			System.out.println(Color.BLACK + " wins.");
	
	}

	private void movePiece(Color turn) {
		
		Coordenada c;
		Pieza p;
		
		boolean moved = false;
		
		do {
			
			c = askCoord(); 
			
			if(board.getPiezaAt(c) != null) {
				
				p =  board.getPiezaAt(c);
								
				if(board.contiene(c) && p.getColor() == turn)	{
					
					System.out.println(board.print(turn));
					
					System.out.println("Movimientos posibles de " + p + ": ");
					System.out.println(p.getNextMovements());
					
					if(!p.getNextMovements().isEmpty()) {
					
						System.out.println("Donde quieres mover? ");
						c = askCoord();
						
						if(p.getNextMovements().contains(c)) {
						
							if(board.getPiezaAt(c) != null) {
								
								System.out.println("Ficha eliminada: " + board.getPiezaAt(c));
								p.moveTo(c);
								moved = true;
								System.out.println("Ficha movida");
								
							}else {
								
								p.moveTo(c);
								moved = true;
								System.out.println("Ficha movida");
								
							}
						}				
					}else
						
						System.out.println("No tienes movimientos posibles");
				}else
					
					System.out.println("No existe esa coordenada o estas eligiendo el color equivocado");

			}else System.out.println("Esta vacio");
			
		}while(!moved);
		
	}

	private Coordenada askCoord() {
		
		Scanner sc = new Scanner(System.in);
		
		char col;
		int fil;
		
		System.out.println("Introduce la letra de la coord");
		col = sc.next().charAt(0);
		
		System.out.println("Introduce el numero de la coord");
		fil = sc.nextInt();
		
		return new Coordenada(col,fil);
	}
	
}
