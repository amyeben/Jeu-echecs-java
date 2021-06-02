//Ce qu'on peux faire pendant une partie
//une partie est composé d'un échiquier
import java.io.*;
import java.util.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;


public class Partie
{
	Scanner saisie = new Scanner(System.in);
	private Echiquier terrain; //Une Partie est composé d'un Echequier
	private Joueur joueur1;
	private Joueur joueur2;

	public Partie()
	{
//		this.terrain=new Echiquier();jhjhj
	}

	public Partie(Joueur j1, Joueur j2)
	{
		this.terrain=new Echiquier();
		this.joueur1=j1;
		this.joueur2=j2;

	}

	public void menu()
	{
		System.out.println("Saisir 1 : créer une Partie\nSaisir 2 : Sauver partie \nSaisir 3 : Charger Partie\nSaisir 4 : quitter Partie ");
		int choixMenu = this.saisie.nextInt();
		if(choixMenu == 1){
			Scanner saisies = new Scanner(System.in);

			System.out.println("Joueur 1 : Votre nom ?");
			String j1nom = saisies.nextLine();
			Joueur j1 = new Joueur(j1nom,1);

			System.out.println("Joueur 2 : Votre nom ?");
			String j2nom = saisies.nextLine();
			Joueur j2 = new Joueur(j2nom,0);
			this.lancerPartie(j1,j2);
			choixMenu = 0;
			choixMenu = this.saisie.nextInt();
			System.out.println("Saisir 4 : quitter Partie ");
		}
		else
			if(choixMenu == 2){
				try{
				this.sauvegarder("sauve.txt");
			}catch (Exception e) {
					System.out.println("Partie non sauvegarder /!\ ");
				}
			}
		else
			if (choixMenu == 3) {
					System.out.println("Chargement en cours");
			}
		else
			if (choixMenu == 4) {
				System.exit(0);
			}
	}

//--------------
	/*Le jeu annonce un MAT lorsque le Roi est attaqué et qu’il n’y a aucune possibilité de le sauver.*/

	// public boolean verifMAT()
	// {
	// }

	/*	Le jeu annonce un PAT lorsque le joueur ne peut déplacer aucune pièces
	 *	et que le roi n’est pas en attaque et ne peut se déplacer sans se mettre en échec .*/

	// public boolean verifPAT()
	// {
	// }

	public boolean coupPossible(Piece p)
	{
		return true;		// JUSTE POUR LA COMPILATION
	}


	public Joueur joueurEnCour(Partie p) {
		return joueur1;
	}

		/*Soumeya
	 * Pour alterner les joueurs, j'utilise une variable int tours que j'incrémenterais
	 * a chaque tour. (tours = 1 au debut)
	 * Si tour paire alors c'est le joueurs qui joue en 2 (les pieces noires)
	 * Sinon impaire c'est le premier joueurs
	 */
	public Joueur alternationJoueur(int tours, Joueur j1, Joueur j2) {
		if(tours%2 == 0)//Paire
			return j2;
		return j1;
	}
//-------------------


	public void lancerPartie(Joueur j1, Joueur j2)
	{
		Scanner saisiess = new Scanner(System.in);

		this.joueur1 = j1;
		this.joueur2 = j2;
		this.terrain = new Echiquier();
		int tours = 2;
		int choixMenu = saisiess.nextInt();
		while(tours != 0)
		{
			System.out.println("Saisir 5 : revenir au menu \nSaisir 6 pour continuer ");
			do{
			System.out.println("Saisir 5 : revenir au menu \nSaisir 6 pour continuer ");
			if (tours %2 == 0)
				this.tourDeJeu(j1,tours);
			this.tourDeJeu(j2,tours);
			this.alternationJoueur(tours,j1,j2);
			choixMenu = saisiess.nextInt();
			if (choixMenu == 5) 	{
				this.menu();
			}
			else
				if (choixMenu == 6) {
					if (tours %2 == 0)
						this.tourDeJeu(j1,tours);
					this.tourDeJeu(j2,tours);
					this.alternationJoueur(tours,j1,j2);
				}
			tours++;
		}while(tours>2 || tours==2);
	}

	}


	public void sauvegarder(String fichier) throws IOException
	{

		BufferedWriter f = new BufferedWriter(new FileWriter(fichier,true));
		f.write(this.joueur1.getPrenom() + "\t" + this.joueur1.getCouleur());
		f.newLine();
		f.write(this.joueur2.getPrenom() + "\t" +this.joueur2.getCouleur());
		System.out.println(this.terrain.getCase(0,7).getPiece().getPropriete());
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				f.newLine();
				f.write(this.terrain.getCase(i,j).getPiece() + "\t" + this.terrain.getCase(i,j).getPosLigne() + "\t" + this.terrain.getCase(i,j).getPosColonne());
			}
		}
		f.close();
	}
