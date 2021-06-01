//Le Cavalier se déplace en L, deux cases dans une direction (horizontalement ou verticalement),
//	puis d'une case perpendiculairement.
//		Il est le seul à pouvoir sauter par-dessus une pièce lors de son mouvement (ainsi que la Tour mais seulement lors du roque).

public class Cavalier  extends Piece
{
	private String forme;

	public Cavalier()
	{
		super();
		if(this.getCouleur() == 0)
		{
			this.forme = "\u265E";					// si la pièce est noire
		}
		else
		{
			this.forme = "\u2658";					// si la pièce est blanche
		}
	}

	public Cavalier(int ligne, int colonne, int coul)
	{
		super(ligne,colonne,coul);
		if(this.getCouleur() == 0)
		{
			this.forme = "\u265E";					// si la pièce est noire
		}
		else
		{
			this.forme = "\u2658";					// si la pièce est blanche
		}
	}

	public String getForme()
	{
		return this.forme;
	}

	public void deplacerPiece()
	{
	}


	public boolean verifDeplacement(Echiquier e, Case arrive)
	{
		int departX = this.getPosX();
		int departY = this.getPosY();
		int i = arrive.getPosX();
		int j = arrive.getPosY();

		if( Math.abs(departX - i) == 2 && Math.abs(departY - j) == 1 || Math.abs(departX - i) == 1 && Math.abs(departY - j) ==2 )
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
		return super.toString() + " et la piece a la forme " + this.forme;
	}
}
