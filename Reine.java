//La Reine se déplace d'un nombre quelconque de cases verticalement, horizontalement et en diagonale sans pouvoir sauter une pièce.

public class Reine extends Piece
{
	private String propriete;

	public Reine()
	{
		super();
		if(this.getCouleur() == 0)		// si la pièce est noire
			this.propriete = "\u265B";
		else							// si la pièce est blanche
			this.propriete = "\u2655";
	}

	public Reine(int ligne, int colonne, int coul)
	{
		super(ligne,colonne,coul);
		if(this.getCouleur() == 0)
			this.propriete = "\u265B";			// si la pièce est noire
		else
			this.propriete = "\u2655";			// si la pièce est blanche
	}

	public String getpropriete()
	{
		return this.propriete;
	}

	public boolean coupPossible (Echiquier e,Case arrive) {
		Case depart = e.getCase(this.getPosLigne(), this.getPosColonne());
		
		if(depart.memeColonne(arrive)) 
			if(this.boucleColonne(e, depart, arrive))
				return true;
				
		if(depart.memeLigne(arrive)) 
			if(this.boucleLigne(e, depart, arrive))
				return true;
		
		if(this.boucleDiagonale(e, depart, arrive))
			return true;
		
		return false;
				
	}
	
	
public boolean boucleDiagonale(Echiquier e,Case depart, Case arrive)
	{
				int i = arrive.getPosLigne();
			int j = arrive.getPosColonne();
			if(depart.getPosLigne()>i && depart.getPosColonne()<j)  //en haut a droite
			{
				int x = depart.getPosLigne() - 1;
				int y = depart.getPosColonne() + 1;
				
				if(!(e.getCase(x, y).estVide())) 
					return false;
				
				while(x > i && y < j)
				{
					if (!(e.etatCase(e.getCase(x,y)) ))
						return false;
					x = x - 1;
					y = y + 1;
				}
			}
			else if(depart.getPosLigne()>i && depart.getPosColonne()>j) {//en haut a gauceh
				int x = depart.getPosLigne() - 1;
				int y = depart.getPosColonne() - 1;
				if(!(e.getCase(x, y).estVide())) 
					return false;
				
				while(x > i && y > j)
				{
					
					if (!(e.etatCase(e.getCase(x,y)) ))
						return false;
					x = x - 1;
					y = y - 1;
				}
				
			}
			else if (depart.getPosX()<i && depart.getPosY()>j) {//en bas a gauche
				int x = depart.getPosX() + 1;
				int y = depart.getPosY() - 1;	
				if(!(e.getCase(x, y).estVide())) 
					return false;
				while(x < i && y > j)
				{
					if (!(e.etatCase(e.getCase(x,y)) ))
						return false;
					x = x + 1;
					y = y - 1;
				}
				
			}
			else if (depart.getPosLigne()<i && depart.getPosColonne()<j) {//en bas a droite
				int x = depart.getPosLigne() + 1;
				int y = depart.getPosColonne() + 1;
				
				if(!(e.getCase(x, y).estVide())) 
					return false;
				while(x < i && y < j)
				{
					if (!(e.etatCase(e.getCase(x,y)) ))
						return false;
					x = x + 1;
					y = y + 1;
				}
				
			}
			
			if(super.memeCouleur(depart, arrive))

				return false;
		
		return true;
	}
	
	public boolean boucleColonne(Echiquier e, Case depart, Case arrive) {
		if(arrive.getPosLigne()>depart.getPosColonne())
		{
			for(int i=depart.getPosLigne()+1; i<arrive.getPosColonne();i++) 
			{
				System.out.println("Case, i"+i+e.getCase(i, depart.getPosColonne()));
				if(!(e.getCase(i, depart.getPosColonne()).estVide()))
					return false;
			}
			
		}else 
			for(int i=arrive.getPosLigne()+1; i<depart.getPosLigne();i++) 
			{
				System.out.println("Case, i"+i+e.getCase(i, depart.getPosColonne()));
				if(!(e.getCase(i, depart.getPosColonne()).estVide()))
					return false;
			}
		
		if(super.memeCouleur(depart, arrive))
			return false;
		
		return true;
	}
	
	public boolean boucleLigne(Echiquier e, Case depart, Case arrive) {
		if(arrive.getPosColonne()>depart.getPosColonne())
		{
			for(int j=depart.getPosColonne()+1; j<arrive.getPosColonne();j++) {
				System.out.println("Case, j"+j+e.getCase(depart.getPosLigne(),j));
				if(!(e.getCase(depart.getPosLigne(),j).estVide()))
					return false;
			}
		}else
			for(int j=arrive.getPosColonne()+1; j<depart.getPosColonne();j++) {
				System.out.println("Case, j"+j+e.getCase(depart.getPosLigne(),j));
				if(!(e.getCase(depart.getPosLigne(),j).estVide()))
					return false;
			}
		if(super.memeCouleur(depart, arrive))
				return false;
		
		return true;
	}
	public String toString()
	{
		return super.toString() + " et la piece a les propriétés suivantes: " + this.propriete;
	}

}
