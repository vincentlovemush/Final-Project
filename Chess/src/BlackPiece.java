import javax.swing.ImageIcon;

public abstract class BlackPiece implements Chesspiece {

	Chesspiece [][] board;
	public BlackPiece(Chesspiece[][] a){
		board = new Chesspiece [8][8];
		board = a;
	}
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
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public ImageIcon print() {
		// TODO Auto-generated method stub
		return null;
	}

}
