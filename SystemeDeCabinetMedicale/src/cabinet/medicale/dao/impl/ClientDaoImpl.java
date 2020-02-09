package cabinet.medicale.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import application.DatabaseConnection;
import cabinet.medicale.dao.ClientDao;
import cabinet.medicale.models.Client;
import javafx.scene.control.Alert;

public class ClientDaoImpl implements ClientDao {
	Statement statement;
	ResultSet resultSet;
	DatabaseConnection databaseConnection;
	String message = "l\'opération est terminée avec succès";

	public ClientDaoImpl() {
		databaseConnection = DatabaseConnection.getInstance();
	}

	@Override
	public List<Client> getClients() {
		List<Client> clients = new ArrayList<Client>();

		try {
			statement = databaseConnection.getConnection().createStatement();
			resultSet = statement.executeQuery("select * from Client");

			while (resultSet.next()) {
				Client c = new Client(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5));
				clients.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public Client getClient(int id) {
		Client client = null;

		try {
			statement = databaseConnection.getConnection().createStatement();
			PreparedStatement preparedStatement = databaseConnection.getConnection()
					.prepareStatement("select * from Client where id=?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				client = new Client(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public void addClient(Client client) {
		try {
			String queryString = "insert into Client values (?,?,?,?)";
			PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(queryString);
			preparedStatement.setInt(1, client.getVersion());
			preparedStatement.setString(2, client.getTitre());
			preparedStatement.setString(3, client.getNom());
			preparedStatement.setString(4, client.getPrenom());
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				new Alert(Alert.AlertType.INFORMATION, message).showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateClient(Client client) {
		try {
			String queryString = "Update Client set Version = ? ,Titre=?,Nom=?,Prenom=? where ID = ?";
			PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(queryString);
			preparedStatement.setInt(1, client.getVersion());
			preparedStatement.setString(2, client.getTitre());
			preparedStatement.setString(3, client.getNom());
			preparedStatement.setString(4, client.getPrenom());
			preparedStatement.setInt(5, client.getId());
			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
				new Alert(Alert.AlertType.INFORMATION, message).showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteClient(int id) {
		try {
			String queryString = "Delete from Client where ID = ?";
			PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(queryString);
			preparedStatement.setInt(1, id);
			int rowsDeleted = preparedStatement.executeUpdate();
			if (rowsDeleted > 0) {
				new Alert(Alert.AlertType.INFORMATION, message).showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
