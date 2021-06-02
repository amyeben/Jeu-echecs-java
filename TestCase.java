
public class TestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Piece piece1 = new Piece(1,1,1);
		
		Case c1 = new Case(1,1);
		Case c2 = new Case(2,2,piece1);
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		System.out.println("Test ok !");

	}

}
