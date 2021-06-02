//Le Fou se déplace d'un nombre quelconque de cases en diagonale sans pouvoir sauter une pièce.
//	Il y a un fou sur cases blanches (appelé « blanc », peu importe la couleur des pièces) et un fou sur cases noires (appelé « noir »),
//		ce nom leur vient de leur case de départ, et du fait que leur déplacement ne peut se faire que sur des cases de cette couleur.
import java.math.*;
public class Fou extends Piece
{
	private String propriete;

	public Fou()
	{
		super();
		if(this.getCouleur() == 0)
		{
			this.propriete = "\u265D";					// si la pièce est noire
		}
		else
		{
			this.propriete = "\u2657";					// si la pièce est blanche
		}
	}

	public Fou(int ligne, int colonne, int coul)
	{
		super(ligne,colonne,coul);
		if(this.getCouleur() == 0)
		{
			this.propriete = "\u265D";					// si la pièce est noire
		}
		else
		{
			this.propriete = "\u2657";					// si la pièce est blanche
		}
	}

	public String getpropriete()
	{
		return this.propriete;
	}


	public void deplacer()
	{
	}

	//Si la piece est un fou
	//Si il n'y a personne dur ma diagonale et si la case désigné et une caseVide : True

	public boolean coupPossible(Echiquier e, Case arrive)
	{
		int i = arrive.getPosLigne();
		int j = arrive.getPosColonne();
		boolean p = false;
		int departLigne = this.getPosLigne();	// position x de la piece
		int departColonne = this.getPosColonne();	// position y de la piece
		int dest = i - departLigne;
		int fin = j - departColonne;
		dest = Math.abs(dest);
		fin = Math.abs(fin);
		if (e.etatCase(e.getCase(i,j)) == false && e.getCase(i,j).getPiece().getCouleur() == this.getCouleur() || dest != fin)
		{
			return p;
		}
		else if (departLigne > i && departColonne < j)
		{
			return this.coupPossibleDhd(e,i,j,departLigne,departColonne);
		}
		else if (departLigne > i && departColonne > j)
		{
			return this.coupPossibleDhg(e,i,j,departLigne,departColonne);
		}
		else if (departLigne < i && departColonne < j)
		{
			return this.coupPossibleGbd(e,i,j,departLigne,departColonne);
		}
		else if (departLigne < i && departColonne > j)
		{
				return this.coupPossibletGbg(e,i,j,departLigne,departColonne);
		}
		return p;
	}
	// verifiez deplacement Diagonale haut droit
	public boolean coupPossibleDhd(Echiquier e, int i, int j, int departLigne, int departColonne)
	{
		boolean p = false;
		departLigne = departLigne - 1;
		departColonne = departColonne + 1;
		if (departLigne == i && departColonne == j) {
			return true;
		}
		while (departLigne > i || departColonne < j)
		{
			// si case libre
			if (e.etatCase(e.getCase(departLigne,departColonne)))
			{
				p = true;
			}
			// si la case contient une piece
			else if (e.etatCase(e.getCase(departX,departY)) == false)
			{
				return false;
			}
			departLigne = departLigne - 1;
			departColonne = departColonne + 1;
		}
		return p;
	}
	// verifier deplacement Diagonale haut gauche
	public boolean coupPossibleDhg(Echiquier e, int i, int j, int departLigne, int departColonne)
	{
		boolean p = false;
		departLigne = departLigne - 1;
		departColonne = departColonne - 1;
		if (departColonne == i && departColonne == j) {
			return true;
		}
		while(departLigne > i || departColonne > j)
		{
			// si case libre
			if (e.etatCase(e.getCase(departLigne,departColonne)))
			{
				p = true;
			}
			// si la case contient une piece
			else if (e.etatCase(e.getCase(departLigne,departColonne)) == false)
			{
				return false;
			}
			departLigne = departLigne - 1;
			departColonne = departColonne - 1;
		}
		return p;
	}
	// verifier deplacement Diagonale bas droit
	public boolean coupPossibleGbd(Echiquier e, int i, int j, int departLigne, int departColonne)
	{
		boolean p = false;
		departLigne = departLigne + 1;
		departColonne = departColonne + 1;
		if (departLigne == i && departColonne == j) {
			return true;
		}
		while(departLigne < i || departColonne < j)
		{
			// si case libre
			if (e.etatCase(e.getCase(departLigne,departColonne)))
			{
				p = true;
			}
			// si la case contient une piece
			else if (e.etatCase(e.getCase(departLigne,departColonne)) == false)
			{
				return false;
			}
			departLigne = departLigne + 1;
			departColonne = departColonne + 1;
		}
		return p;
	}
	// verifier deplacement Diagonale bas gauche
	public boolean coupPossibleGbg(Echiquier e, int i, int j, int departLigne, int departColonne)
	{
		boolean p = false;
		departLigne = departLigne + 1;
		departColonne = departColonne - 1;
		if (departLigne == i && departColonne == j) {
			return true;
		}
		while(departLigne < i || departColonne > j)
		{
			// si case libre
			if (e.etatCase(e.getCase(departLigne,departColonne)))
			{
				p = true;
			}
			// si la case contient une piece
			else if (e.etatCase(e.getCase(departLigne,departColonne)) == false)
			{
				return false;
			}
			departLigne = departLigne + 1;
			departColonne = departColonne - 1;
		}
		return p;
	}
	
	public String toString()
	{
		return super.toString() + " et la piece a les propriétes suivantes " + this.propriete;
	}
} // Fin de la class Fou
