public class Fou extends Piece{

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
	
	public Fou()
	{
		super();
		this.propriete = this.couleurfou();

	}
		
	// Constructeur champs à champs avec les informations de Piece
		
	public Fou(int ligne, int colonne, int couleur)
	{
		super(ligne,colonne,couleur);
		this.propriete = this.couleurfou();
	}
		
	// Méthode pour les constructions et connaître la couleur du Fou
		
	public String couleurfou() {
		String s;
		if(this.getCouleur() == 0)
		        s = "\u265D";
	      else
		        s = "\u2657";
		return s;
			
		}
	
	public String toString()
	{
		return super.toString() + " et la piece ressemble à ça: " + this.propriete;
	}
	
	//MÉTHODES DE DÉPLACEMENT
	

}
