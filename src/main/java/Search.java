

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Search() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String emailString=(String) session.getAttribute("email");	
		String titleString=request.getParameter("searchValue");	
		System.out.println(titleString);
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
        String urlString = "jdbc:mysql://localhost:3306/informationdb";
        String userString = "root";
        String passtring = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(urlString, userString, passtring);
            String queryString = "select * from informationdb.schedule where email=? and title=?";
            preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setString(1, emailString);
            preparedStatement.setString(2, titleString);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
            	String titleResultString=resultSet.getString("title");
            	String linkString=resultSet.getString("link");
            	String startString=resultSet.getString("startingDate");
            	String endString=resultSet.getString("endingDate");
            	String quoteString=resultSet.getString("quote");
            	request.setAttribute("titleHolder", "book Title: ".toUpperCase()+titleResultString);
            	request.setAttribute("linkHolder", "book link: ".toUpperCase()+linkString);  
            	request.setAttribute("startHolder", "Starting Date: ".toUpperCase()+startString)   ;
            	request.setAttribute("endHolder", "Ending date: ".toUpperCase()+endString);
            	request.setAttribute("quoteHolder", "Quote: ".toUpperCase()+quoteString);
            	request.setAttribute("ReadHolder", "Read");
            	request.setAttribute("Holder",linkString) ; 
            	System.out.println(linkString);
            	request.setAttribute("Enabled", "true");
            	request.getRequestDispatcher("Reader.jsp").forward(request, response);            	
            	
            }else {
            	request.setAttribute("Enabled", "false");
            	request.getRequestDispatcher("Reader.jsp").forward(request, response);
            }
            
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        	if(resultSet!=null) {
        		try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (connection != null) {
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
