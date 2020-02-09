package ex2;

public class EntNat {
	int entier;

	public EntNat(int entier) throws ErrConst {
		if (entier < 0)
			throw new ErrConst(entier);
		this.entier = entier;
	}

	public int getN() {
		return entier;
	}
}
