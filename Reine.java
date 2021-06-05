public class Reine extends Piece{

	// Déclaration d'instances
	
	private String propriete;
		
	// Getter et Setter 
	
	public String getPropriete() {
		return propriete;
	}

	public void setPropriete(String propriete) {
		this.propriete = propriete;
	}
	
	// Constructeur vide
	
	public Reine()
	{
		super();
		this.propriete = this.couleurreine();

	}
		
	// Constructeur champs à champs avec les informations de Piece
		
	public Reine(int ligne, int colonne, int couleur)
	{
		super(ligne,colonne,couleur);
		this.propriete = this.couleurreine();
	}
		
	// Méthode pour les constructions et connaître la couleur du Reine
		
	public String couleurreine() {
		String s;
		if(this.getCouleur() == 0)
		        s = "\u265B";
	      else
		        s = "\u2655";
		return s;
			
		}
	
	public String toString()
	{
		return super.toString() + " et la piece ressemble à ça: " + this.propriete;
	}
	
	public boolean  verifDeplacement(Echiquier e,Case arrive) {
		Case depart = e.getCase(this.getLigne(), this.getColonne());
		
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
				int i = arrive.getLigne();
			int j = arrive.getColonne();
			if(depart.getLigne()>i && depart.getColonne()<j)  //en haut a droite
			{
				int x = depart.getLigne() - 1;
				int y = depart.getColonne() + 1;
				
				if(!(e.getCase(x, y).CaseVide())) 
					return false;
				
				while(x > i && y < j)
				{
					if (!(e.estVide(e.getCase(x,y)) ))
						return false;
					x = x - 1;
					y = y + 1;
				}
			}
			else if(depart.getLigne()>i && depart.getColonne()>j) {//en haut a gauceh
				int x = depart.getLigne() - 1;
				int y = depart.getLigne() - 1;
				if(!(e.getCase(x, y).CaseVide())) 
					return false;
				
				while(x > i && y > j)
				{
					
					if (!(e.estVide(e.getCase(x,y)) ))
						return false;
					x = x - 1;
					y = y - 1;
				}
				
			}
			else if (depart.getLigne()<i && depart.getColonne()>j) {//en bas a gauche
				int x = depart.getLigne() + 1;
				int y = depart.getColonne() - 1;	
				if(!(e.getCase(x, y).CaseVide())) 
					return false;
				while(x < i && y > j)
				{
					if (!(e.estVide(e.getCase(x,y)) ))
						return false;
					x = x + 1;
					y = y - 1;
				}
				
			}
			else if (depart.getLigne()<i && depart.getColonne()<j) {//en bas a droite
				int x = depart.getLigne() + 1;
				int y = depart.getColonne() + 1;
				
				if(!(e.getCase(x, y).CaseVide())) 
					return false;
				while(x < i && y < j)
				{
					if (!(e.estVide(e.getCase(x,y)) ))
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
		if(arrive.getLigne()>depart.getLigne())
		{
			for(int i=depart.getLigne()+1; i<arrive.getLigne();i++) 
			{
				System.out.println("Case, i"+i+e.getCase(i, depart.getColonne()));
				if(!(e.getCase(i, depart.getColonne()).CaseVide()))
					return false;
			}
			
		}else 
			for(int i=arrive.getLigne()+1; i<depart.getLigne();i++) 
			{
				System.out.println("Case, i"+i+e.getCase(i, depart.getColonne()));
				if(!(e.getCase(i, depart.getLigne()).CaseVide()))
					return false;
			}
		
		if(super.memeCouleur(depart, arrive))
			return false;
		
		return true;
	}
	
	public boolean boucleLigne(Echiquier e, Case depart, Case arrive) {
		if(arrive.getColonne()>depart.getColonne())
		{
			for(int j=depart.getColonne()+1; j<arrive.getColonne();j++) {
				System.out.println("Case, j"+j+e.getCase(depart.getLigne(),j));
				if(!(e.getCase(depart.getLigne(),j).CaseVide()))
					return false;
			}
		}else
			for(int j=arrive.getColonne()+1; j<depart.getColonne();j++) {
				System.out.println("Case, j"+j+e.getCase(depart.getLigne(),j));
				if(!(e.getCase(depart.getLigne(),j).CaseVide()))
					return false;
			}
		if(super.memeCouleur(depart, arrive))
				return false;
		
		return true;
	}
	

}
