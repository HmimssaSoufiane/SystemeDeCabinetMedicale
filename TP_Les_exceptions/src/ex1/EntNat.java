package ex1;

public class EntNat {
	int entier;

	public EntNat(int entier) throws ErrConst {
		if (entier < 0)
			throw new ErrConst("error construction , la valeur "+entier+" n\'pas autorisé");
		this.entier = entier;
	}

	public int getN() {
		return entier;
	}
}
