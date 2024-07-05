import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/RegisterData")
public class RegisterData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterData() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstString = request.getParameter("firstName");
        String lastString = request.getParameter("lastName");
        String emailString = request.getParameter("email");
        String password1String = request.getParameter("password");
        String password2String = request.getParameter("Repassword");
        if (firstString.equals("") || lastString.equals("") || emailString.equals("") || password1String.equals("") || password2String.equals("")) {
            response.sendRedirect("Register_page.jsp");
        } else if (password1String.equals(password2String)) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            String urlString = "jdbc:mysql://localhost:3306/informationdb";
            String userString = "root";
            String passtring = "root";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(urlString, userString, passtring);
                String queryString = "insert into informationdb.userinformation(firstname,lastname,email,password) values(?,?,?,?)";
                preparedStatement = connection.prepareStatement(queryString);
                preparedStatement.setString(1, firstString);
                preparedStatement.setString(2, lastString);
                preparedStatement.setString(3, emailString);
                preparedStatement.setString(4, password1String);
                preparedStatement.executeUpdate();
                response.sendRedirect("Login_page.jsp");
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
            System.out.println(firstString);}
        } else {
            response.sendRedirect("Register_page.jsp");
        }
    }
}

