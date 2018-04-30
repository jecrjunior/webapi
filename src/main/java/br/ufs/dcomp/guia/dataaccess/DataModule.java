package br.ufs.dcomp.guia.dataaccess;

import java.sql.*;

public class DataModule {
    private static DataModule instance;
    public static DataModule getInstance(){
        return DataModule.instance == null ? 
            DataModule.instance = new DataModule() :
            DataModule.instance;
    }

    private Connection connection;

	public DataModule() {
		try {
			Class.forName("org.postgresql.Driver");
			this.openConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void openConnection() throws SQLException{
		String host = "10.20.8.50";
		String porta = "5432";
		String database = "cajuantibio";
        String user = "postgres";
        String password = "sqL@2014";
		        
        this.openConnection(host, porta, database, user, password);
    }

	public void openConnection(String host, String porta, String database, String user, String password) throws SQLException {
        String url = "jdbc:postgresql://"+ host + ":" + porta + "/" + database;
        this.connection = DriverManager.getConnection(url, user, password);
    }
	
	public void closeConnection() throws SQLException {
		this.connection.close();
	}
    
	public ResultSet executeQuery(String Query) throws SQLException {
		return this.connection.createStatement().executeQuery(Query);
	}

	public void executeStatment(String Query) throws SQLException {
		this.connection.createStatement().execute(Query);
	}
}