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
		String host = "127.0.0.1";
		String porta = "5432";
		String database = "sga";
        String user = "postgres";
        String password = "kamikaze";
		        
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
}