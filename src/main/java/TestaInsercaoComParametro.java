import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();

		try (Connection connection = connectionFactory.recuperarConexao()) {
			connection.setAutoCommit(false);

			try (PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

				adicionarVariavel("smartTV", "televisao tela plana inteligente", statement);
				adicionarVariavel("som", "som vaio", statement);

				connection.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rolback em execução");
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement statement)
			throws SQLException {
		statement.setString(1, nome);
		statement.setString(2, descricao);

		statement.execute();

//			if (nome.equals("smartTV")) {
//				throw new IllegalArgumentException();
//			}
//			
		ResultSet generatedKeys = statement.getGeneratedKeys();

		while (generatedKeys.next()) {
			System.out.println(generatedKeys.getInt(1));
		}
	}
}
