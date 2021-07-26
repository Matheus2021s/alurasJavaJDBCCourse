import java.sql.Connection;
import java.sql.SQLException;

import br.com.mariah.dao.ProdutoDAO;
import br.com.mariah.model.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {
			Produto comoda  =  new Produto("comoda", "comoda amarela");
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			
			produtoDAO.salvar(comoda);
			System.out.println(produtoDAO.listar());
			
			
		}
	}
}
