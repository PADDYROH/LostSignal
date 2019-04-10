package view;

public class CLIManager implements UserInterfaceManager {
	private int boardwidth;
	private int boardlength;
	
	public CLIManager(int boardlength,  int boardwidth) {

	this.boardlength = boardlength;
	this.boardwidth = boardwidth;
	
		
		String[] chess = new String[boardlength];
		for (int row = 0; row < boardwidth; row++) {
			System.out.println("");
			System.out.println("____________");
			for (int column = 0; column < boardwidth; column++) {
				System.out.println("| "+ "CLIManager(piece.getposX, piece.getY)"+ "   ");
			}
				System.out.println("|");
		}
		System.out.println(" ");
		System.out.println("____________");
	}
}
