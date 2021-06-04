
public class Reine extends Piece{

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
	
	public Reine()
	{
		super();
		this.propriete = this.couleurreine();

	}
		
	// Constructeur champs à champs avec les informations de Piece
		
	public Reine(int ligne, int colonne, int couleur)
	{
		super(ligne,colonne,couleur);
		this.propriete = this.couleurreine();
	}
		
	// Méthode pour les constructions et connaître la couleur du Reine
		
	public String couleurreine() {
		String s;
		if(this.getCouleur() == 0)
		        s = "\u265B";
	      else
		        s = "\u2655";
		return s;
			
		}
	
	public String toString()
	{
		return super.toString() + " et la piece ressemble à ça: " + this.propriete;
	}

}
