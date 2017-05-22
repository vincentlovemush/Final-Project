import javax.swing.ImageIcon;

public class BlankPiece implements Chesspiece {
	public BlankPiece(){
		
	}
	@Override
	public boolean validMove(int moveX, int moveY, int prevX, int prevY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWhite() {
		// TODO Auto-generated method stub
		return false;
	}
	public ImageIcon print(){
		return null;
	}
	@Override
	public boolean moved() {
		// TODO Auto-generated method stub
		return false;
	}
}
