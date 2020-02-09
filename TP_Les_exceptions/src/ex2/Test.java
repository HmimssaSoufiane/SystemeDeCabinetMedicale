package ex2;

public class Test {
	public static void main(String[] args) {
		System.out.println("Le plus grand nombre naturel= " + Integer.MAX_VALUE);
		try {
			EntNat nbr;
			EntNat nbr2;
			nbr = new EntNat(20);
			nbr2 = new EntNat(13);
			nbr2 = EntNat.diff(nbr2, nbr);
		} catch (ErrNat e) {
			System.err.println("Erreur d'entier");
		}
		try {
			EntNat nbr;
			EntNat nbr2;
			nbr = new EntNat(992349999);
			nbr2 = new EntNat(944669999);
			EntNat res;
			System.out.println("Nombre 1= " + nbr.getN());
			System.out.println("Nombre 2= " + nbr2.getN());
			res = EntNat.somme(nbr, nbr2);
			System.out.println("La somme = " + res.getN());
			res = EntNat.diff(nbr, nbr2);
			System.out.println("La diff = " + res.getN());
			res = EntNat.produit(nbr, nbr2);
			System.out.println("Le produit = " + res.getN());
		} catch (ErrConst e) {
			System.err.println("Erreur de construction du nombre" + e.getNum());
		} catch (ErrSom e) {
			System.err.println("Erreur de somme des valeurs " + e.n1 + " et " + e.n2);
		} catch (ErrDiff e) {
			System.err.println("Erreur de difference des valeurs " + e.n1 + " et " + e.n2);
		} catch (ErrProd e) {
			System.err.println("Erreur de produit des valeurs " + e.n1 + " et " + e.n2);
		}
	}

}
