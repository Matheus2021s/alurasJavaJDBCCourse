import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {

			try (Statement statement = connection.createStatement()) {
				statement.execute("INSERT INTO PRODUTO (nome, descricao,CATEGORIA_ID) VALUES ('cadeira','cadeira DE jantar',2)",
						Statement.RETURN_GENERATED_KEYS);

				ResultSet resultSet = statement.getGeneratedKeys();
				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					System.out.println("Id do produto criado: " + id);
				}
			}
		}
	}
}
