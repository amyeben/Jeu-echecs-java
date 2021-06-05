public class Roi extends Piece{

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
	
	public Roi()
	{
		super();
		this.propriete = this.couleurroi();

	}
		
	// Constructeur champs à champs avec les informations de Piece
		
	public Roi(int ligne, int colonne, int couleur)
	{
		super(ligne,colonne,couleur);
		this.propriete = this.couleurroi();
	}
		
	// Méthode pour les constructions et connaître la couleur du Cavalier
		
	public String couleurroi() {
		String s;
		if(this.getCouleur() == 0)
		        s = "\u265A";
	      else
		        s = "\u2654";
		return s;
			
		}
	
	public String toString()
	{
		return super.toString() + " et la piece ressemble à ça: " + this.propriete;
	}

	
	//Méthode trouvez grâce nos recherches
	
	public boolean hautDroite(Case d, Case a)
	{
		if(a.getLigne()==d.getLigne()-1 && a.getColonne()==d.getColonne()+1)  //en haut à droite
			return true;
		return false;
	}
	
	public boolean hautGauche(Case d, Case a) {
		if(a.getLigne()==d.getLigne()-1 && a.getColonne()==d.getColonne()-1) //en haut à gauche 
			return true;
		return false;

	}
  
  public boolean basDroite(Case d, Case a) {
		if (a.getLigne()==d.getLigne()+1 && a.getColonne()==d.getColonne()+1) //en bas à droite
			return true;
		return false;
	}
  
	public boolean basGauche(Case d, Case a) {
		if (a.getLigne()==d.getLigne()+1 && a.getColonne()==d.getColonne()-1) //en bas à gauche
			return true;
		return false;
	}



	public boolean memeLigne(Case d, Case a) {
		if(d.memeLigne(a)) {
			if(a.getColonne() == d.getColonne()-1)
				return true;
			else if(a.getColonne() == d.getColonne()+1)
				return true;
		}
		return false;
	}

	public boolean memeColonne(Case d, Case a) {
		if(d.memeColonne(a)) {
			if(a.getLigne() == d.getLigne()-1)
				return true;
			else if(a.getLigne() == d.getLigne()+1)
				return true;
		}
		return false;
	}

	public boolean coupPossible(Echiquier e, Case a)
	{
		Case d = e.getCase(this.getLigne(), this.getColonne());
		System.out.println("couleur de départ " + d.getP().getCouleur() + " et couleur d'arrivée " + a.getP().getCouleur());
		if(!(this.memeColonne(d, a)) && a.getP().getCouleur() == d.getP().getCouleur())
			return false;

		if(!(this.memeLigne(d, a)) && a.getP().getCouleur() == d.getP().getCouleur())
			return false;

		if(!(this.hautDroite(d, a)))
			return false;

		if(!(this.hautGauche(d, a)))
			return false;

		if(!(this.basDroite(d, a)))
			return false;

		if(!(this.basGauche(d, a)))
			return false;

		if(super.memeCouleur(d, a))
			return false;

		return true;
	}


}
