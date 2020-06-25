import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/init")
public class InitServlet extends HttpServlet {
    @Inject
    private Student student;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        student.setName(request.getParameter("name"));
        student.setSurname(request.getParameter("surname"));
        response.sendRedirect(request.getContextPath() + "/print?");
    }
}