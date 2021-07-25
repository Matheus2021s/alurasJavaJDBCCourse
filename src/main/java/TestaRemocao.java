import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		Integer id = 14;
		
		PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM PRODUTO WHERE id = ?");
		prepareStatement.setInt(1, id);
		prepareStatement.execute();
		
		int updateCount = prepareStatement.getUpdateCount();
		System.out.println("Quantidade de linhas modificadas: " + updateCount);
		
		
		prepareStatement.close();
		connection.close();	
	}
}
