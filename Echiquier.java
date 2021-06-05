import java.util.*;
import java.io.*;

public class Echiquier
{
	
	// Déclaration de variables
	
	private Case[][] Cases;
	ArrayList<Piece> listeEnnemie = new ArrayList<Piece>();
	
	// Constructeur vide

	public Echiquier()
	{
		this.initialiser();
		this.piecesNoir();
		this.piecesBlanche();
	}
	
	// Constructeurs champs à champs
	
	public Echiquier(boolean t)
	{
		if (t == false)
			this.initialiser();
	}
	public Echiquier(Echiquier e)
	{
		for (int i = 0; i < 8; i++)
		{
				for (int j = 0; j < 8; j++)
				{
						this.Cases[i][j] = new Case(e.getCase(i,j).getLigne(),e.getCase(i,j).getColonne(),e.getCase(i,j).getP());
				}
		}
	}
	
	// Getter et Setter
	
	public Case getCase(int ligne, int colonne)
	{
		return this.Cases[ligne][colonne];   
	}
	
	public Case[][] getCases()
	{
		return this.Cases;
	}

	public void setCase(Case c, Piece p)
	{
		if(this.estVide(c))
		{
			this.Cases[c.getLigne()][c.getColonne()].setP(p); // Si vide --> on place la pièce
			p.setLetC(c.getLigne(), c.getColonne());
		}
	}

	// MÉTHODES
	
	public void initialiser()
	{
		this.Cases = new Case[8][8];
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				this.Cases[i][j] = new Case(i,j);
			}
		}
	}


	public boolean estVide(Case c)
	{
		if(c.CaseVide()) 
			return true; 
		return false;
	}
	
	public void piecesBlanche()
	{
		
		for (int i = 0; i < 2 ; i++)
		{
				this.Cases[i][0].setP(new Tour(i,0,0));
				this.Cases[i][1].setP(new Cavalier(i,1,0));
				this.Cases[i][2].setP(new Fou(i,2,0));
				this.Cases[i][3].setP(new Reine(i,3,0));
				this.Cases[i][4].setP(new Roi(i,4,0));
				this.Cases[i][5].setP(new Fou(i,5,0));
				this.Cases[i][6].setP(new Cavalier(i,6,0));
				this.Cases[i][7].setP(new Tour(i,7,0));
				if (i == 1)
				{
					for (int j = 0; j < 8; j++)
					{
						this.Cases[i][j].setP(new Pion(i,j,0));
					}
				}
		}
	}
	public void piecesNoir()
	{
		
		for (int i = 7; i > 5 ; i--)
		{
			this.Cases[i][0].setP(new Tour(i,0,1));
			this.Cases[i][1].setP(new Cavalier(i,1,1));
			this.Cases[i][2].setP(new Fou(i,2,1));
			this.Cases[i][3].setP(new Reine(i,3,1));
			this.Cases[i][4].setP(new Roi(i,4,1));
			this.Cases[i][5].setP(new Fou(i,5,1));
			this.Cases[i][6].setP(new Cavalier(i,6,1));
			this.Cases[i][7].setP(new Tour(i,7,1));
			if (i == 6)
			{
				for (int j = 0; j < 8; j++)
				{
					this.Cases[i][j].setP(new Pion(i,j,1));
				}
			}
		}
	}

	public String toString()
	{
		String s = "|";
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				s = s + this.Cases[i][j] + "	|	\n";
			}
		}
		return s;
	}
	
	// Aide pour initialiser ces méthodes

	public ArrayList<Piece> pritPour(Piece victime)
	{
		if(victime.getCouleur() == 1) {

			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					if(!(this.estVide(this.getCase(i, j))))
						if(this.getCase(i, j).getP().getCouleur() == 0)
							this.listeEnnemie.add(this.getCase(i, j).getP());
				}
			}
		}
		else if(victime.getCouleur() == 0)
		{
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					if(!(this.estVide(this.getCase(i, j))))
						if(this.getCase(i, j).getP().getCouleur() == 1)
							this.listeEnnemie.add(this.getCase(i, j).getP());

				}
			}
		}

		return this.listeEnnemie;
	}

	public boolean enEchec(Piece cible)
	{
		this.pritPour(cible);
		for(int i = 0; i<this.listeEnnemie.size(); i++)
			if(this.listeEnnemie.get(i).verifDeplacement(this, this.getCase(cible.getLigne(),cible.getColonne())))
				{
				System.out.println(this.listeEnnemie.get(i));
				return true;}
		return false;
	}

	public String afficher()
    {
		String s = "	    A	    B	    C	    D	    E	    F	    G	    H\n";
		int nb = 8;
		String test = "";
		String element = "";     // éléments à afficher selon la case EXEMPLE : "*  T   " (pour la Tour) , ou "*  F   " (pour le Fou)
		String bordure = "\t";        // bordure de l'affichage, composé de *
		String espacement = "\t";     // l'espace entre l'élement à afficher et la bordure du plateau
		String res = "";

//		effacerEchiquier();

    	// la première boucle permet d'afficher les bords
		for(int u = 0; u < 8; u++)
		{
			bordure += "********";
		}
		bordure += "*";     // pour avoir la dernière étoile de la bordure

		res = bordure + '\n';   // on commence par afficher la première ligne horizontale de la bordure

		// la deuxième boucle, elle, permet d'afficher les 6 espaces entre les colonnes d'étoiles
		for(int p = 0; p < 8; p++)
		{
			espacement += "*	";
		}
		espacement += "*";      // pour avoir la dernière étoile de la bordure

        // la troisième boucle, permet d'attribuer à une case le caractère de la pièce correspondante
    	// La chaine sera contenu dans la variable 'element'
 		for(int i = 0; i < 8; i++)
		{
				for (int j = 0; j < 8; j++)
				{
						element += "*   ";
						if(this.estVide(this.getCase(i,j)))
							element += "    ";
						else
							element += this.getCase(i,j).getP().getPropriete()+"   ";
				}


			element += "*";      // pour avoir la dernière étoile de la bordure
			res += "     " + nb + espacement + "  " + nb + "\n	"
					+ element + "\n"
						+ espacement + "\n"		// assemblage de toutes les composantes qui constituent l'affichage final
                        	+ bordure + '\n';     // un espacement, l'information de la pièce, un espacement ainsi que la bordure pour finir

			element = "";    //réinitialiser l'élement à afficher

			nb -= 1;
		}

		return s + res + s;     //on retourne la variable resultat contenant ce qui correspond à l'échiquier final
	}

}

