import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		Statement statement = connection.createStatement();
		
		statement.execute("DELETE FROM PRODUTO WHERE id > 2");
		
		int updateCount = statement.getUpdateCount();
		System.out.println("Quantidade de linhas modificadas: " + updateCount);
		
		
		connection.close();
	}
}
