

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.Console;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.jasper.compiler.ELInterpreterFactory;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailString=request.getParameter("email");
		String passString=request.getParameter("password");
		if(emailString.equals("") || passString.equals("")) {
			response.sendRedirect("Login_page.jsp");
		}else {
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;
            String urlString = "jdbc:mysql://localhost:3306/informationdb";
            String userString = "root";
            String passtring = "root";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection=DriverManager.getConnection(urlString,userString,passtring);
				String queryString="select email,password from informationdb.userinformation where email=? and password=?";
				preparedStatement=connection.prepareStatement(queryString);
				preparedStatement.setString(1, emailString);
				preparedStatement.setString(2, passString);
				resultSet=preparedStatement.executeQuery();
				if(resultSet.next()) {
					HttpSession session=request.getSession();	
					session.setAttribute("email", emailString);
                    response.sendRedirect("Home_page.jsp");	
			    }else {
			    	response.sendRedirect("Login_page.jsp");			    }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(resultSet!=null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
			    }if(preparedStatement!=null) {
			    	try {
						preparedStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }if(connection!=null) {
			    	try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}
		}
	}
}
