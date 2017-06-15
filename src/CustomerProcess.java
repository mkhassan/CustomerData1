

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerProcess
 */
@WebServlet("/CustomerProcess")
public class CustomerProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MySQLHelper mySqlhelper;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerProcess() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
			//String dbUrl = getServletContext().getInitParameter("dbUrl");
			//String dbUsername = getServletContext().getInitParameter("dbUsername");
			//String dbPassword = getServletContext().getInitParameter("dbPassword");
			
mySqlhelper = new MySQLHelper("jdbc:mysql://localhost/Customers", "mkhassan", "yahayyu1");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		try {
			switch(action) {
			case "/new":
				showNewForm(request, response);
				break;
				
			case "/edit":
				showEditForm(request,response);
				break;
				
			case "/insert":
				insertCustomer(request, response);
				break;
				
			case "/update":
				updateCustomer(request, response);
				
			default:
				listCustomer(request, response);
				break;
					
				
			}
			} catch(SQLException ex) {
				throw new ServletException(ex);
			}
		}
		
		private void showNewForm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("output.jsp");
		dispatcher.forward(request, response);
		}
		
		
		private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, ServletException, IOException {
			String custid = request.getParameter("customerid");
			String Lname = request.getParameter("LastName");
			Customer existingCustomer = mySqlhelper.getCustomer(custid, Lname);
			request.setAttribute("customer", existingCustomer);
			RequestDispatcher dispatcher = request.getRequestDispatcher("output.jsp");
			dispatcher.forward(request, response);
		}
		
		private void listCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
				List<Customer> listCustomer = mySqlhelper.listCustomers();
				request.setAttribute("customerslist", listCustomer);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("output.jsp");
				dispatcher.forward(request, response);
			}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
        private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException {
        	String jtitle = request.getParameter("ftitle");
        	String jfirstname = request.getParameter("ffirstname");
        	String jlastname = request.getParameter("flastname");
        	String jAddress = request.getParameter("fAddress");
        	String jcity = request.getParameter("fcity");
        	String jstate = request.getParameter("fstate");
    	    String jzipcode = request.getParameter("fzipcode");
    	    String jemail = request.getParameter("femail");
            String jposition = request.getParameter("fposition");
    		String jcompany = request.getParameter("fcompany");
    		
    		Customer newCustomer = new Customer(jtitle,jfirstname,jlastname, jcity,jstate,jemail, 
    				jposition, jcompany, jAddress, jzipcode);
    		mySqlhelper.addCustomer(newCustomer);
    		response.sendRedirect("list");
        }
        
        private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException {
        	
        	String jtitle = request.getParameter("ftitle");
        	String jfirstname = request.getParameter("ffirstname");
        	String jlastname = request.getParameter("flastname");
        	String jAddress = request.getParameter("fAddress");
        	String jcity = request.getParameter("fcity");
        	String jstate = request.getParameter("fstate");
    	    String jzipcode = request.getParameter("fzipcode");
    	    String jemail = request.getParameter("femail");
            String jposition = request.getParameter("fposition");
    		String jcompany = request.getParameter("fcompany");
    		
    		Customer upCustomer = new Customer(jtitle,jfirstname,jlastname, jcity,jstate,jemail, 
    				jposition, jcompany, jAddress, jzipcode);
    		mySqlhelper.updateCustomer(upCustomer);
        	
        }


}
