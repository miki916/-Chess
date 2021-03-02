package es.ieslavereda.Chess.model.common;

public class Rook extends Pieza {

	public Rook(Color color, Coordenada posicion, Tablero tablero) {
		super(posicion, tablero);
		// TODO Auto-generated constructor stub
		
		if(color==Color.WHITE)
			tipo = Tipo.WHITE_ROOK;
		else
			tipo = Tipo.BLACK_ROOK;
		
	}

	@Override
	public Lista<Coordenada> getNextMovements() {
		
		return getNextMovements(this);
	}
	
	public static Lista<Coordenada> getNextMovements(Pieza p){
		
		Tablero t = p.tablero;
		Lista<Coordenada> lista = new Lista<>();
		Coordenada c;
				
		boolean ocupada;
		
		// UP 
		
		c =  p.posicion.up();
		ocupada = false;
	
		while(t.contiene(c) && ocupada == false){
			
			if (t.getCeldaAt(c).contienePieza()) {	
				if (t.getCeldaAt(c).getPieza().getColor() != p.getColor()) {
					
					lista.addHead(c);
					ocupada = true;
					
				}else ocupada = true;
				
			}else {
				
				lista.addHead(c);
				c = c.up();
			}
		}
		
		// RIGHT
		
		c =  p.posicion.right();
		ocupada = false;
	
		while(t.contiene(c) && ocupada == false){
			
			if (t.getCeldaAt(c).contienePieza()) {	
				if (t.getCeldaAt(c).getPieza().getColor() != p.getColor()) {
					
					lista.addHead(c);
					ocupada = true;
					
				}else ocupada = true;
				
			}else {
				
				lista.addHead(c);
				c = c.right();
			}
		}
		
		// DOWN
		
		c =  p.posicion.down();
		ocupada = false;
	
		while(t.contiene(c) && ocupada == false){
			
			if (t.getCeldaAt(c).contienePieza()) {	
				if (t.getCeldaAt(c).getPieza().getColor() != p.getColor()) {
					
					lista.addHead(c);
					ocupada = true;
					
				}else ocupada = true;
				
			}else {
				
				lista.addHead(c);
				c = c.down();
			}
		}
		
		
		// Left
		
		c =  p.posicion.left();
		ocupada = false;
	
		while(t.contiene(c) && ocupada == false){
			
			if (t.getCeldaAt(c).contienePieza()) {	
				if (t.getCeldaAt(c).getPieza().getColor() != p.getColor()) {
					
					lista.addHead(c);
					ocupada = true;
					
				}else ocupada = true;
				
			}else {
				
				lista.addHead(c);
				c = c.left();
			}
		}
		
		return lista;
	}

}
