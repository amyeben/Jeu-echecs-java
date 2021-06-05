
public class Pion extends Piece{
	
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

	
	public Pion()
	{
		super();
		this.propriete = this.couleurpion();

	}
		
	// Constructeur champs à champs avec les informations de Piece
		
	public Pion(int ligne, int colonne, int couleur)
	{
		super(ligne,colonne,couleur);
		this.propriete = this.couleurpion();
	}
		
	// Méthode pour les constructions et connaître la couleur de la Pion
		
	public String couleurpion() {
		String s;
		if(this.getCouleur() == 0)
		        s = "\u265F";
	      else
		        s = "\u2659";
		return s;
			
		}
	
	// Manque méthode coup possible, et déplacement
	
	public String toString()
	{
		return super.toString() + " et la piece ressemble à ça: " + this.propriete;
	}

	public boolean verifDeplacement (Echiquier e, Case arrive)
	{
		Case depart=e.getCase(this.getLigne(), this.getColonne());
		if(e.estVide(arrive))
		{
			if(this.positionInitialePion())
			{
				System.out.println("position Initiale" + depart.getP().getCouleur());
				if(depart.caseDevant(arrive))
					//System.out.println("Pos initiale + devant ok");
					return true;
				/*
				if(arrive.getPosX()>depart.getPosX()+2)
					return false;
					*/
				System.out.println("test 2");
				if(depart.getP().getCouleur() == 0){
					if(arrive.equals(e.getCase(depart.getLigne()+2, depart.getColonne()))
							&& e.getCase(depart.getLigne()+1, depart.getColonne()).CaseVide())
						//System.out.println("case vide devant + ok");
						return true;
				}
				else{
					System.out.println("test 3");
					if(arrive.equals(e.getCase(depart.getLigne()-2, depart.getColonne()))
							&& e.getCase(depart.getLigne()-1, depart.getColonne()).CaseVide())
						System.out.println("case vide devant + ok");

						return true;}
			}
			else
			{

				if(depart.caseDevant(arrive))
					//System.out.println("devant ok");
					return true;

				if(arrive.getLigne()>depart.getLigne()+1 || arrive.getLigne()>depart.getLigne()-1)
					return false;
			}
		}
		//Pour le cas de manger
		else
			if(depart.mangerpiece(arrive))
			return true;

		return false;
			
	}
	public boolean positionInitialePion() {

		if(this.getCouleur() == 0)
		{
			for (int j = 0; j < 8 ; j++)
			{
					if(this.getLigne() == 1 && this.getColonne() == j)
						return true;
			}

		}else
		{
			for (int j = 0; j < 8 ; j++)
			{
				if(this.getLigne() == 6 && this.getColonne() == j)
					return true;
			}

		}
		return false;
	}
	
	
}
