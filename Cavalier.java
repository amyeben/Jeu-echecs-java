//Le Cavalier se déplace en L, deux cases dans une direction (horizontalement ou verticalement),
//	puis d'une case perpendiculairement.
//		Il est le seul à pouvoir sauter par-dessus une pièce lors de son mouvement (ainsi que la Tour mais seulement lors du roque).

public class Cavalier  extends Piece
{
	private String propriete;

	public Cavalier()
	{
		super();
		if(this.getCouleur() == 0)
		{
			this.propriete = "\u265E";					// si la pièce est noire
		}
		else
		{
			this.propriete = "\u2658";					// si la pièce est blanche
		}
	}

	public Cavalier(int ligne, int colonne, int coul)
	{
		super(ligne,colonne,coul);
		if(this.getCouleur() == 0)
		{
			this.propriete = "\u265E";					// si la pièce est noire
		}
		else
		{
			this.propriete = "\u2658";					// si la pièce est blanche
		}
	}

	public String getpropriete()
	{
		return this.propriete;
	}

	public void deplacer()
	{
	}


	public boolean coupPossible(Echiquier e, Case arrive)
	{
		int departLigne = this.getPosLigne();
		int departColonne = this.getPosColonne();
		int i = arrive.getPosLigne();
		int j = arrive.getPosColonne();

		if( Math.abs(departLigne - i) == 2 && Math.abs(departColonne - j) == 1 || Math.abs(departLigne - i) == 1 && Math.abs(departColonne - j) ==2 )
		{
			return true;
		}

		else
		{
			return false;
		}


		/* Vérifie tout les points en L :
		si on prend la piece a déplacer comme orgine on a (i,j) (abscisse,ordonné) :
		(1,2) (2,1) (2,-1) (1,-2) (-1,-2) (-2,-1) (-2,1) (-1,2)
		Ou bien si le cavalier est sur une case blanche alors
		il peut se déplacer dans toutes les cases noir du deuxieme carré qui l'encercle
		*: ou je peux me déplacer
				_____________
				|B  * B *  B|
				|* |B N B| *|
				|B |N C N| B|
				|* |B N B| *|
				|B  * B *  B|
	*/
	}

	public String toString()
	{
		return super.toString() + " et la piece a les propriétes suivantes " + this.propriete;
	}
}
