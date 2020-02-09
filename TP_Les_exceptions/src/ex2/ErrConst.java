package ex2;

@SuppressWarnings("serial")
public class ErrConst extends ErrNat {
	int number;

	ErrConst(int number) {
		this.number = number;
	}

	public int getNum() {
		return number;
	}
}
