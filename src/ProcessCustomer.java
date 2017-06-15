import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ProcessCustomer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MySQLHelper mysqlhelper;
	
	public ProcessCustomer() {
		
	}
	
	public void init() {
		//String dbUrl = getServletContext().getInitParameter("dbUrl");
		//String dbUsername = getServletContext().getInitParameter("dbUsername");
		//String dbPassword = getServletContext().getInitParameter("dbPassword");
		
		 mysqlhelper = new MySQLHelper("jdbc:mysql://localhost/Customers", "mkhassan", "yahayyu1");
	}
	
	
	

}
