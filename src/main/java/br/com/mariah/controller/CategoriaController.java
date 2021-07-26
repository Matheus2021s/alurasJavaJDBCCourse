package br.com.mariah.controller;

import java.sql.Connection;
import java.util.List;

import br.com.mariah.connection.ConnectionFactory;
import br.com.mariah.dao.CategoriaDAO;
import br.com.mariah.model.Categoria;

public class CategoriaController {

	private CategoriaDAO categoriaDAO;
	
	public CategoriaController() {
	 Connection connection = new ConnectionFactory().recuperarConexao();
	 this.categoriaDAO = new CategoriaDAO(connection);
	}
	
	public List<Categoria> listar()  {
		return this.categoriaDAO.listar();
	}
}
