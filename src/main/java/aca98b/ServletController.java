package aca98b;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllerServlet", value = "/controllerServlet")
public class ServletController extends HttpServlet {

    private BeanSessionStorage beanSessionStorage;
    public ServletController(){
        beanSessionStorage = new BeanSessionStorage();
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("bss", beanSessionStorage);
        if (request.getParameter("clearF") != null){
            System.out.println("clearYes");
            request.getRequestDispatcher("/cleanTable").forward(request, response);
        }else{
            if (request.getParameter("urlInfo") != null){
                request.getRequestDispatcher("/urlInfo").forward(request, response);
            }else{
                request.getRequestDispatcher("/areaCheckServlet").forward(request, response);
            }
        }
        beanSessionStorage = (BeanSessionStorage) request.getAttribute("bss");
    }
}
