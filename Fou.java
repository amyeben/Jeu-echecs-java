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
	//à l'aide de recherches
	
	public boolean verifDeplacement(Echiquier e, Case a)
	{
		int i = a.getLigne();
		int j = a.getColonne();
		boolean p = false;
		int departX = this.getLigne();	// position x de la piece
		int departY = this.getColonne();	// position y de la piece
		int dest = i - departX;
		int fin = j - departY;
		dest = Math.abs(dest);
		fin = Math.abs(fin);
		if (e.estVide(e.getCase(i,j)) == false && e.getCase(i,j).getP().getCouleur() == this.getCouleur() || dest != fin)
		{
			return p;
		}
		else if (departX > i && departY < j)
		{
			return this.verifDeplacementDhd(e,i,j,departX,departY);
		}
		else if (departX > i && departY > j)
		{
			return this.verifDeplacementDhg(e,i,j,departX,departY);
		}
		else if (departX < i && departY < j)
		{
			return this.verifDeplacementGbd(e,i,j,departX,departY);
		}
		else if (departX < i && departY > j)
		{
				return this.verifDeplacementGbg(e,i,j,departX,departY);
		}
		return p;
	}
	// verifiez deplacement Diagonale haut droit
	public boolean verifDeplacementDhd(Echiquier e, int i, int j, int departX, int departY)
	{
		boolean p = false;
		departX = departX - 1;
		departY = departY + 1;
		if (departX == i && departY == j) {
			return true;
		}
		while (departX > i || departY < j)
		{
			// si case libre
			if (e.estVide(e.getCase(departX,departY)))
			{
				p = true;
			}
			// si la case contient une piece
			else if (e.estVide(e.getCase(departX,departY)) == false)
			{
				return false;
			}
			departX = departX - 1;
			departY = departY + 1;
		}
		return p;
	}
	// verifier deplacement Diagonale haut gauche
	public boolean verifDeplacementDhg(Echiquier e, int i, int j, int departX, int departY)
	{
		boolean p = false;
		departX = departX - 1;
		departY = departY - 1;
		if (departX == i && departY == j) {
			return true;
		}
		while(departX > i || departY > j)
		{
			// si case libre
			if (e.estVide(e.getCase(departX,departY)))
			{
				p = true;
			}
			// si la case contient une piece
			else if (e.estVide(e.getCase(departX,departY)) == false)
			{
				return false;
			}
			departX = departX - 1;
			departY = departY - 1;
		}
		return p;
	}
	// verifier deplacement Diagonale bas droit
	public boolean verifDeplacementGbd(Echiquier e, int i, int j, int departX, int departY)
	{
		boolean p = false;
		departX = departX + 1;
		departY = departY + 1;
		if (departX == i && departY == j) {
			return true;
		}
		while(departX < i || departY < j)
		{
			// si case libre
			if (e.estVide(e.getCase(departX,departY)))
			{
				p = true;
			}
			// si la case contient une piece
			else if (e.estVide(e.getCase(departX,departY)) == false)
			{
				return false;
			}
			departX = departX + 1;
			departY = departY + 1;
		}
		return p;
	}
	// verifier deplacement Diagonale bas gauche
	public boolean verifDeplacementGbg(Echiquier e, int i, int j, int departX, int departY)
	{
		boolean p = false;
		departX = departX + 1;
		departY = departY - 1;
		if (departX == i && departY == j) {
			return true;
		}
		while(departX < i || departY > j)
		{
			// si case libre
			if (e.estVide(e.getCase(departX,departY)))
			{
				p = true;
			}
			// si la case contient une piece
			else if (e.estVide(e.getCase(departX,departY)) == false)
			{
				return false;
			}
			departX = departX + 1;
			departY = departY - 1;
		}
		return p;
	}
	

}
