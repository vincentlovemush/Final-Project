import javax.swing.ImageIcon;

public class WhiteKing extends WhitePiece {
	private int x = 4;
	private int y = 7;
	private boolean isWhite; 
	private boolean hasMoved = false;
	private ImageIcon wKing= new ImageIcon("./data/white king.png");
	public WhiteKing(Chesspiece [][] a){
		super(a);
		}
	public boolean validMove(int moveX, int moveY, int prevX, int prevY) {
		int x2=Math.abs(moveX-prevX);
		int y2=Math.abs(moveY-prevY);
		/* things to implement
		 * boolean hasMoved checks for castling
		 * cannot move into check 
		 * rook cant move for castling
		 */
		//king can only move 1 square, not accounting for castling
		if (x2 > 1 || y2 > 1){
			return false;
		}
		return true;
	}
	public boolean isWhite(){
		return true;
	}
	public ImageIcon print(){
		return wKing;
	}
	//checks if king is checked before movement
	public boolean isChecked(){
		return false;
	}
	@Override
	public boolean moved() {
		hasMoved = true;
		// TODO Auto-generated method stub
		return hasMoved;
		
	}
}
