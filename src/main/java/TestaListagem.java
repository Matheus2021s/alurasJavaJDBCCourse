import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {

			try (PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO")) {
				preparedStatement.execute();

				ResultSet resultSet = preparedStatement.getResultSet();
				while (resultSet.next()) {
					int id = resultSet.getInt("ID");
					String nome = resultSet.getString("NOME");
					String descricao = resultSet.getString("DESCRICAO");
					System.out.println(id + " - " + nome + " - " + descricao);
				}
			}
		}
	}
}
