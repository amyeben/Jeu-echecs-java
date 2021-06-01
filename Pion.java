//Le Pion avance d'une case à la fois. Il se déplace d'une case en diagonale en prenant une pièce adverse.
//	S'il n'a pas encore bougé, il peut avancer de deux cases d'un coup, sans pouvoir sauter une pièce.
//		Lorsqu'il arrive à la dernière rangée, il est promu en une autre pièce (Cavalier, Fou, Tour ou Reine).

public class Pion  extends Piece
{
	private String forme;

	public Pion()
	{
		super();
		if(this.getCouleur() == 0)
		{
			this.forme = "\u265F";					// si la pièce est noire
		}
		else
		{
			this.forme = "\u2659";					// si la pièce est blanche
		}
	}

	public Pion(int ligne, int colonne, int coul)
	{
		super(ligne,colonne,coul);
		if(this.getCouleur() == 0)
		{
			this.forme = "\u265F";					// si la pièce est noire
		}
		else
		{
			this.forme = "\u2659";					// si la pièce est blanche
		}
	}

	public String getForme() {
		return this.forme;
	}

	/*
	 * la case d'arrive peut être seulement :
	 * ----> la case de devant
	 * ----> la case +2 par rapport a la depart
	 * 		ssi depart = posInitiale
	 * 		et ssi depart+1 = vide
	 * 	ARRIVE devant DEPART
	 */

	public boolean verifDeplacement (Echiquier e, Case arrive)
	{
		Case depart=e.getCase(this.getPosX(), this.getPosY());
		if(e.etatCase(arrive))
		{
			if(this.positionInitialePion())
			{
				System.out.println("position Initiale" + depart.getPiece().getCouleur());
				if(depart.caseDevant(arrive))
					//System.out.println("Pos initiale + devant ok");
					return true;
				/*
				if(arrive.getPosX()>depart.getPosX()+2)
					return false;
					*/
				System.out.println("test 2");
				if(depart.getPiece().getCouleur() == 0){
					if(arrive.equals(e.getCase(depart.getPosX()+2, depart.getPosY()))
							&& e.getCase(depart.getPosX()+1, depart.getPosY()).estVide())
						//System.out.println("case vide devant + ok");
						return true;
				}
				else{
					System.out.println("test 3");
					if(arrive.equals(e.getCase(depart.getPosX()-2, depart.getPosY()))
							&& e.getCase(depart.getPosX()-1, depart.getPosY()).estVide())
						System.out.println("case vide devant + ok");

						return true;}
			}
			else
			{

				if(depart.caseDevant(arrive))
					//System.out.println("devant ok");
					return true;

				if(arrive.getPosX()>depart.getPosX()+1 || arrive.getPosX()>depart.getPosX()-1)
					return false;
			}
		}
		//Pour le cas de manger
		else
			if(depart.manger(arrive))
			return true;

		return false;
			//System.out.println("arrive pas vide");
	}
	public boolean positionInitialePion() {

		if(this.getCouleur() == 0)
		{
			for (int j = 0; j < 8 ; j++)
			{
					if(this.getPosX() == 1 && this.getPosY() == j)
						return true;
			}

		}else
		{
			for (int j = 0; j < 8 ; j++)
			{
				if(this.getPosX() == 6 && this.getPosY() == j)
					return true;
			}

		}
		return false;
	}
	public String toString()
	{
		return super.toString() + " et la piece a la forme " + this.forme;
	}

}
