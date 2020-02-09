package ex2;

public class EntNat {
	private int n;

	public EntNat(int nbr) throws ErrConst {
		if (nbr < 0)
			throw new ErrConst(nbr);
		this.n = nbr;
	}

	public static EntNat somme(EntNat N1, EntNat N2) throws ErrConst, ErrSom {
		int n1 = N1.n;
		int n2 = N2.n;
		long som = n1 + n2;
		System.out.println(som);
		if (som > Integer.MAX_VALUE)
			throw new ErrSom(n1, n2);
		return new EntNat((int) som);
	}

	public static EntNat diff(EntNat N1, EntNat N2) throws ErrDiff, ErrConst {
		int n1 = N1.n;
		int n2 = N2.n;
		int dif = n1 - n2;
		if (dif < 0)
			throw new ErrDiff(n1, n2);
		return new EntNat(dif);
	}

	public static EntNat produit(EntNat N1, EntNat N2) throws ErrProd, ErrConst {
		int n1 = N1.n;
		int n2 = N2.n;
		long pro = (long) n1 * (long) n2;
		if (pro > Integer.MAX_VALUE)
			throw new ErrProd(n1, n2);
		return new EntNat((int) pro);
	}

	public int getN() {
		return n;
	}
}
