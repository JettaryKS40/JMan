import java.awt.Color;

public class Walker extends Piece {

	public Walker( int x, int y, int c, Map m ) {
		super( Piece.WALKER, m );
		setX(x);
		setY(y);
		if( c == 0 ) { this.setColor( Color.RED ); }
		else if( c == 1 ) { this.setColor( Color.GREEN ); }
		else if( c == 2 ) { this.setColor( Color.YELLOW ); }

	}

	public Walker( int x, int y, Color c, Map m ) {
		super(Piece.WALKER, m);
		setX(x);
		setY(y);
		setColor(c);

	}

	@Override
	public void act() {
		if( rand( 1, 3 ) == 2 ) {
			int move = rand( 0, 3 );
			int posX = getX();
			int posY = getY();

			if( move == 0 ) { posY--; }
			else if( move == 1 ) { posY++; }
			else if( move == 2 ) { posX--; }
			else if( move == 3 ) { posX++; }

			if( !getMap().isInGrid( posX, posY ) ) {
				posX = getX();
				posY = getY();
				
			}
			
			else if(!this.getMap().isEmpty( posX, posY ) ) {
				Piece piece = getMap().pieceAt( posX, posY );
				if( piece.getType() == Piece.BLOCK || piece.getType() == Piece.JMAN || piece.getType() == Piece.PILLAR ) {
					posX = getX();
					posY = getY();
				}
			}

			if( posX != getX() || posY != getY() )
				this.getMap().move(getX(), getY(), posX, posY );
		}

	}


}
