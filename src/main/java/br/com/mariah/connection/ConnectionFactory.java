package br.com.mariah.connection;
import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimeZone=true&serverTimeZone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("SenhaRoot@!123");
		this.dataSource = comboPooledDataSource;
	
		comboPooledDataSource.setMaxPoolSize(15);
	}

	public Connection recuperarConexao() {
		try {
			return this.dataSource.getConnection();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
