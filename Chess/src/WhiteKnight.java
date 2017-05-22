import javax.swing.ImageIcon;

public class WhiteKnight extends WhitePiece {
	private boolean isWhite; 
	private ImageIcon wKnight= new ImageIcon("./data/knight white.jpg");
	public WhiteKnight(Chesspiece [][] a){
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
		return true;
	}
	public ImageIcon print(){
		return wKnight;
	}
}
