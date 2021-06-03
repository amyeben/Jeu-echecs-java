
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
		this.propriete = this.couleurtour();

	}
		
	// Constructeur champs à champs avec les informations de Piece
		
	public Pion(int ligne, int colonne, int couleur)
	{
		super(ligne,colonne,couleur);
		this.propriete = this.couleurtour();
	}
		
	// Méthode pour les constructions et connaître la couleur de la Tour
		
	public String couleurtour() {
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
	
	
}
