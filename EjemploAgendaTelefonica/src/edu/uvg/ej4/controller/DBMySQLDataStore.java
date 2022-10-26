/**
 * 
 */
package edu.uvg.ej4.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author MAAG
 *
 */
public class DBMySQLDataStore extends DataStore {

	private Connection conn;
	private String db_server;
	private String db_database;
	private String db_username;
	private String db_password;
	
	public DBMySQLDataStore(Agenda _agenda) {
		super();
				
		setAgenda(_agenda);
		
		db_server = "localhost";
		db_database = "agenda";
		db_username = "root";
		db_password = "";
	}
	
	
	@Override
	public boolean initializeDS() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection("jdbc:mysql://" + db_server + "/" + db_database + "?" +
			                                   "user=" + db_username + "&password="+db_password);

		return true;
	}

	@Override
	public boolean finalizeDS() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveData() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void getData() throws Exception {
		
		Statement stmt = null;
		ResultSet rs = null;

		try {
		    stmt = conn.createStatement();
		    
		    //Quiero ir a traer todos los contactos
		    rs = stmt.executeQuery("select id, firstname, lastname, owner from contact");
		    
		    while (rs.next()) {
		    
		    	
		        int contact_id = rs.getInt("id");
		        String contact_firstname = rs.getString("firstname");
		        String contact_lastname = rs.getString("lastname");
		        String contact_owner = rs.getString("owner");
		        
		        if (getAgenda() == null) {
		        	setAgenda(new Agenda(contact_owner));
		        }
		        
		        //Voy a traer los telefonos
		        ResultSet rs2 = null;
		        Statement stmt2 = conn.createStatement();
		        
		        
		        rs2 = stmt2.executeQuery("select phonenumber, type, id_usuario from phone where id_usuario = " + contact_id);
		        
		        while (rs2.next()) {
		        	int contact_phonenumber = rs2.getInt("phonenumber");
		        	String contact_phonetype = rs2.getString("type");
		        	getAgenda().saveNewContactOnlyPhone(contact_firstname, contact_lastname, contact_phonenumber , contact_phonetype);
		        }
		        
		        //Voy a traer los emails
		        rs2 = stmt2.executeQuery("select emailaddress, type, id_usuario from email where id_usuario = " + contact_id);
		        
		        while (rs2.next()) {
		        	String contact_emailaddress = rs2.getString("emailaddress");
		        	String contact_emailtype = rs2.getString("type");
		        	getAgenda().saveNewContactOnlyEmail(contact_firstname, contact_lastname, contact_emailaddress, contact_emailtype);
		        }
		        
		        
		        
		        
		    }
		    
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		}

	}

}
