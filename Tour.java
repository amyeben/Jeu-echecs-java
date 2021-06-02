//La tour se déplace d'un nombre quelconque de cases horizontalement
//	ou verticalement et peut sauter seulement par-dessus le Roi lors du roque.
import java.math.*;
public class Tour extends Piece
{
	private String propriete;

	public Tour()
	{
		super();
		if(this.getCouleur() == 0)
		{
			this.propriete = "\u265C";					// si la pièce est noire
		}
		else
		{
			this.propriete = "\u2656";					// si la pièce est blanche
		}

	}
	public Tour(int ligne, int colonne, int coul)
	{
		super(ligne,colonne,coul);
		if(this.getCouleur() == 0)
		{
			this.propriete = "\u265C";					// si la pièce est noire
		}
		else
		{
			this.propriete = "\u2656";					// si la pièce est blanche
		}
	}

	public String getPropriete()
	{
		return this.propriete;
	}

	public void deplacer()
	{
	}

	//Si la piece est une Tour
	//Si il n'y a personne devant moi ou a coté et si la case désigné est une caseVide : True
	public boolean coupPossible(Echiquier e, Case arrive)
	{
		int departLigne = this.getPosLigne();
		int departColonne = this.getPosColonne();
		int i = arrive.getPosLigne();
		int j = arrive.getPosColonne();

		if(Math.abs(departLigne - i) <= 8 && Math.abs(departColonne - j) == 0 || Math.abs(departLigne - i ) == 0 && Math.abs(departColonne - j) <=8 )
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	public String toString()
	{
		return super.toString() + " et la piece a les propriétés suivantes: " + this.propriete;
	}

}
