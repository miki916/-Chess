package es.ieslavereda.Chess.model.common;

public abstract class Pieza {

	protected Tipo tipo;
	protected Tablero tablero;
	protected Coordenada posicion;
	
	public Pieza(Coordenada posicion, Tablero tablero) {
		super();
		this.posicion = posicion;
		this.tablero = tablero;
		colocate(posicion);
	}
	
	private void colocate(Coordenada c) {
		
		tablero.getCeldaAt(posicion).setPieza(null);
		posicion = c;
		tablero.getCeldaAt(posicion).setPieza(this);
		
	}
	
	public void moveTo(Coordenada c) {
		
		if(tablero.getPiezaAt(c)==null) {
			colocate(c);
		} else {
			tablero.eliminarPieza(tablero.getPiezaAt(c));
			colocate(c);
		}
	}

	public Color getColor() {
		return tipo.getColor();
	}
	
	public Tipo getTipo() {
		
		return tipo;
		
	}
	
	private Coordenada getPosicion() {
		// TODO Auto-generated method stub
		return posicion;
	}

	@Override
	public String toString() {
		return tipo.getForma();
	}
	
	@Override 
	public boolean equals(Object o) {
		
		Pieza p = (Pieza) o;
		
		if(tipo == p.getTipo()) {
			
			if(posicion == p.getPosicion()) 				
				return true;
						
			return false;	
		}
		
		return false;
		
	}
	
	

	public abstract Lista<Coordenada> getNextMovements();
}











