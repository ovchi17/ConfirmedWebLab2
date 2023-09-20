package aca98b;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllerServlet", value = "/controllerServlet")
public class ServletController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("clearF") != null){
            System.out.println("sdsd");
            request.getRequestDispatcher("/cleanTable").forward(request, response);
        }else{
            System.out.println(request.getParameter("clearF"));
            System.out.println("sdsddsdsdsd");
            request.getRequestDispatcher("/areaCheckServlet").forward(request, response);
        }
    }
}
