package br.com.mariah.controller;

import java.sql.Connection;
import java.util.List;

import br.com.mariah.connection.ConnectionFactory;
import br.com.mariah.dao.ProdutoDAO;
import br.com.mariah.model.Produto;

public class ProdutoController {

	private ProdutoDAO produtoDAO;

	public ProdutoController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.produtoDAO = new ProdutoDAO(connection);
	}

	public void deletar(Integer id) {
		this.produtoDAO.deletar(id);
	}

	public void salvar(Produto produto) {
		this.produtoDAO.salvar(produto);
	}

	public List<Produto> listar() {
		return this.produtoDAO.listar();
	}

	public void alterar(String nome, String descricao, Integer id) {
		this.produtoDAO.alterar(nome, descricao, id);
	}
}
