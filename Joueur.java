import java.util.ArrayList;


public class Joueur
{
	private String prenom;
	private int couleur;
	private ArrayList<Piece> tabPiece;

	public Joueur(String unprenom, int unecouleur)
	{
		this.prenom=unprenom;
		this.couleur=unecouleur;
	}

	public Joueur(Joueur j)
	{
		this.prenom=new String(j.prenom);
		this.couleur=j.couleur;
	}
	
	public int convertionC(char lettre) {
		if (lettre == 'A' )
			return 0;
		else if (lettre == 'B')
			return 1;
		else if (lettre == 'C')
			return 2;
		else if (lettre == 'D')
			return 3;
		else if (lettre == 'E')
			return 4;
		else if (lettre == 'F')
			return 5;
		else if (lettre == 'G')
			return 6;
		else 
			return 7;	
	}

	public int convertionL(int ligne) {
		if(ligne == 1)
			return 7;
		if (ligne == 2)
			return 6;
		if(ligne == 3)
			return 5;
		if(ligne == 4)
			return 4;
		if(ligne == 5)
			return 3;
		if(ligne == 6)
			return 2;
		if(ligne == 7)
			return 1;
	
		return 0;
	}
	
	public Case getChoixCase(Echiquier e , int ligne, char colonne) {
		return e.getCase( this.convertionL(ligne),this.convertionC(colonne));
	}
	
	public Piece getChoixPiece(Echiquier e , int ligne, char colonne) {
		return e.getCase(this.convertionL(ligne),this.convertionC(colonne)).getPiece();
	}

	//Les accesseurs
	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public int getCouleur()
	{
		return couleur;
	}

	public void setCouleur(int couleur)
	{
		this.couleur = couleur;
	}

	public ArrayList<Piece> getTabPiece()
	{
		return tabPiece;
	}

	public void setTabPiece(ArrayList<Piece> tabPiece)
	{
		this.tabPiece = tabPiece;
	}

	public String coul() {
		String s ="";
		if(this.couleur == 1)
			s+="Blanche";
		else
			s+="Noire";
		return s ;
	}

	public String toString() {
		return "Joueur " + this.getPrenom() + " posséde les pièces " + this.coul();
	}

}
