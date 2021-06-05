public class Piece {
	
//	Declaration des instances
	
	private int couleur; 
	private int ligne;
	private int colonne;

// Getters et Setters

	public int getCouleur() {
		return couleur;
	}


	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}


	public int getLigne() {
		return ligne;
	}


	public void setLigne(int ligne) {
		this.ligne = ligne;
	}


	public int getColonne() {
		return colonne;
	}


	public void setColonne(int colonne) {
		this.colonne = colonne;
	}
	
	public void setLetC(int ligne, int colonne) {
	    this.setLigne(ligne);
	    this.setColonne(colonne);
	  }
	
// Constructeur vide 
	
	public Piece(){
	  }

// Constructeur Champs à Champs
	
	public Piece(int ligne, int colonne, int couleur)
	  {
	    this.ligne = ligne;
	    this.colonne = colonne;
	    this.couleur = couleur;
	  }
	
// Redéfinition de la méthode toString() de la classe Object
	
	public String couleurpiece() {
		String s;
		if(this.couleur == 0)
	        s = "blanche";
	      else
	        s = "noir";
		return s;
		
	}
	
	public String toString() {
		
		return ("La pièce se situe à la ligne"+getLigne()+", et à la colonne"+ getColonne()+". Elle est de couleur "+couleurpiece()+".");
		 
	}
	
	public boolean verifDeplacement(Echiquier e, Case arrive)
	  {
	    return true;
	  }
	
	public boolean memeCouleur(Case d, Case a) {
	    if(!(a.CaseVide()) )
	      if(a.getP().getCouleur()==d.getP().getCouleur())
	        return true;
	    return false;
	  }


	public String getPropriete() {
		// TODO Auto-generated method stub
		return getPropriete();
	}
	
// Fonction pour déplacer les pièces, elle est abstraite et est redéfinie dans les différentes pièces en fonctions de leurs rôles
// À l'aide de recherches nous avons pu finaliser cette méthode	
	
	public boolean deplacerPiece(Echiquier e,Case a){
	    Case depart = e.getCase(this.ligne, this.colonne);
	    System.out.println(depart.getLigne() + " et : " + depart.getColonne());
	    System.out.println(a.getLigne() + " et : " + a.getColonne());
	    System.out.println(depart.getP().verifDeplacement(e,a));
	    if(depart.getP().verifDeplacement(e,a)) {
	          System.out.println("entre du if 1");
	          e.setCase(a, depart.getP());
	          System.out.println(e.getCase(a.getLigne(),a.getColonne()));
	          depart.setP(null);
	          System.out.println(e.getCase(depart.getLigne(),depart.getColonne()));
	          return true;
	      }
	    return false;
	  }
	
}
