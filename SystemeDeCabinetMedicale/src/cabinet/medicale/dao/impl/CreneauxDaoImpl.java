package cabinet.medicale.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.DatabaseConnection;
import cabinet.medicale.dao.CreneauDao;
import cabinet.medicale.dao.MedecinDao;
import cabinet.medicale.models.Creneau;
import javafx.scene.control.Alert;

public class CreneauxDaoImpl implements CreneauDao {
	Statement statement;
	ResultSet resultSet;
	DatabaseConnection connection;
	MedecinDao medecinDao;
	String message = "l\'opération est terminée avec succès";

	public CreneauxDaoImpl() {
		connection = DatabaseConnection.getInstance();
		medecinDao = new MedecinDaoImpl();
	}

	@Override
	public List<Creneau> getCreneaux() {
		List<Creneau> creneaux = new ArrayList<Creneau>();

		try {
			statement = connection.getConnection().createStatement();
			resultSet = statement.executeQuery("select * from Creaneaux");

			while (resultSet.next()) {
				Creneau C = new Creneau(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
						resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6),
						medecinDao.getMedecin(resultSet.getInt(7)));
				creneaux.add(C);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return creneaux;
	}

	@Override
	public void addCreneau(Creneau C) {
		try {
			String Query = "insert into Creaneaux values (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(Query);
			preparedStatement.setInt(1, C.getVersion());
			preparedStatement.setInt(2, C.getHdebut());
			preparedStatement.setInt(3, C.getMdebut());
			preparedStatement.setInt(4, C.getHfin());
			preparedStatement.setInt(5, C.getMfin());
			preparedStatement.setInt(6, C.getMedecin().getId());
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				new Alert(Alert.AlertType.INFORMATION, message).showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	@Override
	public void updateCreneau(Creneau C) {
		try {
			String Query = "Update Creaneaux set version = ? ,hdebut=?,mdebut=?,hfin=?,mfin=?,id_medecin = ? where ID = ?";
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(Query);
			preparedStatement.setInt(1, C.getVersion());
			preparedStatement.setInt(2, C.getHdebut());
			preparedStatement.setInt(3, C.getMdebut());
			preparedStatement.setInt(4, C.getHfin());
			preparedStatement.setInt(5, C.getMfin());
			preparedStatement.setInt(6, C.getMedecin().getId());
			preparedStatement.setInt(7, C.getId());
			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
				new Alert(Alert.AlertType.INFORMATION, message).showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	@Override
	public void deleteCreneau(int id) {
		try {
			String Query = "Delete from Creaneaux where id = ?";
			PreparedStatement pstmt = connection.getConnection().prepareStatement(Query);
			pstmt.setInt(1, id);
			int rowsDeleted = pstmt.executeUpdate();
			if (rowsDeleted > 0) {
				new Alert(Alert.AlertType.INFORMATION, message).showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public Creneau getCreneau(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
