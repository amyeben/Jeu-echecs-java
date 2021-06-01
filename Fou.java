//Le Fou se déplace d'un nombre quelconque de cases en diagonale sans pouvoir sauter une pièce.
//	Il y a un fou sur cases blanches (appelé « blanc », peu importe la couleur des pièces) et un fou sur cases noires (appelé « noir »),
//		ce nom leur vient de leur case de départ, et du fait que leur déplacement ne peut se faire que sur des cases de cette couleur.
import java.math.*;
public class Fou extends Piece
{
	private String forme;

	public Fou()
	{
		super();
		if(this.getCouleur() == 0)
		{
			this.forme = "\u265D";					// si la pièce est noire
		}
		else
		{
			this.forme = "\u2657";					// si la pièce est blanche
		}
	}

	public Fou(int ligne, int colonne, int coul)
	{
		super(ligne,colonne,coul);
		if(this.getCouleur() == 0)
		{
			this.forme = "\u265D";					// si la pièce est noire
		}
		else
		{
			this.forme = "\u2657";					// si la pièce est blanche
		}
	}

	public String getForme()
	{
		return this.forme;
	}

	public String toString()
	{
		return super.toString() + " et la piece a la forme " + this.forme;
	}


	public void deplacerPiece()
	{
	}

	//Si la piece est un fou
	//Si il n'y a personne dur ma diagonale et si la case désigné et une caseVide : True

	public boolean verifDeplacement(Echiquier e, Case arrive)
	{
		int i = arrive.getPosX();
		int j = arrive.getPosY();
		boolean p = false;
		int departX = this.getPosX();	// position x de la piece
		int departY = this.getPosY();	// position y de la piece
		int dest = i - departX;
		int fin = j - departY;
		dest = Math.abs(dest);
		fin = Math.abs(fin);
		if (e.etatCase(e.getCase(i,j)) == false && e.getCase(i,j).getPiece().getCouleur() == this.getCouleur() || dest != fin)
		{
			return p;
		}
		else if (departX > i && departY < j)
		{
			return this.verifDeplacementDhd(e,i,j,departX,departY);
		}
		else if (departX > i && departY > j)
		{
			return this.verifDeplacementDhg(e,i,j,departX,departY);
		}
		else if (departX < i && departY < j)
		{
			return this.verifDeplacementGbd(e,i,j,departX,departY);
		}
		else if (departX < i && departY > j)
		{
				return this.verifDeplacementGbg(e,i,j,departX,departY);
		}
		return p;
	}
	// verifiez deplacement Diagonale haut droit
	public boolean verifDeplacementDhd(Echiquier e, int i, int j, int departX, int departY)
	{
		boolean p = false;
		departX = departX - 1;
		departY = departY + 1;
		if (departX == i && departY == j) {
			return true;
		}
		while (departX > i || departY < j)
		{
			// si case libre
			if (e.etatCase(e.getCase(departX,departY)))
			{
				p = true;
			}
			// si la case contient une piece
			else if (e.etatCase(e.getCase(departX,departY)) == false)
			{
				return false;
			}
			departX = departX - 1;
			departY = departY + 1;
		}
		return p;
	}
	// verifier deplacement Diagonale haut gauche
	public boolean verifDeplacementDhg(Echiquier e, int i, int j, int departX, int departY)
	{
		boolean p = false;
		departX = departX - 1;
		departY = departY - 1;
		if (departX == i && departY == j) {
			return true;
		}
		while(departX > i || departY > j)
		{
			// si case libre
			if (e.etatCase(e.getCase(departX,departY)))
			{
				p = true;
			}
			// si la case contient une piece
			else if (e.etatCase(e.getCase(departX,departY)) == false)
			{
				return false;
			}
			departX = departX - 1;
			departY = departY - 1;
		}
		return p;
	}
	// verifier deplacement Diagonale bas droit
	public boolean verifDeplacementGbd(Echiquier e, int i, int j, int departX, int departY)
	{
		boolean p = false;
		departX = departX + 1;
		departY = departY + 1;
		if (departX == i && departY == j) {
			return true;
		}
		while(departX < i || departY < j)
		{
			// si case libre
			if (e.etatCase(e.getCase(departX,departY)))
			{
				p = true;
			}
			// si la case contient une piece
			else if (e.etatCase(e.getCase(departX,departY)) == false)
			{
				return false;
			}
			departX = departX + 1;
			departY = departY + 1;
		}
		return p;
	}
	// verifier deplacement Diagonale bas gauche
	public boolean verifDeplacementGbg(Echiquier e, int i, int j, int departX, int departY)
	{
		boolean p = false;
		departX = departX + 1;
		departY = departY - 1;
		if (departX == i && departY == j) {
			return true;
		}
		while(departX < i || departY > j)
		{
			// si case libre
			if (e.etatCase(e.getCase(departX,departY)))
			{
				p = true;
			}
			// si la case contient une piece
			else if (e.etatCase(e.getCase(departX,departY)) == false)
			{
				return false;
			}
			departX = departX + 1;
			departY = departY - 1;
		}
		return p;
	}

}
