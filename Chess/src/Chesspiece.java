import javax.swing.ImageIcon;

public interface Chesspiece {
	public boolean validMove(int a, int b, int c, int d);
	public boolean isWhite();
	public boolean moved();
	public ImageIcon print();
}
