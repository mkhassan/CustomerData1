import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class MySQLHelper {

	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	private Connection dbConnection;
	
	public MySQLHelper(String dbUrl, String dbUsername, String dbPassword) {
		this.dbUrl = dbUrl;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}
	
	protected void connect() throws SQLException {
		if (dbConnection == null || dbConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			dbConnection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		}
	}
	protected void disconnect() throws SQLException {
		if (dbConnection != null && !dbConnection.isClosed()){
			dbConnection.close();
		}
	}
	
	public boolean addCustomer(Customer customer) throws SQLException{
		String sql = " INSERT INTO customers (title, firstname, lastname,address,city,state, zipcode,"
				+ "email,position, company VALUES (?,?,?,?,?,?,?,?,?)";
		connect();
		
		PreparedStatement stm = dbConnection.prepareStatement(sql);
		stm.setString(1, customer.getTitle());
		stm.setString(2, customer.getFirstname());
		stm.setString(3, customer.getLastname());
		stm.setString(4, customer.getAddress());
		stm.setString(5, customer.getCity());
		stm.setString(6, customer.getState());
		stm.setString(7, customer.getZipcode());
		stm.setString(8, customer.getEmail());
		stm.setString(9, customer.getPosition());
		stm.setString(10,customer.getCompany());
		
		boolean customerAdded = stm.executeUpdate() > 0;
		stm.close();
		disconnect();
		return customerAdded;
		
	}
	
	public boolean deleteCustomer(Customer customer) throws SQLException {
		String sql = "DELETE FROM Customers.customers WHERE CustomerID = ? AND LastName = ?";
		
		connect();
		PreparedStatement stm = dbConnection.prepareStatement(sql);
		stm.setString(1, customer.getCustomerid());
		stm.setString(2,  customer.getLastname());
		boolean customerDeleted = stm.executeUpdate() > 0;
		stm.close();
		disconnect();
		return customerDeleted;	
	}
	
	public boolean updateCustomer(Customer customer) throws SQLException {
		String sql = "UPDATE customers SET title = ?,firstname =?, lastname=?,address =?,city=?,state =?,"
				+ " zipcode =?,email=?,position=?, company=?  WHERE CustomerID = ?";
		connect();
		
		PreparedStatement stm = dbConnection.prepareStatement(sql);
		stm.setString(1, customer.getTitle());
		stm.setString(2, customer.getFirstname());
		stm.setString(3, customer.getLastname());
		stm.setString(4, customer.getAddress());
		stm.setString(5, customer.getCity());
		stm.setString(6, customer.getState());
		stm.setString(7, customer.getZipcode());
		stm.setString(8, customer.getEmail());
		stm.setString(9, customer.getPosition());
		stm.setString(10,customer.getCompany());
		stm.setString(11, customer.getCustomerid());
      
		boolean customerUpdated = stm.executeUpdate() > 0;
		stm.close();
		disconnect();
		return customerUpdated;
		
	}
	
	public List<Customer> listCustomers() throws SQLException{
		List<Customer> listCustomer = new ArrayList<>();
		
		String sql = "SELECT * FROM customers LIMIT 10";
		
		connect();
		Statement stm = dbConnection.createStatement();
		ResultSet resultSet = stm.executeQuery(sql);
		
		while (resultSet.next()) {
			String firstname = resultSet.getString("FirstName");
			String lastname = resultSet.getString("LastName");
			String address = resultSet.getString("StreetAddress");
			
		}
		
		
	}
	
}
