package ex2;

@SuppressWarnings("serial")
public class ErrConst extends Exception {
	int entier;

	public ErrConst(int entier) {
		this.entier = entier;
	}
	public int getEntier() {
		return this.entier;
	}
	
}
