import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

    Echiquier e = new Echiquier();
    Piece roi = new Roi(4, 4,1);
        Piece pion = new Pion(2, 4,0);
        Piece fou = new Fou(3, 5,0);

        /*Demo Echec : Il n'y a pas echec */
        e.setCase(e.getCase(4, 4), roi);
        
        
        System.out.println(e.afficher());
        System.out.println(e.enEchec(roi));
        
        /*Demo Echec : Il y a echec */
        e.setCase(e.getCase(4, 4), roi);
        e.setCase(e.getCase(3, 4), pion);
        e.setCase(e.getCase(3, 5), fou);
        
        System.out.println(e.afficher());
        System.out.println(e.enEchec(roi));
        System.out.println("Se fait manger par le fou");
        
  

}

	}


