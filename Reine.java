//La Reine se déplace d'un nombre quelconque de cases verticalement, horizontalement et en diagonale sans pouvoir sauter une pièce.

public class Reine extends Piece
{
	private String forme;

	public Reine()
	{
		super();
		if(this.getCouleur() == 0)		// si la pièce est noire
			this.forme = "\u265B";
		else							// si la pièce est blanche
			this.forme = "\u2655";
	}

	public Reine(int ligne, int colonne, int coul)
	{
		super(ligne,colonne,coul);
		if(this.getCouleur() == 0)
			this.forme = "\u265B";			// si la pièce est noire
		else
			this.forme = "\u2655";			// si la pièce est blanche
	}

	public String getForme()
	{
		return this.forme;
	}

	public boolean  verifDeplacement(Echiquier e,Case arrive) {
		Case depart = e.getCase(this.getPosX(), this.getPosY());
		
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
				int i = arrive.getPosX();
			int j = arrive.getPosY();
			if(depart.getPosX()>i && depart.getPosY()<j)  //en haut a droite
			{
				int x = depart.getPosX() - 1;
				int y = depart.getPosY() + 1;
				
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
			else if(depart.getPosX()>i && depart.getPosY()>j) {//en haut a gauceh
				int x = depart.getPosX() - 1;
				int y = depart.getPosY() - 1;
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
			else if (depart.getPosX()<i && depart.getPosY()<j) {//en bas a droite
				int x = depart.getPosX() + 1;
				int y = depart.getPosY() + 1;
				
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
		if(arrive.getPosX()>depart.getPosX())
		{
			for(int i=depart.getPosX()+1; i<arrive.getPosX();i++) 
			{
				System.out.println("Case, i"+i+e.getCase(i, depart.getPosY()));
				if(!(e.getCase(i, depart.getPosY()).estVide()))
					return false;
			}
			
		}else 
			for(int i=arrive.getPosX()+1; i<depart.getPosX();i++) 
			{
				System.out.println("Case, i"+i+e.getCase(i, depart.getPosY()));
				if(!(e.getCase(i, depart.getPosY()).estVide()))
					return false;
			}
		
		if(super.memeCouleur(depart, arrive))
			return false;
		
		return true;
	}
	
	public boolean boucleLigne(Echiquier e, Case depart, Case arrive) {
		if(arrive.getPosY()>depart.getPosY())
		{
			for(int j=depart.getPosY()+1; j<arrive.getPosY();j++) {
				System.out.println("Case, j"+j+e.getCase(depart.getPosX(),j));
				if(!(e.getCase(depart.getPosX(),j).estVide()))
					return false;
			}
		}else
			for(int j=arrive.getPosY()+1; j<depart.getPosY();j++) {
				System.out.println("Case, j"+j+e.getCase(depart.getPosX(),j));
				if(!(e.getCase(depart.getPosX(),j).estVide()))
					return false;
			}
		if(super.memeCouleur(depart, arrive))
				return false;
		
		return true;
	}
	public String toString()
	{
		return super.toString() + " et la piece a la forme " + this.forme;
	}

}