/*
	public void restaurerPartie(String fichier) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader(fichier));
		int i = 0;
		int v = 0;
		String r = f.readLine();
		StringTokenizer st = new StringTokenizer(r,"\t");
		String j = st.nextToken();	// recupere le prenom du joueur1
		int c = Integer.parseInt(st.nextToken()); // recupere la couleur du joueur1
		this.joueur1 = new Joueur(j,c);// creer le joueur 2
		r = f.readLine();
		st = new StringTokenizer(r,"\t");
		j = st.nextToken();	//	recupere le prenom du joueur2
		c = Integer.parseInt(st.nextToken()); //	recupere la couleur du joueur2
		this.joueur2 = new Joueur(j,c); // creer le joueur 2
		r = f.readLine();
		String nomForme;
		while (r != null) // tant qu'il y a encore une ligne
		{
			StringTokenizer st = new StringTokenizer(r,"\t");
			nomForme = st.nextToken();
			r = f.readLine();
		}
	}
	public void sauvegarderPartie()
	{
		try {
				File fichier = new File("sauvegarder.ser");
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
				oos.writeObject(this.terrain);
				oos.close();
		}catch(Exception e){
			System.out.println("Le fichier n'est pas sauvegarde !!");
		}
	}
	*/
	public void effacerTerrain()
	{
	}

	public void historique()
	{
	}

	public void tourDeJeu(Joueur j, int tours)
	{
		int coul;
		int coulChoix = 2;
		Piece choix;
		System.out.println(this.getTerrain().afficher());
		System.out.println(j.getPrenom() + ", quelle pièce voulez-vous déplacer? (saisir les coordonnées)");
		int ligi,lig;
		String posPiece,pos;
		//Boucle se répète tant qu'on a pas saisie une case contenant une Piece
		try {
			do
			{
					posPiece = saisie.nextLine();
					ligi = posPiece.charAt(1)-'0'; //-'0' : pour que le char se transforme en int

			//Si la case selectionnée ne contient pas de piece:
					if(this.getTerrain().etatCase(j.getChoixCase(this.getTerrain(),ligi,posPiece.charAt(0))))
							System.out.println("/!\ cette case ne contient pas de pièce, veuillez réessayer :");

			}while(this.getTerrain().etatCase(j.getChoixCase(this.getTerrain(),ligi,posPiece.charAt(0))));

			System.out.println("La position saisie est: "+posPiece+" : "+j.getChoixPiece(this.getTerrain(),ligi,posPiece.charAt(0)));
			Case cD = j.getChoixCase(this.getTerrain(),ligi,posPiece.charAt(0));
			int coulChoixD = cD.getPiece().getCouleur();
			/*Case où se déplacer   */
					//Boucle se répète tant qu'on a pas saisie une case vide

			System.out.println(j.getPrenom() + " où voulez vous vous déplacer?");
			do {
					pos = saisie.nextLine();
					lig = pos.charAt(1)-'0'; //-'0' : pour que le char se transforme en int
					choix = j.getChoixPiece(this.getTerrain(),lig,pos.charAt(0));
					if (choix != null ) {
						coulChoix = choix.getCouleur();
					}

					if(coulChoix == coulChoixD)
							System.out.println(" /!\ Cette case contient une pièce, veuillez réessayer :");

			}while(coulChoix == coulChoixD);


			System.out.println("La position saisie est: "+pos+" : "+j.getChoixCase(this.getTerrain(),lig,pos.charAt(0)));

			Case depart=j.getChoixCase(this.getTerrain(),ligi,posPiece.charAt(0));
			Case arrive=j.getChoixCase(this.getTerrain(),lig,pos.charAt(0));
			System.out.println(depart.getPosLigne() + " et : " + depart.getPosColonne());
			System.out.println(arrive.getPosLigne() + " et : " + arrive.getPosColonne());
			depart.getPiece().deplacer(this.getTerrain(),arrive);
			System.out.println("Piece déplacé");
			System.out.println(this.getTerrain().afficher());
		}catch(Exception ex){
			System.out.println("La saisie est bizzare");
		}

	}

	public Echiquier getTerrain()
	{
		return terrain;
	}

	public void setTerrain(Echiquier newTerrain)
	{
		this.terrain = newTerrain;
	}


	public Joueur getJoueur1() {
		return this.joueur1;
	}

	public Joueur getJoueur2() {
		return this.joueur2;
	}

}
