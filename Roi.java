//Le Roi se déplace d'une seule case dans toutes les directions et de deux cases lors du roque.
import java.math.*;

public class Roi  extends Piece
{

	private String propriete;

	public Roi()
	{
		super();
		if(this.getCouleur() == 0)
			this.propriete = "\u265A";				// si la pièce est noire
		else
			this.propriete = "\u2654";				// si la pièce est blanche
	}

	public Roi(int ligne, int colonne, int coul)
	{
		super(ligne,colonne,coul);
		if(this.getCouleur() == 0)
			this.propriete = "\u265A";				// si la pièce est noire
		else
			this.propriete = "\u2654";				// si la pièce est blanche
	}

	public String getPropriete()
	{
		return this.propriete;
	}

		public boolean hautDroite(Case depart, Case arrive)
	{
		if(arrive.getPosLigne()==depart.getPosLigne()-1 && arrive.getPosColonne()==depart.getPosColonne()+1)  //en haut à droite
			return true;
		return false;
	}

	public boolean hautGauche(Case depart, Case arrive) {
		if(arrive.getPosLigne()==depart.getPosLigne()-1 && arrive.getPosColonne()==depart.getPosColonne()-1) //en haut à gauche 
			return true;
		return false;

	}
  
  public boolean basDroite(Case depart, Case arrive) {
		if (arrive.getPosLigne()==depart.getPosLigne()+1 && arrive.getPosColonne()==depart.getPosColonne()+1) //en bas à droite
			return true;
		return false;
	}
  
	public boolean basGauche(Case depart, Case arrive) {
		if (arrive.getPosLigne()==depart.getPosLigne()+1 && arrive.getPosColonne()==depart.getPosColonne()-1) //en bas à gauche
			return true;
		return false;
	}



	public boolean memeLigne(Case depart, Case arrive) {
		if(depart.memeLigne(arrive)) {
			if(arrive.getPosColonne() == depart.getPosColonne()-1)
				return true;
			else if(arrive.getPosColonne() == depart.getPosColonne()+1)
				return true;
		}
		return false;
	}

	public boolean memeColonne(Case depart, Case arrive) {
		if(depart.memeColonne(arrive)) {
			if(arrive.getPosLigne() == depart.getPosLigne()-1)
				return true;
			else if(arrive.getPosLigne() == depart.getPosLigne()+1)
				return true;
		}
		return false;
	}


	/*
	 * les case autours
	 */
	public boolean coupPossible(Echiquier e, Case arrive)
	{
		Case depart = e.getCase(this.getPosLigne(), this.getPosColonne());
		System.out.println("couleur de départ " + depart.getPiece().getCouleur() + " et couleur d'arrivée " + arrive.getPiece().getCouleur());
		if(!(this.memeColonne(depart, arrive)) && arrive.getPiece().getCouleur() == depart.getPiece().getCouleur())
			return false;

		if(!(this.memeLigne(depart, arrive)) && arrive.getPiece().getCouleur() == depart.getPiece().getCouleur())
			return false;

		if(!(this.hautDroite(depart, arrive)))
			return false;

		if(!(this.hautGauche(depart, arrive)))
			return false;

		if(!(this.basDroite(depart, arrive)))
			return false;

		if(!(this.basGauche(depart, arrive)))
			return false;

		if(super.memeCouleur(depart, arrive))
			return false;

		return true;
	}


	public String toString()
	{
		return super.toString() + " et la piece a les propriétes suivantes " + this.propriete;
	}

}
