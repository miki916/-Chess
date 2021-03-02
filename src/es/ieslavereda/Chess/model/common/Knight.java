package es.ieslavereda.Chess.model.common;

public class Knight extends Pieza{

	public Knight(Color color, Coordenada posicion, Tablero tablero) {
		super(posicion, tablero);
		
		if(color==Color.WHITE)
			tipo = Tipo.WHITE_KNIGHT;
		else
			tipo = Tipo.BLACK_KNIGHT;
		
	}

	@Override
	public Lista<Coordenada> getNextMovements() {
		
		Lista<Coordenada> lista = new Lista<Coordenada>();
		
		addCoordenada(posicion.up().up().left(),lista);
		addCoordenada(posicion.up().up().right(),lista);
		addCoordenada(posicion.down().down().left(),lista);
		addCoordenada(posicion.down().down().right(),lista);
		addCoordenada(posicion.left().left().up(),lista);
		addCoordenada(posicion.left().left().down(),lista);
		addCoordenada(posicion.right().right().up(),lista);
		addCoordenada(posicion.right().right().down(),lista);
		
		return lista;
	}
	
	private void addCoordenada(Coordenada c, Lista<Coordenada> lista) {
		if (tablero.contiene(c)) {
			if (tablero.getCeldaAt(c).contienePieza()) {
				if (tablero.getCeldaAt(c).getPieza().getColor() != getColor())
					lista.addHead(c);
			} else {
				lista.addHead(c);
			}
		}
	}

}
