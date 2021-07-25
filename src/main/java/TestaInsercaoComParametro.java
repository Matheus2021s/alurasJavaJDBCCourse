import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

		public static void main(String[] args) throws SQLException {
			ConnectionFactory connectionFactory = new ConnectionFactory();
			Connection connection = connectionFactory.recuperarConexao();
			
			String nome = "Curso";
			String descricao = "Curso JDBC Alura";
			
			PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1,nome);
			statement.setString(2, descricao);
			
			statement.execute();	
			
			ResultSet generatedKeys = statement.getGeneratedKeys();
		
			while (generatedKeys.next()) {
				System.out.println(generatedKeys.getInt(1));
			}
		}
}
