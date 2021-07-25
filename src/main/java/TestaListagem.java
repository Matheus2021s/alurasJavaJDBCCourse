import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TestaListagem {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = 
				DriverManager
				.getConnection("jdbc:mysql://localhost/loja_virtual?useTimeZone=true&serverTimeZone=UTC", "root", "SenhaRoot@!123");

		Statement statement = connection.createStatement();
		statement.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		ResultSet resultSet = statement.getResultSet();
		while(resultSet.next()) {
			 int id = resultSet.getInt("ID");
			 String nome = resultSet.getString("NOME");
			 String descricao = resultSet.getString("DESCRICAO");
			 System.out.println(id + " - " + nome + " - " + descricao);
		}
		connection.close();
	}
}
