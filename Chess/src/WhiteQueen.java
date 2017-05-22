import javax.swing.ImageIcon;

public class WhiteQueen extends WhitePiece {
	private int x;
	private int y;
	private boolean isWhite;
	
	private ImageIcon wQueen= new ImageIcon("./data/queen white.png");
	public WhiteQueen(Chesspiece [][] a){
		super(a);
		}
	public boolean validMove(int moveX, int moveY, int prevX, int prevY) {	
		int x2 = Math.abs(moveX-prevX);
		int y2 = Math.abs(moveY-prevY);
		//moving horizontally.
		if(y2==0){
			if (prevX-moveX>0){
				for (int i=prevX-1;i>moveX;i--)
				{
					if (board[i][moveY] instanceof BlackPiece || board[i][moveY] instanceof WhitePiece)
						return false;
				}
			}
			else if (prevX-moveX<0){
				for (int i=prevX+1;i<moveX;i++)
				{
					if (board[i][moveY] instanceof BlackPiece || board[i][moveY] instanceof WhitePiece)
						return false;
				}
			}
		}
		//moving vertically
		else if(x2==0){
			if (prevY-moveY>0){
				for (int i=prevY-1;i>moveY;i--){
					if (board[moveX][i] instanceof BlackPiece || board[moveX][i] instanceof WhitePiece)
						return false;
				}
			}
			else if (prevY-moveY<0){
				for (int i=prevY+1;i<moveY;i++){
					if (board[moveX][i] instanceof BlackPiece || board[moveX][i] instanceof WhitePiece)
						return false;
				}
			}
		//moving diagonally 
		}else if(x2 == y2){
			//moving top left
			if(prevX>moveX&&prevY>moveY){
				for(int i=1;i<x2;i++){
					if(board[prevX-i][prevY-i] instanceof BlackPiece ||board[prevX-i][prevY-i] instanceof WhitePiece){
						System.out.println("a");
						return false;
					}
				}
			}
			//moving down left
			if(prevX>moveX&&prevY<moveY){
				for(int i=1;i<x2;i++){
					if(board[prevX-i][prevY+i] instanceof BlackPiece ||board[prevX-i][prevY+i] instanceof WhitePiece){
						System.out.println("b");
						return false;
					}
				}
			}
			//moving top right
			if(prevX<moveX&&prevY>moveY){
				for(int i=1;i<x2;i++){
					if(board[prevX+i][prevY-i] instanceof BlackPiece ||board[prevX+i][prevY-i] instanceof WhitePiece){
						System.out.println("c");
						return false;
					}
				}
			}
			//moving down right
			if(prevX<moveX&&prevY<moveY){
				for(int i=1;i<x2;i++){
					if(board[prevX+i][prevY+i] instanceof BlackPiece ||board[prevX+i][prevY+i] instanceof WhitePiece){
						System.out.println("d");
						return false;
					}
				}
			}
		}else if (x2 != y2){
			return false;
		}
		return true;
	}
	public boolean isWhite(){
		return true;
	}
	public ImageIcon print(){
		return wQueen;
	}
}
