
public class TestEchiquier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Echiquier e = new Echiquier();
		Piece p = new Fou();
		Piece pi = new Fou();
		e.piecesNoir();
		e.piecesBlanche();
		System.out.println(e.getCase(6,6));
		System.out.println(e.afficher());
		System.out.println(e.toString());
		

	}

}
