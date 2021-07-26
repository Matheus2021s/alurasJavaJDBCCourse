package br.com.mariah.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.mariah.model.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {
		String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)";
		try (PreparedStatement prepareStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			prepareStatement.setString(1, produto.getNome());
			prepareStatement.setString(2, produto.getDescricao());

			prepareStatement.execute();
			ResultSet generatedKeys = prepareStatement.getGeneratedKeys();

			while (generatedKeys.next()) {
				produto.setId(generatedKeys.getInt(1));
			}
		}
	}
	
	public List<Produto> listar () throws SQLException{
		List<Produto> retorno = new ArrayList<Produto>();
		String  sql = "SELECT * FROM PRODUTO";
		try ( PreparedStatement preparedStatement = this.connection.prepareStatement(sql) ){
			preparedStatement.execute();
			
			ResultSet resultSet = preparedStatement.getResultSet();
			
			while (resultSet.next()) {
				retorno.add(criaProduto(resultSet));
			}
		
		}
		
		return retorno;
		
	}

	private Produto criaProduto(ResultSet resultSet) throws SQLException {
		Produto produto = new Produto();
		produto.setId(resultSet.getInt("id"));
		produto.setNome(resultSet.getString("nome"));
		produto.setDescricao(resultSet.getString("descricao"));
		return produto;
	}
}
