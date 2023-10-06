package aca98b;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "urlInfo", value = "/urlInfo")
public class UrlServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            System.out.println("success");
        } catch (Exception e) {
            getServletContext().setAttribute("errorInfo", e.getMessage());
            System.out.println(e.getMessage());
            request.getRequestDispatcher("/errorInfo.jsp").forward(request, response);
        }
    }
}
