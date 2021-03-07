package es.ieslavereda.Chess.model.common;

import java.util.Scanner;

public class Game {
	
	private Tablero board;
	
	public Game(Tablero board) {
		
		this.board = board;
		start();
		
	}
	
	//Mecánicas del juego
	
	private void start() {
	
		System.out.println("Let's go!!");
		
		pause(3000);
		
		Color turn = Color.WHITE;
				
		do {
					
			switch(turn) {
		
				case WHITE: System.out.println("Turno de las Blancas");
							movePiece(turn);
							break;
							
				case BLACK: System.out.println("Turno de las Negras");
							movePiece(turn);
							break;
			}
			
			turn = Color.values()[(turn.ordinal() + 1) % Color.values().length];
			
			pause(600);
			update();
			
			
		}while(board.whiteKingIsAlive() && board.blackKingIsAlive());
		
		
		if (board.whiteKingIsAlive())
			System.out.println(Color.WHITE + " wins.");
		else
			System.out.println(Color.BLACK + " wins.");
	
	}
	
	//Comprueba si hay jacke
	
	private void check(Color turn) {
		
		if(turn == Color.WHITE) {
			
			if(board.checkHacke(turn)) {
				
				System.out.println("HACKE AL BLANCO");
				
			}
			
		}else {
			
			if(board.checkHacke(turn)) {
				
				System.out.println("HACKE AL NEGRO");
				
			}
		}		
	}

	//Mueve una pieza
	
	private void movePiece(Color turn) {
		
	
		Coordenada c;
		Pieza p;
		
		boolean moved = false;
		
		do {
			System.out.println(board.print(turn));
			check(turn);
			c = askCoord(); 
			update();
			
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
				

			}else 				
				System.out.println("Esta vacio");
				
			
			
		}while(!moved);
		
		
		
	}

	//Pregunta por la coordenada
	
	private Coordenada askCoord() {
		
		Scanner sc = new Scanner(System.in);
		
		char col;
		int fil;
		
		System.out.println("Introduce la letra de la coord");
		col = Character.toUpperCase(sc.next().charAt(0));
		
		System.out.println("Introduce el numero de la coord");
		fil = sc.nextInt();
		
		return new Coordenada(col,fil);
	}
	
	//Tiempo de espera
	
	private void pause(int i) {
		
		try {
			Thread.sleep(i);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}		
	}
	
	//Limpia la consola
	
	private void update() {
		
		System.out.print("\033[H\033[2J");
		System.out.flush();
		
	}
	
}
