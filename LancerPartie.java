import java.util.ArrayList;

public class LancerPartie {
	

	    public static void main(String[] args) {
	    
	    	Echiquier e = new Echiquier();
	    	//e.piecesBlanche();
	    	//e.piecesNoir();
	    	System.out.println(e.afficher());
	    	
	    	System.out.println("\n");
	    	
	    	Tour tb1 = new Tour(0,0,0);
			Cavalier cb1 = new Cavalier(0,1,0);
			Fou fb1 = new Fou(0,2,0);
			Reine reb1 = new Reine(0,3,0);
			Roi rob1 = new Roi(0,4,0);
			Fou fb2 = new Fou(0,5,0);
			Cavalier cb2 = new Cavalier(0,6,0);
			Tour tb2 = new Tour(0,7,0);
			
			System.out.println(tb1);
			System.out.println(cb1);
			System.out.println(fb1);
			System.out.println(reb1);
			System.out.println(rob1);
			System.out.println(fb2);
			System.out.println(cb2);
			System.out.println(tb2);
			
			Tour tn1 = new Tour(0,0,1);
			Cavalier cn1 = new Cavalier(0,1,1);
			Fou fn1 = new Fou(0,2,1);
			Reine ren1 = new Reine(0,3,1);
			Roi ron1 = new Roi(0,4,1);
			Fou fn2 = new Fou(0,5,1);
			Cavalier cn2 = new Cavalier(0,6,1);
			Tour tn2 = new Tour(0,7,1);
			
			System.out.println("\n");
			
			System.out.println(tn1);
			System.out.println(cn1);
			System.out.println(fn1);
			System.out.println(ren1);
			System.out.println(ron1);
			System.out.println(fn2);
			System.out.println(cn2);
			System.out.println(tn2);
			
			
			Joueur joueur1 = new Joueur("Amy",0);
			Joueur joueur2 = new Joueur("Kaenat",1);
			
			System.out.println("\n");
			
			System.out.println(joueur1);
			System.out.println(joueur2);
			
			Partie partie1 = new Partie(e,joueur1,joueur2);
			partie1.menu();


	}}

