import javax.swing.ImageIcon;

public class WhitePawn extends WhitePiece {
	private int x;
	private int y;
	private boolean isWhite; 
	public boolean hasMoved=false;
	public boolean enPassant= false;
	public boolean doingPassant = false;
	private ImageIcon wPawn= new ImageIcon("./data/images.png");
	public WhitePawn(Chesspiece [][] a){
		super(a);
		}
	public boolean validMove(int moveX, int moveY, int prevX, int prevY) {	
		int x2=Math.abs(moveX-prevX);
		System.out.println(x2 +" "+ (prevY-moveY));
		if(prevY-moveY==1&& x2==0&&!(board[moveX][moveY] instanceof BlackPiece))
			return true;
		if(x2==0 && prevY-moveY==2&&!hasMoved &&!(board[moveX][moveY] instanceof BlackPiece)&&!(board[moveX][moveY-1] instanceof BlackPiece)){
			enPassant= true;	
			return true;
		}
		if (x2==1 && prevY-moveY==1 && (board[moveX][moveY] instanceof BlackPiece)){
			System.out.println(x2+" "+ (prevY-moveY)+" "+ board[moveX][moveY].toString());
			return true;
		}
		if (x2==1 && prevY-moveY==1 && board[moveX][moveY] instanceof BlankPiece && board[moveX][prevY] instanceof BlackPawn&& ((BlackPawn)(board[moveX][prevY])).enPassant){
			System.out.println(x2+" "+ (prevY-moveY)+" "+ board[moveX][moveY].toString());
			board[moveX][prevY]= new BlankPiece();
			doingPassant = true;
			return true;
		}
		
		
		return false;
	}
	public boolean isWhite(){
		return true;
	}
	public ImageIcon print(){
		return wPawn;
	}
	public boolean moved(){
		hasMoved=true;
		return hasMoved;
	}
}
