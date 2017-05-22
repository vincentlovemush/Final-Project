import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import java.awt.*;

public class ChessRunner extends JPanel implements MouseListener{
	public int mouseX ,mouseY;
	public Chesspiece changing;
	Chesspiece[][] board= new Chesspiece[8][8];
	private Graphics g;
	private boolean whiteTurn = true;
	//	ImageIcon whiteKnight = new ImageIcon(this.getClass().getResource("C:/Users/Vincent/Desktop/Vincent_APCS_Spring/Chess/whiteKnight.jpg"));
	//	ImageIcon blackKnight = new ImageIcon(this.getClass().getResource("C:/Users/Vincent/Desktop/Vincent_APCS_Spring/Chess/blackKnight.png"));

	public ChessRunner(){
		addMouseListener(this);
		for(int i=0;i<8;i++){
			for (int j=1;j<7;j++)
				if(j==1)
					board[i][j] = new BlackPawn(board);
				else if(j==6)
					board[i][j] = new WhitePawn(board);
				else
					board[i][j]= new BlankPiece();
		}
		board[1][0] = new BlackKnight(board);
		board[6][0] = new BlackKnight(board);
		board[0][0] = new BlackRook(board);
		board[7][0] = new BlackRook(board);
		board[2][0] = new BlackBishop(board);
		board[5][0] = new BlackBishop(board);
		board[4][0] = new BlackKing(board);
		board[3][0] = new BlackQueen(board);

		board[1][7] = new WhiteKnight(board);
		board[6][7] = new WhiteKnight(board);
		board[0][7] = new WhiteRook(board);
		board[7][7] = new WhiteRook(board);
		board[2][7] = new WhiteBishop(board);
		board[5][7] = new WhiteBishop(board);
		board[4][7] = new WhiteKing(board);
		board[3][7] = new WhiteQueen(board);

	}
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(450, 450);
		f.add(new ChessRunner());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public WhiteKing findKing (){
		for (int i=0;i<8;i++){
			for (int j=0; j<8;j++){
				if(board[i][j] instanceof WhiteKing)
					return (WhiteKing)(board[i][j]);
			}
		}
		return null;
	}
	public void paint(Graphics g) {
		for (int i=0;i<400;i=i+50){
			for (int j=0;j<400;j=j+50){
				if ((i%100==0&&j%100==0)||(i%100!=0 && j%100!=0)){
					g.setColor(Color.black);
					g.fillRect(i, j, 50, 50);
				}
				else{
					g.setColor(Color.white);
					g.fillRect(i, j, 50, 50);
				}
			}
		}
		for(int i=0;i<8;i++)
			for (int j=0;j<8;j++)
				if(!(board[i][j] instanceof BlankPiece))
					board[i][j].print().paintIcon(this, g, 50*i, 50*j);
		/*			    Graphics2D g2d = (Graphics2D) g;
			    AffineTransform tx = new AffineTransform();
			    double x = 150;
			    double y = .2;
			    tx.translate(x, y);
			    g2d.setTransform(tx);
			    g2d.drawImage(new ImageIcon("C:/Users/Vincent/Desktop/Vincent_APCS_Spring/Chess/blackKnight.png").getImage(), tx, this);
			    x=-125;
			    tx.translate(x, y);
			    g2d.setTransform(tx);
			    g2d.drawImage(new ImageIcon("C:/Users/Vincent/Desktop/Vincent_APCS_Spring/Chess/blackKnight.png").getImage(), tx, this);
		 */	}
	public void paint(Graphics g, int x, int y){
		if ((x/50*50%100==0&&y/50*50%100==0)||(x/50*50%100!=0 && y/50*50%100!=0))
			g.setColor(Color.black);
		else
			g.setColor(Color.white);
		g.fillRect(x/50*50, y/50*50, 50, 50);
	}
	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {

		mouseX=e.getX();
		mouseY=e.getY();
		int row=mouseX/50;
		int col=mouseY/50;
		//System.out.println(mouseX+"  "+mouseY);
		//get the chesspiece		
		changing= board [row][col];

		//delete the chesspiece
	}
	public void mouseReleased(MouseEvent e) {
		if((whiteTurn&&changing instanceof WhitePiece)||(!whiteTurn&&!(changing instanceof WhitePiece))){//whose turn
			if(changing.validMove(e.getX()/50, e.getY()/50, mouseX/50, mouseY/50)){ //is it valid 
				if(changing instanceof WhitePiece && !(board[e.getX()/50][e.getY()/50] instanceof WhitePiece)
				|| !(changing instanceof WhitePiece) && ((board[e.getX()/50][e.getY()/50] instanceof WhitePiece) ||(board[e.getX()/50][e.getY()/50] instanceof BlankPiece))){
				//if king is not checked after movement
				paint(getGraphics(), mouseX, mouseY);
				board[mouseX/50][mouseY/50]= new BlankPiece();
				mouseX=e.getX();
				mouseY=e.getY();
				//checking if any other piece has a validMove on the king after the king has moved
				/*if (changing instanceof WhiteKing || changing instanceof BlackKing){
					for (int i = 0; i < 7; i ++){
						for (int j = 0; j < 7; j++){
							if (board[i][j].validMove(e.getX()/50, e.getY()/50,i,j)){
								
							}
						}
					}
					
				}*/
				int row=mouseX/50;
				int col=mouseY/50;
				changing.print().paintIcon(this, getGraphics(), 50*row, 50*col);
				System.out.println(mouseX+"  "+mouseY);
				board[row][col]=changing;
				if(changing instanceof WhitePawn && ((WhitePawn)(board[row][col])).doingPassant){
					paint(getGraphics(), 50*row, 50 *(col+1));
					((WhitePawn)(board[row][col])).doingPassant=false;
				}
				if(changing instanceof BlackPawn && ((BlackPawn)(board[row][col])).doingPassant){
					paint(getGraphics(), 50*row, 50 *(col-1));
					((BlackPawn)(board[row][col])).doingPassant=false;
				}
	/*			for(int i=0;i<8;i++){
					for (int j=1;j<7;j++){
						if(board[i][j] instanceof BlackPawn && whiteTurn)
							((BlackPawn)(board[i][j])).enPeasant=false;
						if (board[i][j] instanceof WhitePawn && !whiteTurn)
							((WhitePawn)(board[i][j])).enPeasant=false;
					}
				}*/
				if(!whiteTurn)
					whiteTurn=true;
				else
					whiteTurn=false;
				}

		}
	}
}
}
