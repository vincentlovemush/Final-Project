import javax.swing.ImageIcon;

public abstract class WhitePiece implements Chesspiece {
	Chesspiece [][] board;
	public WhitePiece(Chesspiece [][] a){
		board = new Chesspiece [8][8];
		board = a;
	}
	@Override
	public boolean validMove(int a, int b, int c, int d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWhite() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moved() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImageIcon print() {
		// TODO Auto-generated method stub
		return null;
	}

}
