
public class TestRoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Piece piece1 = new Piece(1,1,1);
		
		Case c2 = new Case(2,2,piece1);
		
		Roi ro1 = new Roi(1,2,0);
		
		System.out.println(piece1.toString());
		System.out.println(c2.toString());
		System.out.println(ro1.toString());
		
		System.out.println("Test ok !");

	}

}
