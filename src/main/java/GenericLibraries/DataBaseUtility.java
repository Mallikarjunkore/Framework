package GenericLibraries;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

/**
 * This class contains reusable methods to perform actions on database
 * @author Mallikarjun
 *
 */

public class DataBaseUtility {
	Driver dbDriver=null;
	Connection connection=null;
	
	public void databaseInit(String url, String dbUser, String dbPwd) {
		try {
			dbDriver=new Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbDriver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection= DriverManager.getConnection(url,dbUser,dbPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to fetch the particular column data from the table
	 * @param Query 
	 * @param column 
	 * @throws SQLException 
	 */
	public  List<String> getDatabase(String Query, String column) throws SQLException{
	Statement statement=connection.createStatement();
	ResultSet result = statement.executeQuery(Query);
	
	List<String> list=new ArrayList();
	while(result.next()) {
		list.add(result.getString(column));
	}
	return list;
	}
	/**
	 * this method is used to update database
	 * @param Query 
	 * @return 
	 */
	public int modifyDatabase(String Query) {
		Statement statement=null;
		try {
			statement=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result=0;
		
		try {
			result= statement.executeUpdate(Query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
		
		public void closeDatabase() {
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	


