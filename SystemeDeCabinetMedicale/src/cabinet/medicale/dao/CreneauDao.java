package cabinet.medicale.dao;

import java.util.List;

import cabinet.medicale.models.Creneau;

public interface CreneauDao {

	public List<Creneau> getCreneaux();
	public Creneau getCreneau(int id);
	public void addCreneau(Creneau C);
	public void updateCreneau(Creneau C);
	public void deleteCreneau(int id);
}
