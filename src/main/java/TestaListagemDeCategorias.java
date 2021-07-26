import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.mariah.dao.CategoriaDAO;
import br.com.mariah.model.Categoria;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {

			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> categorias = categoriaDAO.listarComProduto();
			for (Categoria categoria : categorias) {
				System.out.println(categoria);
			}
		}

	}
}
