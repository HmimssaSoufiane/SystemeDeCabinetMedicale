package cabinet.medicale.dao;

import java.util.List;

import cabinet.medicale.models.Medecin;

public interface MedecinDao {
	public List<Medecin> getMedecins();
	public Medecin getMedecin(int id);
	public void addMedecin(Medecin medecin);
	public void updateMedecin(Medecin medecin);
	public void deleteMedecin(int id);
}
