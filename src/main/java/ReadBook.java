import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ReadBook")
public class ReadBook extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReadBook() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titleString = request.getParameter("title");
        System.out.println("title: " + titleString);
        
        PrintWriter outPrintWriter = response.getWriter();
        String result = "<html><head><title> This is newPage </title></head><body>";
        result += "<html>\r\n"
        		+ "<head>\r\n"
        		+ "    <title>PDF Viewer</title>\r\n"
        		+ "</head>\r\n"
        		+ "<body>\r\n"
        		+ "    <h1>PDF Viewer</h1>\r\n"
        		+ "    \r\n"
        		+ "    <iframe src=\"file:///C:/Users/HP/Documents/file/%20BankingSystem.pdf\" width=\"100%\" height=\"500px\" frameborder=\"0\"></iframe>\r\n"
        		+ "</body>\r\n"
        		+ "</html>";
        outPrintWriter.print(result);
       
        outPrintWriter.close();
    }
}
