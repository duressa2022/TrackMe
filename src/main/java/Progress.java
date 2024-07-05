import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Progress")
public class Progress extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Progress() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();	
		session.setAttribute("email", session.getAttribute("email").toString());
        response.sendRedirect("progess.jsp");
    }
}
