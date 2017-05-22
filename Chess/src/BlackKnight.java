import javax.swing.ImageIcon;

public class BlackKnight extends BlackPiece {
	private int x;
	private int y;
	private boolean isWhite; 
	private ImageIcon bKnight= new ImageIcon("./data/blackKnight.png");
	public BlackKnight(Chesspiece [][] a){
		super(a);
	}
	public boolean validMove(int moveX, int moveY, int prevX, int prevY) {
		int x2=Math.abs(moveX-prevX);
		int y2=Math.abs(moveY-prevY);
		System.out.println(x2 +" "+y2);
		if((x2>2||y2>2)||x2+y2!=3){
			System.out.println("not a valid move");
			return false;
		}
		return true;
	}
	public boolean isWhite(){
		return false;
	}
	public ImageIcon print(){
		return bKnight;
	}

}
