package lab.servletsjspjstl;

import java.io.*;
import java.util.ArrayList;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
@WebServlet(name="HttpSessionServlet", value="/http-session-servlet")
public class HttpSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Object> notes = (ArrayList<Object>)session.getAttribute("notes");
        if (notes == null) {
            notes = new ArrayList<>();
            session.setAttribute("notes",notes);
        }
        String note = request.getParameter("note");
        if (note != null)
            notes.add(note);
        PrintWriter out = response.getWriter();
        out.println("<html>"); out.println("<body>");
        out.println("<h1>My notes</h1>");
        out.println("<ul>");
        for (Object o : notes) out.println("<li>" + o);
        out.println("</ul>");
        out.println("<form>");
        out.println("<input type='text' name='note'/><br/>");
        out.println("<input type='submit' value='Add note'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
