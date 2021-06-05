import java.io.*;
import java.util.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;


public class Partie
{
	
	//Déclaration des variables
	
	Scanner saisie = new Scanner(System.in);
	private Echiquier plateau; //Marquer la composition
	private Joueur joueur1;
	private Joueur joueur2;
	
	// Getter et Setter
	
	public Echiquier getPlateau()
	{
		return plateau;
	}

	public void setPlateau(Echiquier newPlateau)
	{
		this.plateau = newPlateau;
	}


	public Joueur getJoueur1() {
		return this.joueur1;
	}

	public Joueur getJoueur2() {
		return this.joueur2;
	}
	
	public Joueur joueurEnCour(Partie p) {
		return joueur1;
	}

	// Constructeur
	
	public Partie(Echiquier e, Joueur j1, Joueur j2)
	{
		this.plateau=new Echiquier();
		this.joueur1=j1;
		this.joueur2=j2;

	}
	
	// Méthodes
	
	// manque méthode : pat mat restauration partie

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
					System.out.println("Partie non sauvegarder ");
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

	
	public boolean coupPossible(Piece p)
	{
		return true;		
	}

	public Joueur alternerJoueur(int tours, Joueur j1, Joueur j2) {
		if(tours%2 == 0)//Paire
			return j2;
		return j1;
	}



	public void lancerPartie(Joueur j1, Joueur j2)
	{
		Scanner saisiess = new Scanner(System.in);

		this.joueur1 = j1;
		this.joueur2 = j2;
		this.plateau = new Echiquier();
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
			this.alternerJoueur(tours,j1,j2);
			choixMenu = saisiess.nextInt();
			if (choixMenu == 5) 	{
				this.menu();
			}
			else
				if (choixMenu == 6) {
					if (tours %2 == 0)
						this.tourDeJeu(j1,tours);
					this.tourDeJeu(j2,tours);
					this.alternerJoueur(tours,j1,j2);
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
		System.out.println(this.plateau.getCase(0,7).getP().getPropriete());
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				f.newLine();
				f.write(this.plateau.getCase(i,j).getP() + "\t" + this.plateau.getCase(i,j).getLigne() + "\t" + this.plateau.getCase(i,j).getColonne());
			}
		}
		f.close();
	}
	
	//Aide de recherches
	
	public void tourDeJeu(Joueur j, int tours)
	{
		int coul;
		int coulChoix = 2;
		Piece choix;
		System.out.println(this.getPlateau().afficher());
		System.out.println(j.getPrenom() + ", quelle pièce voulez-vous déplacer? (saisir coordonnées)");
		int ligi,lig;
		String posPiece,pos;
		//Boucle se répète tant qu'on a pas saisie une case contenant une Piece
		try {
			do
			{
					posPiece = saisie.nextLine();
					ligi = posPiece.charAt(1)-'0'; //-'0' : pour que le char se transforme en int

			//Si la case selectionné ne contient pas de piece
					if(this.getPlateau().estVide(j.getChoixCase(this.getPlateau(),ligi,posPiece.charAt(0))))
							System.out.println("Cette case ne contient pas de Pièce, veuillez réessayer :");

			}while(this.getPlateau().estVide(j.getChoixCase(this.getPlateau(),ligi,posPiece.charAt(0))));

			System.out.println("Position saisie -> "+posPiece+" : "+j.getChoixPiece(this.getPlateau(),ligi,posPiece.charAt(0)));
			Case cD = j.getChoixCase(this.getPlateau(),ligi,posPiece.charAt(0));
			int coulChoixD = cD.getP().getCouleur();
			/*Case où se déplacer   */
					//Boucle se répète tant qu'on a pas saisie une case vide

			System.out.println(j.getPrenom() + " où voulez vous vous déplacer?");
			do {
					pos = saisie.nextLine();
					lig = pos.charAt(1)-'0'; //-'0' : pour que le char se transforme en int
					choix = j.getChoixPiece(this.getPlateau(),lig,pos.charAt(0));
					if (choix != null ) {
						coulChoix = choix.getCouleur();
					}

					if(coulChoix == coulChoixD)
							System.out.println("Cette case contient une Piece, veuillez réessayer :");

			}while(coulChoix == coulChoixD);


			System.out.println("Position saisie -> "+pos+" : "+j.getChoixCase(this.getPlateau(),lig,pos.charAt(0)));

			Case depart=j.getChoixCase(this.getPlateau(),ligi,posPiece.charAt(0));
			Case arrive=j.getChoixCase(this.getPlateau(),lig,pos.charAt(0));
			System.out.println(depart.getLigne() + " et : " + depart.getColonne());
			System.out.println(arrive.getLigne() + " et : " + arrive.getColonne());
			depart.getP().deplacerPiece(this.getPlateau(),arrive);
			System.out.println("Piece déplacé");
			System.out.println(this.getPlateau().afficher());
		}catch(Exception ex){
			System.out.println("La saisie est bizzare");
		}

	}

	
	}
