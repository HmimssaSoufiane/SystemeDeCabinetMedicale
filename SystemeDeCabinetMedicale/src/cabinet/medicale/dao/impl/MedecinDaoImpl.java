package cabinet.medicale.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.DatabaseConnection;
import cabinet.medicale.dao.MedecinDao;
import cabinet.medicale.models.Medecin;
import javafx.scene.control.Alert;

public class MedecinDaoImpl implements MedecinDao {
	Statement statement;
	ResultSet resultSet;
	DatabaseConnection connection;
	String message = "l\'opération est terminée avec succès";

	public MedecinDaoImpl() {
		connection = DatabaseConnection.getInstance();
	}

	@Override
	public List<Medecin> getMedecins() {
		List<Medecin> medecins = new ArrayList<Medecin>();

		try {
			statement = connection.getConnection().createStatement();
			resultSet = statement.executeQuery("select * from Medecins");

			while (resultSet.next()) {
				Medecin medecin = new Medecin(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						resultSet.getString(5), resultSet.getString(4));
				medecins.add(medecin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medecins;
	}

	@Override
	public Medecin getMedecin(int id) {
		Medecin medecin = null;
		try {
			PreparedStatement preparedStatement = connection.getConnection()
					.prepareStatement("select * from Medecins where id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				medecin = new Medecin(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						resultSet.getString(5), resultSet.getString(4));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medecin;
	}

	@Override
	public void addMedecin(Medecin medecin) {
		try {
			String Query = "insert into Medcins values (?,?,?,?)";
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(Query);
			preparedStatement.setInt(1, medecin.getVersion());
			preparedStatement.setString(2, medecin.getTitre());
			preparedStatement.setString(3, medecin.getNom());
			preparedStatement.setString(4, medecin.getPrenom());
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				new Alert(Alert.AlertType.INFORMATION, message).showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	@Override
	public void updateMedecin(Medecin medecin) {
		try {
			String Query = "Update Medecins set virsion = ? ,titre=?,nom=?,prenom=? where id = ?";
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(Query);
			preparedStatement.setInt(1, medecin.getVersion());
			preparedStatement.setString(2, medecin.getTitre());
			preparedStatement.setString(3, medecin.getNom());
			preparedStatement.setString(4, medecin.getPrenom());
			preparedStatement.setInt(5, medecin.getId());
			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
				new Alert(Alert.AlertType.INFORMATION, message).showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	@Override
	public void deleteMedecin(int id) {
		try {
			String Query = "Delete from Medecins where id = ?";
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(Query);
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
