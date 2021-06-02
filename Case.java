
public class Case {

//	Declaration des instances	
	
	private int ligne;
	private int colonne;
	private Piece p;
	
	
// Getters et Setters	

	public int getColonne() {
		return colonne;
	}
	public void setColonne(int colonne) {
		this.colonne = colonne;
	}
	public Piece getP() {
		return p;
	}
	public void setP(Piece p) {
		this.p = p;
	}
	public int getLigne() {
		return ligne;
	}
	public void setLigne(int ligne) {
		this.ligne = ligne;
	}
	
// Constructeurs champs à champs
	
	public Case(Piece p)
	  {
	    this.p = p;
	  }
	
	public Case(int ligne, int colonne)
	  {
	    this.ligne = ligne;
	    this.colonne = colonne;
	  }

	  public Case(int ligne, int colonne, Piece p)
	     {
	          this.ligne = ligne;
	          this.colonne = colonne;
	          this.p = p;  
	      }
	  
	  public boolean CaseVide() {
		  if(this.p!=null)
			  return false;
		return true;
		  
	  }
	  
	  public String toString() {
		  
		  String s;
		  if(this.CaseVide() == true)
		        s = "La case est vide";
		      else
		        s = "Il y a une pièce sur la case.";
		  
			
			return ("La case est à la ligne "+getLigne()+", et à la colonne "+ getColonne()+". "+s);
			 
		}
	  
	  /**  méthode qui manque memeColonne, memeLigne, manger,caseDevant */
	
}
