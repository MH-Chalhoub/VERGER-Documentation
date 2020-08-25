package verger;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class DBHandlerVerger {
	private static final String DATABASE_NAME = "Verger_test";

    // Contacts table name
    private static final String TABLE_DEPENCE = "DEPENCE";
    private static final String TABLE_ENTRERS = "ENTRERS";
    private static final String TABLE_FACTURE = "FACTURE_DU_MARCHE";
    private static final String TABLE_RECEVOIE = "RECEVOIE";
    private static final String TABLE_COMPOSE = "COMPOSE";
    private static final String TABLE_PRODUIT = "PRODUIT";
    private static final String TABLE_A = "A";
    private static final String TABLE_EMPLOYE = "EMPLOYE";
    private static final String TABLE_TRAVAILLE_V = "TRAVAILLE_V";
    private static final String TABLE_TRAVAILLE_F = "TRAVAILLE_F";
    private static final String TABLE_SAISON = "SAISON";
    private static final String TABLE_VERGER = "VERGER";
    private static int depence = 0;
	
	public DBHandlerVerger() {
		
	}
	/*================================================================================================================*/
	/* Table: DEPENCE                                              													  */
	/*================================================================================================================*/
	public ArrayList<Depence> getAllDepence() throws SQLException {
		Connection con = connectDB();
		if(con != null) {
			String query="SELECT * FROM "+ TABLE_DEPENCE +" ORDER BY DATED";

	        ArrayList<Depence> depences = new ArrayList<Depence>();
	        
	        Statement st = (Statement) con.createStatement();
	        ResultSet rs = st.executeQuery(query); //to use executeQuery you have to import java.sql.Statement;
	        
	        while (rs.next()) {
	        	depences.add(new Depence(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7), rs.getString(8)));
	        }
	        
	        disconnectDB(con);
	        return depences;
		}
        return null;
	}
	
	public ArrayList<Depence> getFromToDepence(String date_start, String date_end) throws SQLException {
		Connection con = connectDB();
		if(con != null) {
			String query="SELECT * FROM "+ TABLE_DEPENCE +" WHERE DATED>='" + date_start + "' AND DATED<='" + date_end + "'" +" ORDER BY DATED";

	        ArrayList<Depence> depences = new ArrayList<Depence>();
	        
	        Statement st = (Statement) con.createStatement();
	        ResultSet rs = st.executeQuery(query); //to use executeQuery you have to import java.sql.Statement;
	        
	        while (rs.next()) {
	        	depences.add(new Depence(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7), rs.getString(8)));
	        }
	        
	        disconnectDB(con);
	        return depences;
		}
        return null;
	}
	
	public float getSumDepenceMontant(String date_start, String date_end) throws SQLException {
		Connection con = connectDB();
		if(con != null) {
			String query="SELECT * FROM "+ TABLE_DEPENCE +" WHERE DATED>='" + date_start + "' AND DATED<='" + date_end + "'";
			
			float total = 0;
	        
	        Statement st = (Statement) con.createStatement();
	        ResultSet rs = st.executeQuery(query); //to use executeQuery you have to import java.sql.Statement;
	        
	        while (rs.next()) {
	        	total += rs.getFloat(6);
	        }
	        
	        disconnectDB(con);
	        return total;
		}
        return 0;
	}
	
	public float getAllSumDepenceMontant() throws SQLException {
		Connection con = connectDB();
		if(con != null) {
			String query="SELECT * FROM "+ TABLE_DEPENCE;
			
			float total = 0;
	        
	        Statement st = (Statement) con.createStatement();
	        ResultSet rs = st.executeQuery(query); //to use executeQuery you have to import java.sql.Statement;
	        
	        while (rs.next()) {
	        	total += rs.getFloat(6);
	        }
	        
	        disconnectDB(con);
	        return total;
		}
        return 0;
	}
	
	public void addDepence(Depence d) throws SQLException {

		Connection con = connectDB();
		if(con != null) {
		//int veg = (c.getVeg() == true)?1:0;
			String query = "INSERT INTO " + TABLE_DEPENCE + " VALUES('" + d.getLocation() + "','" + d.getDate() + "','" + d.getPayePour() + "','" + d.getArticle() + "'," + d.getMontant() + ",'" + d.getMachine() + "','" + d.getNote() + "');";
			//String query = "insert into DEPENCE values(3,'','','','',12,'','');";
			Statement st = con.createStatement();
			st.executeUpdate(query);
			depence++;
			disconnectDB(con); // Closing database connection
		}
		
    }
	
	public void suppDepence(int id) throws SQLException {
		Connection con = connectDB();
		if(con != null) {
			String query = "DELETE FROM " + TABLE_DEPENCE + " WHERE IDD=" + id;
			Statement st = con.createStatement();
			st.executeUpdate(query);
			disconnectDB(con); // Closing database connection
		}
	}
	
	public void updateDepence(int id,Depence d) throws SQLException {
		Connection con = connectDB();
		if(con != null) {
			String query = "UPDATE " + TABLE_DEPENCE + " SET DATED='" + d.getDate() + "',NOMV='" + d.getLocation() + "',PAYE_POUR='" + d.getPayePour() + "',ARTICLE='" + d.getArticle() + "',MONTANTD=" + d.getMontant() + ",MACHINE='" + d.getMachine() + "',NOTED='" + d.getNote()  +  "' WHERE IDD=" + id;
			
			Statement st = con.createStatement();
			st.executeUpdate(query);
			disconnectDB(con); // Closing database connection
		}
	}
	
	public Depence getDepence(int id) throws SQLException {
		Connection con = connectDB();
		if(con != null) {
			String query="SELECT * FROM "+TABLE_DEPENCE;
			
			Depence dep = null;
			
	        Statement st = (Statement) con.createStatement();
	        ResultSet rs = st.executeQuery(query); //to use executeQuery you have to import java.sql.Statement;
	        
	        while (rs.next()) {
	        	if(id == rs.getInt(1))
	        		dep = new Depence(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7), rs.getString(8));
	        }
	        
	        disconnectDB(con);
	        return dep;
		}
        return null;
	}
	
	/*================================================================================================================*/
	/* Table: VERGER                                        												          */
	/*================================================================================================================*/
	
	public ArrayList<Verger> getAllVerger() throws SQLException {
		Connection con = connectDB();
		if(con != null) {
			String query="SELECT * FROM "+ TABLE_VERGER +" ORDER BY NOMV";

	        ArrayList<Verger> vergers = new ArrayList<Verger>();
	        
	        Statement st = (Statement) con.createStatement();
	        ResultSet rs = st.executeQuery(query); //to use executeQuery you have to import java.sql.Statement;
	        
	        while (rs.next()) {
	        	vergers.add(new Verger(rs.getString(1), rs.getFloat(2), rs.getString(3)));
	        }
	        
	        disconnectDB(con);
	        return vergers;
		}
        return null;
	}
	
	public void addVerger(Verger v) throws SQLException {

		Connection con = connectDB();
		if(con != null) {
			String query = "INSERT INTO " + TABLE_VERGER + " VALUES('" + v.getNom() + "'," + v.getSurface() + ",'" + v.getLocation() + "');";
			//String query = "insert into DEPENCE values(3,'','','','',12,'','');";
			Statement st = con.createStatement();
			st.executeUpdate(query);
			disconnectDB(con); // Closing database connection
		}
		
    }
	
	public void suppVerger(String nom) throws SQLException {
		Connection con = connectDB();
		if(con != null) {
			String query = "DELETE FROM " + TABLE_VERGER + " WHERE NOMV='" + nom + "'";
			Statement st = con.createStatement();
			st.executeUpdate(query);
			disconnectDB(con); // Closing database connection
		}
	}
	
	public void updateVerger(String nom,Verger v) throws SQLException {
		Connection con = connectDB();
		if(con != null) {
			String query = "UPDATE " + TABLE_VERGER + " SET NOMV='" + v.getNom() + "',SURFACEV=" + v.getSurface() + ",LOCATIONV='" + v.getLocation() + "' WHERE NOMV='" + nom + "'";
			
			Statement st = con.createStatement();
			st.executeUpdate(query);
			disconnectDB(con); // Closing database connection
		}
	}
	
	/*================================================================================================================*/
	/* Table: EMPLOYE                                         												          */
	/*================================================================================================================*/
	
	public ArrayList<Employe> getAllEmploye() throws SQLException {
		Connection con = connectDB();
		if(con != null) {
			String query="SELECT * FROM "+ TABLE_EMPLOYE +" ORDER BY IDEM";

	        ArrayList<Employe> Employes = new ArrayList<Employe>();
	        
	        Statement st = (Statement) con.createStatement();
	        ResultSet rs = st.executeQuery(query); //to use executeQuery you have to import java.sql.Statement;
	        
	        while (rs.next()) {
	        	Employes.add(new Employe(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
	        }
	        
	        disconnectDB(con);
	        return Employes;
		}
        return null;
	}

	public void addEmploye(Employe e) throws SQLException {

		Connection con = connectDB();
		if(con != null) {
		//int veg = (c.getVeg() == true)?1:0;
			String query = "INSERT INTO " + TABLE_EMPLOYE + " VALUES('" + e.getnomV() + "','" + e.getPrenom() + "','" + e.getnom() + "','" + e.getDateExpSejour() + "'," + e.getMode() + ");";
			//String query = "insert into DEPENCE values(3,'','','','',12,'','');";
			Statement st = con.createStatement();
			st.executeUpdate(query);
			disconnectDB(con); // Closing database connection
		}
		
    }

	public void suppEmploye(int id) throws SQLException {
		Connection con = connectDB();
		if(con != null) {
			String query = "DELETE FROM " + TABLE_EMPLOYE + " WHERE IDEM=" + id;
			Statement st = con.createStatement();
			st.executeUpdate(query);
			disconnectDB(con); // Closing database connection
		}
	}
	
	public void updateEmploye(int id,Employe e) throws SQLException {
		Connection con = connectDB();
		if(con != null) {
			String query = "UPDATE " + TABLE_EMPLOYE + " SET NOMV='" + e.getnomV() + "',PRENOMEM='" + e.getPrenom() + "',NOMEM='" + e.getnom() + "',DATE_EXP_SEJOUR='" + e.getDateExpSejour() + "',MODE_DE_PAYEMENT=" + e.getMode() + " WHERE IDEM=" + id;
			
			Statement st = con.createStatement();
			st.executeUpdate(query);
			disconnectDB(con); // Closing database connection
		}
	}
	
	/*================================================================================================================*/
	/*================================================================================================================*/
	/*================================================================================================================*/
	public Connection connectDB() {
		Connection con = null;
		String url = "jdbc:sqlserver://localhost;databaseName=" + DATABASE_NAME + ";integratedSecurity=true;";	//THE database have to be created before you test the connection
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url);
		}
		catch(SQLException | ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Impossible to connect" + ex.toString());
		}
		return con;
	}
	
	public void disconnectDB(Connection con) {
		if(con != null) {
			try {
				con.close();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
}

