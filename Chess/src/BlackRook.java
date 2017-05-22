import javax.swing.ImageIcon;

public class BlackRook extends BlackPiece {
	private int x;
	private int y;
	private boolean isWhite; 

	private ImageIcon bRook= new ImageIcon("./data/rook black.png");
	public BlackRook(Chesspiece [][] a){
		super(a);
	}
	public boolean validMove(int moveX, int moveY, int prevX, int prevY) {	
		int x2=Math.abs(moveX-prevX);
		int y2=Math.abs(moveY-prevY);
		if(x2!=0 && y2!=0)
			return false;
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
		else if(x2==0){
			if (prevY-moveY>0){
				for (int i=prevY-1;i>moveY;i--)
				{
					if (board[moveX][i] instanceof BlackPiece || board[moveX][i] instanceof WhitePiece)
						return false;
				}
			}
			else if (prevY-moveY<0){
				for (int i=prevY+1;i<moveY;i++)
				{
					if (board[moveX][i] instanceof BlackPiece || board[moveX][i] instanceof WhitePiece)
						return false;
				}
			}
		}
		return true;
	}
	public boolean isWhite(){
		return false;
	}
	public ImageIcon print(){
		return bRook;
	}
	@Override
	public boolean moved() {
		
		// TODO Auto-generated method stub
		return false;
	}
}
