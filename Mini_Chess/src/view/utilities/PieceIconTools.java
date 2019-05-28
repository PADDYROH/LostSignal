package view.utilities;

import java.io.File;

import javax.swing.ImageIcon;

import model.piece.Bishop;
import model.piece.Piece;
import model.piece.Rook;

public class PieceIconTools {
	public static ImageIcon pieceToImageIcon(Piece piece, String color) {
		// TODO Auto-generated method stub
		return new ImageIcon(pieceToPath(piece, color));
	}
		
	public static String pieceToPath(Piece piece, String color) {
		String path = "";
		if(piece != null) {
			String colorCode;
			String type;
			if(color == "white") {
				colorCode = "W";
			} else {
				colorCode = "B"; 
			}
			if(piece instanceof Rook) {
				type = "R";
			} else if (piece instanceof Bishop) {
				type = "B";
			} else {
				type = "K";
			}
			
			path = "pieceImages" + File.separator + colorCode + type + ".png";
		}
		return path;
	}

	public static ImageIcon pieceToImageIcon(Piece piece) {
		return new ImageIcon(pieceToPath(piece));
	
	}
	
	public static String pieceToPath(Piece piece) {
		String path = "";
		if(piece != null) {
			path = pieceToPath(piece, piece.getColor());
		}
		return path;
		
	}
}
