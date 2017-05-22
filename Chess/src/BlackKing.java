import javax.swing.ImageIcon;

public class BlackKing extends BlackPiece {
	private int x = 4;
	private int y = 0;
	private boolean isWhite; 
	private boolean hasMoved;
	private ImageIcon bKing= new ImageIcon("./data/blackking.jpg");
	public BlackKing(Chesspiece[][] a){
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
		return false;
	}
	public ImageIcon print(){
		return bKing;
	}
	//checks if king is checked before movement
	public boolean isChecked(){
		return false;
	}
	@Override
	public boolean moved() {
		hasMoved = true;
		return hasMoved;
		// TODO Auto-generated method stub
		
	}
}
