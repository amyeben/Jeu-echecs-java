import java.util.*;
import java.io.*;

public class Echiquier
{
	private Case[][] desCases;
	ArrayList<Piece> listeEnnemie = new ArrayList<Piece>();

	public Echiquier()
	{
		this.initialiser();
		this.initialiserPiecesNoir();
		this.initialiserPiecesBlanche();
	}
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
						this.desCases[i][j] = new Case(e.getCase(i,j).getPosX(),e.getCase(i,j).getPosY(),e.getCase(i,j).getPiece());
				}
		}
	}

	/* Initialise le tableau */
	public void initialiser()
	{
		this.desCases = new Case[8][8];
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				this.desCases[i][j] = new Case(i,j);
			}
		}
	}

	/* getCase() */
	public Case getCase(int x, int y)
	{
		return this.desCases[x][y];   // retourne la case par rapport a l'indice x, y
	}

	/* setCase() - on modifie la case en lui ajoutant une piece
	 * On ajoute la piece dans la case concerné
	 * Si la case est vide alors je peux placer ma piece  */

	public void setCase(Case c, Piece p)
	{
		if(this.etatCase(c))
		{
			this.desCases[c.getPosX()][c.getPosY()].setPiece(p);
			p.setPosXetY(c.getPosX(), c.getPosY());
		}
	}


	/*Soumeya___
	 * En ne mettant que la case concerné on retourne True si elle est vide ou bien false*/
	public boolean etatCase(Case c)
	{
		if(c.estVide())
			return true;
		return false;
	}

	/* GETTER */
	public Case[][] getDesCases()
	{
		return this.desCases;
	}

	public void initialiserPiecesNoir()
	{
		//  Je place les pieces du joueur Noir
		for (int i = 0; i < 2 ; i++)
		{
				this.desCases[i][0].setPiece(new Tour(i,0,0));
				this.desCases[i][1].setPiece(new Cavalier(i,1,0));
				this.desCases[i][2].setPiece(new Fou(i,2,0));
				this.desCases[i][3].setPiece(new Reine(i,3,0));
				this.desCases[i][4].setPiece(new Roi(i,4,0));
				this.desCases[i][5].setPiece(new Fou(i,5,0));
				this.desCases[i][6].setPiece(new Cavalier(i,6,0));
				this.desCases[i][7].setPiece(new Tour(i,7,0));
				if (i == 1)
				{
					for (int j = 0; j < 8; j++)
					{
						this.desCases[i][j].setPiece(new Pion(i,j,0));
					}
				}
		}
	}
	public void initialiserPiecesBlanche()
	{
		// Je place les pieces du joueur blanc
		for (int i = 7; i > 5 ; i--)
		{
			this.desCases[i][0].setPiece(new Tour(i,0,1));
			this.desCases[i][1].setPiece(new Cavalier(i,1,1));
			this.desCases[i][2].setPiece(new Fou(i,2,1));
			this.desCases[i][3].setPiece(new Reine(i,3,1));
			this.desCases[i][4].setPiece(new Roi(i,4,1));
			this.desCases[i][5].setPiece(new Fou(i,5,1));
			this.desCases[i][6].setPiece(new Cavalier(i,6,1));
			this.desCases[i][7].setPiece(new Tour(i,7,1));
			if (i == 6)
			{
				for (int j = 0; j < 8; j++)
				{
					this.desCases[i][j].setPiece(new Pion(i,j,1));
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
				s = s + this.desCases[i][j] + "	|	";
			}
		}
		return s;
	}

	public ArrayList<Piece> pritPour(Piece victime)
	{
		if(victime.getCouleur() == 0) {

			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					if(!(this.etatCase(this.getCase(i, j))))
						if(this.getCase(i, j).getPiece().getCouleur() == 1)
							this.listeEnnemie.add(this.getCase(i, j).getPiece());
				}
			}
		}
		else if(victime.getCouleur() == 1)
		{
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					if(!(this.etatCase(this.getCase(i, j))))
						if(this.getCase(i, j).getPiece().getCouleur() == 0)
							this.listeEnnemie.add(this.getCase(i, j).getPiece());

				}
			}
		}

		return this.listeEnnemie;
	}

	public boolean enEchec(Piece cible)
	{
		this.pritPour(cible);
		for(int i = 0; i<this.listeEnnemie.size(); i++)
			if(this.listeEnnemie.get(i).verifDeplacement(this, this.getCase(cible.getPosX(),cible.getPosY())))
				{
				System.out.println(this.listeEnnemie.get(i));
				return true;}
		return false;
	}

	public void effacerEchiquier()
    {
		try
		{
        	if(System.getProperty("os.name").contains("Windows"))
			{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			else
			{
            	System.out.print("\033[H\033[2J");
        		System.out.flush();
			}
    	}
		catch (IOException | InterruptedException ex) {}
	}

// V.1
	//public String afficher(){
	// 	int nb =1;
	// 	String s = "   A   B   C   D   E   F   G   H\n";
	// 	for (int i = 0; i < 8; i++)
	// 	{
	// 		s+=nb+" |";
	// 			for (int j = 0; j < 8; j++)
	// 			{
	// 					if(this.etatCase(this.getCase(i,j)))
	// 						s += ".   ";
	// 					else
	// 						s += this.getCase(i,j).getPiece().getForme()+"   ";
	// 			}
	// 		s += "\n";
	// 		nb++;
	// 	}
	// 	return s;
	// }

// AFFICHAGE V.2 DE L'ÉCHIQUIER
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
						if(this.etatCase(this.getCase(i,j)))
							element += "    ";
						else
							element += this.getCase(i,j).getPiece().getForme()+"   ";
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











/*TEST initialiserPiecesNoir et initialiserPiecesBlanche
Echiquier e = new Echiquier();
Piece p = new Fou();
Piece pi = new Fou();
e.initialiserPiecesNoir(p);
e.initialiserPiecesBlanche(pi);
System.out.println(e.getCase(6,6));
*/
