import javax.swing.ImageIcon;

public class WhiteBishop extends WhitePiece{
	private int x;
	private int y;
	private boolean isWhite; 
	private ImageIcon wBishop= new ImageIcon("./data/bishop white.png");
	public WhiteBishop(Chesspiece [][] a){
		super(a);
	}
	public boolean validMove(int moveX, int moveY, int prevX, int prevY) {
		int x2=moveX-prevX;
		int y2=moveY-prevY;
		if(Math.abs(x2)!=Math.abs(y2)){
			System.out.println("bad move!!"+Math.abs(x2)+" "+ Math.abs(y2));
			return false;
		}
		if(prevX>moveX&&prevY>moveY)
			for(int i=1;i<Math.abs(x2);i++)
				if(board[prevX-i][prevY-i] instanceof BlackPiece ||board[prevX-i][prevY-i] instanceof WhitePiece){
					System.out.println("a");
					return false;
				}
		if(prevX>moveX&&prevY<moveY)
			for(int i=1;i<Math.abs(x2);i++)
				if(board[prevX-i][prevY+i] instanceof BlackPiece ||board[prevX-i][prevY+i] instanceof WhitePiece){
					System.out.println("b");
					return false;
				}
		if(prevX<moveX&&prevY>moveY)
			for(int i=1;i<Math.abs(x2);i++)
				if(board[prevX+i][prevY-i] instanceof BlackPiece ||board[prevX+i][prevY-i] instanceof WhitePiece){
					System.out.println("c");
					return false;
				}
		if(prevX<moveX&&prevY<moveY)
			for(int i=1;i<Math.abs(x2);i++)
				if(board[prevX+i][prevY+i] instanceof BlackPiece ||board[prevX+i][prevY+i] instanceof WhitePiece){
					System.out.println("d");
					return false;
				}

		return true;
	}
	public boolean isWhite(){
		return true;
	}
	public ImageIcon print(){
		return wBishop;
	}
}
