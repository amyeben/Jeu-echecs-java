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
		
		return ("La pièce se situe à la ligne"+getLigne()+", et à la colonne"+ this.colonne+". Elle est de couleur "+couleurpiece()+".");
		 
	}}
}
