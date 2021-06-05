public class Cavalier extends Piece{

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
	
	public Cavalier()
	{
		super();
		this.propriete = this.couleurcavalier();

	}
		
	// Constructeur champs à champs avec les informations de Piece
		
	public Cavalier(int ligne, int colonne, int couleur)
	{
		super(ligne,colonne,couleur);
		this.propriete = this.couleurcavalier();
	}
		
	// Méthode pour les constructions et connaître la couleur du Cavalier
		
	public String couleurcavalier() {
		String s;
		if(this.getCouleur() == 0)
		        s = "\u265E";
	      else
		        s = "\u2658";
		return s;
			
		}
	
	public String toString()
	{
		return super.toString() + " et la piece ressemble à ça: " + this.propriete;
	}
	
	public boolean coupPossible(Echiquier e, Case a)
	{
		int dLigne = this.getLigne();
		int dColonne = this.getColonne();
		int i = a.getLigne();
		int j = a.getColonne();

		if( Math.abs(dLigne - i) == 2 && Math.abs(dColonne - j) == 1 || Math.abs(dLigne - i) == 1 && Math.abs(dColonne - j) ==2 )
		{
			return true;
		}

		else
		{
			return false;
		}
	}}
	
	

