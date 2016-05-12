import java.awt.Color;

public class Block extends Piece{

	public Block( int x, int y, Map m ) {
		super( Piece.BLOCK, m );
		setX(x);
		setY(y);
		setColor( Color.WHITE );

	}

	@Override
	public void act() {
		// TODO Auto-generated method stub

	}


}