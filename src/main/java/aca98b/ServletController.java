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
            System.out.println(request.getParameter("clearF"));
            System.out.println("clearNo");
            request.getRequestDispatcher("/areaCheckServlet").forward(request, response);
        }
        beanSessionStorage = (BeanSessionStorage) request.getAttribute("bss");
    }
}
