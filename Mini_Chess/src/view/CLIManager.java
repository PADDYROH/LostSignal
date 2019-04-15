package view;

public class CLIManager implements UserInterfaceManager {
	private int boardwidth;
	private int boardlength;

	public CLIManager(int boardlength,  int boardwidth) {

	this.boardlength = boardlength;
	this.boardwidth = boardwidth;
	
	//piece.rook()
	//piece.getpiece()	
	
		String[][] chess = new String[boardwidth][boardlength];
		for (int row = 0; row < boardwidth; row++) {
			System.out.println("");
			System.out.println("_____________________________________");
			for (int column = 0; column < boardwidth; column++) {
				if( /*piece position */ = chess[row][column]) {
				System.out.print("| "+ "*"+ "   ");
				}else{
					System.out.print("| "+ " "+ "   ");	
				}
			}
				System.out.println("|");
		}
		System.out.println(" ");
		System.out.println("_____________________________________");
	}

	public void getPiece() {
		//return this.Piece;
	}

	public void getGameBoard() {

	}

	public void getchessbardarray() {

	}
}
