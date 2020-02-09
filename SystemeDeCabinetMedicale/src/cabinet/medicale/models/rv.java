package cabinet.medicale.models;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class rv implements Serializable{

	private int id;
	private Date jour;
	private Creneau creneaux;
	private Client client;

	public rv(int id, Date jour, Creneau creneaux, Client client) {
		super();
		this.id = id;
		this.jour = jour;
		this.creneaux = creneaux;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getJour() {
		return jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}

	public Creneau getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(Creneau creneaux) {
		this.creneaux = creneaux;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "rv [id=" + id + ", jour=" + jour + ", creneaux=" + creneaux + ", client=" + client + "]";
	}

}
