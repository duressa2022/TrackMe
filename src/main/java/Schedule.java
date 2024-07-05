

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
import java.sql.SQLException;
@WebServlet("/Schedule")
public class Schedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Schedule() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titleString=request.getParameter("title");
		String linkString=request.getParameter("link");
		String startingDateString=request.getParameter("startingDate");
		String endingDateString=request.getParameter("endingDate");
		String quoteString=request.getParameter("quote");
		if(titleString.equals("") || linkString.equals("")|| startingDateString.equals("")|| endingDateString.equals("") || quoteString.equals("") ) {
			response.sendRedirect("progess.jsp");
		}else {
			HttpSession session=request.getSession();
			String emailString=(String) session.getAttribute("email");
			Connection connection=null;
			PreparedStatement preparedStatement=null;
            String urlString = "jdbc:mysql://localhost:3306/informationdb";
            String userString = "root";
            String passtring = "root";
            System.out.println(emailString);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(urlString, userString, passtring);
                String queryString = "insert into informationdb.schedule(email,title,link,startingdate,endingdate,quote) values(?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(queryString);
                preparedStatement.setString(1, emailString);
                preparedStatement.setString(2,titleString );
                preparedStatement.setString(3, linkString);
                preparedStatement.setString(4, startingDateString );
                preparedStatement.setString(5, endingDateString);
                preparedStatement.setString(6, quoteString);
                preparedStatement.executeUpdate();
                response.sendRedirect("SuccessFul.jsp");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if (preparedStatement != null) {
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
}}}
