
public class Tour extends Piece {

	// Déclaration de variables
	
	private String propriete;
	
	// Getter et Setter

	public String getPropriete() {
		return propriete;
	}

	public void setPropriete(String propriete) {
		this.propriete = propriete;
	}
	
	// Constructeur vide

	
	public Tour()
	{
		super();
		this.propriete = this.couleurtour();

	}
	
	// Constructeur champs à champs avec les informations de Piece
	
	public Tour(int ligne, int colonne, int couleur)
	{
		super(ligne,colonne,couleur);
		this.propriete = this.couleurtour();
	}
	
	// Méthode pour les constructions et connaître la couleur de la Tour
	
	public String couleurtour() {
		String s;
		if(this.getCouleur() == 0)
	        s = "\u2656";
	      else
	        s = "\u265C";
	
		return s;
		
	}
	
	public void deplacer() {}
	
	// À l'aide de recherches nous avons pu finaliser cette méthode
	
	public boolean coupPossible(Echiquier e, Case a) {
		int dLigne = this.getLigne();
		int dColonne = this.getColonne();
		int i = a.getLigne();
		int j = a.getColonne();
		
		//Ici on s'assure que la case à atteindre sur plateau

		if(Math.abs(dLigne - i) <= 8 && Math.abs(dColonne - j) == 0 || Math.abs(dLigne - i ) == 0 && Math.abs(dColonne - j) <=8 )
		{
			return true;
		}
		else
		{
			return false;
		}
		}
	
	public String toString()
	{
		return super.toString() + " et la piece ressemble à ça: " + this.propriete;
	}
	
	
	
	
}
