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
	        s = "blanc";
	      else
	        s = "noir";
		return s;
		
	}
	
	public String toString() {
		
		return ("La pièce se situe à la ligne"+getLigne()+", et à la colonne"+ getColonne()+". Elle est de couleur "+couleurpiece()+".");
		 
	}
	
// Fonction pour déplacer les pièces, elle est abstraite et est redéfinie dans les différentes pièces en fonctions de leurs rôles
// À l'aide de recherches nous avons pu finaliser cette méthode	
	
	/**public boolean deplacerPiece(Echiquier e,Case a){
	    Case depart = e.getCase(this.ligne, this.colonne);
	    System.out.println(depart.getLigne() + " et : " + depart.getColonne());
	    System.out.println(arrive.getLigne() + " et : " + arrive.getColonne());
	    System.out.println(depart.getPiece().coupPossible(e,arrive));
	    if(depart.getPiece().coupPossible(e,arrive)) {
	          System.out.println("entre du if 1");
	          e.setCase(arrive, depart.getPiece());
	          System.out.println(e.getCase(arrive.getLigne(),arrive.getColonne()));
	          depart.setPiece(null);
	          System.out.println(e.getCase(depart.getLigne(),depart.getColonne()));
	          return true;
	      }
	    return false;
	  }*/
	
}
