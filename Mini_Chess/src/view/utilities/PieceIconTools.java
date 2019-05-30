package view.utilities;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import model.piece.Bishop;
import model.piece.Piece;
import model.piece.Rook;

public class PieceIconTools {
	// return an ImageIcon based on a piece and an overriding color
	// used when a piece's color may be null (off board)
	public static ImageIcon pieceToImageIcon(Piece piece, String color) {
		return new ImageIcon(pieceToPath(piece, color));
	}

	// return the path of the image based on a piece with an overriding color
	public static String pieceToPath(Piece piece, String color) {
		String path = "";
		if (piece != null) {
			String colorCode;
			String type;
			// first character of filename is based on color
			if (color == "white") {
				colorCode = "W";
			} else {
				colorCode = "B";
			}
			// second character is based on piece type
			if (piece instanceof Rook) {
				type = "R";
			} else if (piece instanceof Bishop) {
				type = "B";
			} else {
				type = "K";
			}
			// path includes file separator and ".png"
			path = "pieceImages" + File.separator + colorCode + type + ".png";
		}
		return path;
	}

	// return an ImageIcon from a piece (default colour used)
	public static ImageIcon pieceToImageIcon(Piece piece) {
		return new ImageIcon(pieceToPath(piece));

	}

	// return a path of image for a piece with its existing color
	public static String pieceToPath(Piece piece) {
		String path = "";
		if (piece != null) {
			path = pieceToPath(piece, piece.getColor());
		}
		return path;

	}

	// return a half-sized ImageIcon for an existing ImageIcon
	public static ImageIcon getScaledImage(ImageIcon icon) {
		Image tempImage = icon.getImage();
		// halve width and height
		int newWidth = (int) (icon.getIconWidth() * 0.5);
		int newHeight = (int) (icon.getIconHeight() * 0.5);
		Image scaledImage = tempImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImage);
	}
}
