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
	  
	  /** memeColonne, memeLigne, mangerpiece, caseDevant */
	  
	  public boolean memeColonne(Case a)
	  {
	    if(this.getColonne() == a.getColonne())
	      return true;
	    return false;
	        
	  }
	      
	  public boolean memeLigne(Case a)
	  {
		  if(this.getLigne()== a.getLigne())
	        return true;
	      return false;
	          
	    }
	  
	  public boolean mangerpiece(Case a) {
		    if(this.getP().getCouleur() != a.getP().getCouleur())
		    {
		      if(this.getP().getCouleur()==0)//Blanc
		        if(a.getLigne()==this.getLigne()+1)
		        {
		          if(a.getColonne()==this.getColonne()-1)
		            return true;
		          else if (a.getColonne()==this.getColonne()+1)
		            return true;
		        }
		      else 
		      
		        if(a.getLigne()==this.getLigne()-1)
		        {
		          if(a.getColonne()==this.getColonne()-1)
		            return true;
		          else if (a.getColonne()==this.getColonne()+1)
		            return true;
		        }
		    }
		      
		    return false;
		  }
	  
	  public boolean caseDevant(Case a) {
	      if(this.getP().getCouleur() == 0)//noir
	        if(this.memeColonne(a) && this.getLigne()+1 == a.getLigne())
	          return true;
	      else if (this.getP().getCouleur() == 1)
	        if(this.memeColonne(a) && this.getLigne()-1 == a.getLigne())
	          return true;
	      
	      return false;
	    }
	

	  
}
