package ex2;

public class Test {
	public static void main(String[] args) {
		try {
			EntNat entNat = new EntNat(-10);
			System.out.println(entNat.getN());
		} catch (ErrConst e) {
			// TODO: handle exception
			System.out.println( "error construction , la valeur " +e.getEntier()+ " n\'pas autorisé");
		}
	}
}
