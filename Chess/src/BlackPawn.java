import javax.swing.ImageIcon;

public class BlackPawn extends BlackPiece {
	private int x;
	private int y;
	private boolean isWhite; 
	private boolean hasMoved;
	public boolean enPassant= false;
	public boolean doingPassant = false;
	private ImageIcon bPawn= new ImageIcon("./data/blackk pawn.png");
	public BlackPawn(Chesspiece[][]a){
		super(a);
		}
	public boolean validMove(int moveX, int moveY, int prevX, int prevY) {	
		int x2=Math.abs(moveX-prevX);
		System.out.println(x2 +" "+ (moveY-prevY));
		if(moveY-prevY==1&& x2==0&& !(board[moveX][moveY] instanceof WhitePiece)){
			return true;
		}
		if(x2==0 && moveY-prevY==2&&!hasMoved &&!(board[moveX][moveY] instanceof WhitePiece)&&!(board[moveX][moveY-1] instanceof WhitePiece)){
			enPassant= true;
			return true;
		}
		if (x2==1 && moveY-prevY==1 && (board[moveX][moveY] instanceof WhitePiece)){
			System.out.println(x2+" "+ (prevY-moveY)+" "+ board[moveX][moveY].toString());
			return true;
		}
		if (x2==1 && moveY-prevY==1 && board[moveX][moveY] instanceof BlankPiece && board[moveX][prevY] instanceof WhitePawn&& ((WhitePawn)(board[moveX][prevY])).enPassant){
			System.out.println(x2+" "+ (prevY-moveY)+" "+ board[moveX][moveY].toString());
			board[moveX][prevY]= new BlankPiece();
			doingPassant = true;
			return true;
		}
		return false;
	}
	public boolean isWhite(){
		return false;
	}
	public ImageIcon print(){
		return bPawn;
	}
	@Override
	public boolean moved() {
		hasMoved = false;
		return hasMoved;
		// TODO Auto-generated method stub
		
	}
}
