package cabinet.medicale.dao;

import java.util.List;

import cabinet.medicale.models.Client;

public interface ClientDao {
	public List<Client> getClients();
	public Client getClient(int id);
	public void addClient(Client C);
	public void updateClient(Client C);
	public void deleteClient(int id);
}
