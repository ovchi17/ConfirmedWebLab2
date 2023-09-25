package aca98b;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cleanTable", value = "/cleanTable")
public class TableNoneServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            BeanSessionStorage bSS = (BeanSessionStorage) request.getAttribute("bss");
            BeanSessionStorage cur = new BeanSessionStorage(bSS.getArr());
            cur.nullTable();
            System.out.println(cur.sizeOfArr());
            getServletContext().setAttribute("res", cur.getArr());
            request.setAttribute("bss", cur);
        } catch (Exception e) {
            getServletContext().setAttribute("errorInfo", e.getMessage());
            System.out.println(e.getMessage());
            request.getServletContext().getRequestDispatcher("/errorInfo.jsp").forward(request, response);
        }
    }

}
