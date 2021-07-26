import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.mariah.model.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {
			Produto comoda = new Produto("Comoda", "Comoda bege");

			String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS)) {

				prepareStatement.setString(1, comoda.getNome());
				prepareStatement.setString(2, comoda.getDescricao());

				prepareStatement.execute();
				ResultSet generatedKeys = prepareStatement.getGeneratedKeys();

				while (generatedKeys.next()) {
					comoda.setId(generatedKeys.getInt(1));
					System.out.println(comoda.toString());
				}
			}
		}
	}
}
