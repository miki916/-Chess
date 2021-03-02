package es.ieslavereda.Chess.model.common;

public class Bishop extends Pieza {

	public Bishop(Color color,Coordenada posicion, Tablero tablero) {
		super(posicion, tablero);
		
		if(color==Color.WHITE)
			tipo = Tipo.WHITE_BISHOP;
		else
			tipo = Tipo.BLACK_BISHOP;
	}

	@Override
	public Lista<Coordenada> getNextMovements() {
		// TODO Auto-generated method stub
		
		return getNextMovements(this);
	}
	
	public static Lista<Coordenada> getNextMovements(Pieza p){
		
		Tablero t = p.tablero;
		Lista<Coordenada> lista = new Lista<>();
		Coordenada c ;
			
		boolean ocupada;
		
		// UP LEFT
		
		c =  p.posicion.diagonalUpLeft();
		ocupada = false;
	
		while(t.contiene(c) && ocupada == false){
			
			if (t.getCeldaAt(c).contienePieza()) {	
				if (t.getCeldaAt(c).getPieza().getColor() != p.getColor()) {
					
					lista.addHead(c);
					ocupada = true;
					
				}else ocupada = true;
				
			}else {
				
				lista.addHead(c);
				c = c.diagonalUpLeft();	
			}
		}
				
		// UP RIGHT
		
		c =  p.posicion.diagonalUpRight();
		ocupada = false;
		
		while(t.contiene(c) && ocupada == false){
			
			if (t.getCeldaAt(c).contienePieza()) {
				if (t.getCeldaAt(c).getPieza().getColor() != p.getColor()) {
					
					lista.addHead(c);
					ocupada = true;
					
				}else ocupada = true;
				
			}else {
				
				lista.addHead(c);
				c = c.diagonalUpRight();	
			}
		}
		
		// DOWN LEFT
		
		c =  p.posicion.diagonalDownLeft();
		ocupada = false;
		
		while(t.contiene(c) && ocupada == false){
			
			if (t.getCeldaAt(c).contienePieza()) {
				if (t.getCeldaAt(c).getPieza().getColor() != p.getColor()) {
					
					lista.addHead(c);
					ocupada = true;
					
				}else ocupada = true;
				
			}else {
				
				lista.addHead(c);
				c = c.diagonalDownLeft();	
			}
		}
		
		
		// DOWN RIGHT
		
		c =  p.posicion.diagonalDownRight();
		ocupada = false;
		
		while(t.contiene(c) && ocupada == false){
			
			if (t.getCeldaAt(c).contienePieza()) {
				if (t.getCeldaAt(c).getPieza().getColor() != p.getColor()) {
					
					lista.addHead(c);
					ocupada = true;
					
				}else ocupada = true;
				
			}else {
				
				lista.addHead(c);
				c = c.diagonalDownRight();	
			}
		}
		
		
		
		return lista;
	}
	
	
		
}
