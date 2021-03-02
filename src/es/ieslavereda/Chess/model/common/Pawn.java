package es.ieslavereda.Chess.model.common;

public class Pawn extends Pieza {

	public Pawn(Color color, Coordenada posicion, Tablero tablero) {
		super(posicion, tablero);
		
		if(color==Color.WHITE)
			tipo = Tipo.WHITE_PAWN;
		else
			tipo = Tipo.BLACK_PAWN;
		
	}
	@Override
	public Lista<Coordenada> getNextMovements() {

		Lista<Coordenada> lista = new Lista<Coordenada>();

		
		
		if(getColor()==Color.BLACK) {
			
			coordenadaNegras(lista);
		
		}else if (getColor()==Color.WHITE){
			
			coordenadaBlancas(lista);
			
		}
		
	
		
		return lista;
	}
	
		//POSIBLES MOVIEMIENTOS DE LA PIEZA (TANTO NEGRAS COMO BLANCAS)
	
	private void coordenadaBlancas(Lista lista) {
		
		addCoordenada(posicion.up(), lista);
		
		if(posicion.getRow() == 2) {
			
			addCoordenada(posicion.up().up(), lista);
			
		}
		
		addCoordenadaDiagonal(posicion.diagonalUpLeft(),lista);
		addCoordenadaDiagonal(posicion.diagonalUpRight(),lista);
		
	}
	
	private void coordenadaNegras(Lista lista) {
		
		addCoordenada(posicion.down(), lista);
		
		if(posicion.getRow() == 7) {
			
			addCoordenada(posicion.down().down(), lista);
			
		}
		
		
		addCoordenadaDiagonal(posicion.diagonalDownLeft(),lista);
		addCoordenadaDiagonal(posicion.diagonalDownRight(),lista);
		
		
	}
	
		//COMPRUEBO QUE SE PUEDEN AÑADIR LA COORDENADAS Y LAS AÑADO 
	
	private void addCoordenada(Coordenada c, Lista<Coordenada> lista) {
		if (tablero.contiene(c)) {
			
			if (!tablero.getCeldaAt(c).contienePieza()) {
			
				lista.addHead(c);
			}
		}
	}
	
	private void addCoordenadaDiagonal(Coordenada c, Lista<Coordenada> lista) {
		
		if (tablero.contiene(c)) {	
			if (tablero.getCeldaAt(c).contienePieza()) {
				if(tablero.getCeldaAt(c).getPieza().getColor() != getColor())
					lista.addHead(c);
			}
		}
	}
	
	
	public void moveTo(Coordenada c) {
		super.moveTo(c);
		
		if(getColor()==Color.WHITE && posicion.getRow()==8) {
			
			tablero.eliminarPieza(this);
			tablero.getBlancas().addHead(new Queen(Color.WHITE,c,tablero));
			
		} else if (getColor()==Color.BLACK && posicion.getRow()==1){
			
			tablero.eliminarPieza(this);
			tablero.getNegras().addHead(new Queen(Color.BLACK,c,tablero));
			
		}
		
	}

}
