package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = "/MainServlet.do")
public class MainServlet extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String name = req.getParameter("moetje");

    PrintWriter out = res.getWriter();
    res.setContentType("text/html");

    out.println("<h1>" + name + "</h1>");
  }
}

