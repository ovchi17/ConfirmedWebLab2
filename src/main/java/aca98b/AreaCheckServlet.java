package aca98b;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

@WebServlet(name = "areaCheckServlet", value = "/areaCheckServlet")
public class AreaCheckServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            float x = Float.parseFloat(request.getParameter("x"));
            float y = Float.parseFloat(request.getParameter("y"));
            float r = Float.parseFloat(request.getParameter("r"));
            long scriptStart = System.nanoTime();
            float[] arrayOfX = {-2, -1.5f, -1, -0.5f, 0, 0.5f, 1, 1.5f, 2};
            float[] arrayOfR = {1, 1.5f, 2, 2.5f, 3};
            if (inArr(x, arrayOfX) && inArr(r, arrayOfR) && y > -5 && y < 5){
                String res = ifEnter(x, y, r);
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String curTime = sdf.format(new Date());
                String scriptTime = String.format("%.2f", (double) (System.nanoTime() - scriptStart) * 0.0001);
                OneElement el = new OneElement(x, y, r, res, curTime, scriptTime);
                BeanSessionStorage bSS = (BeanSessionStorage) request.getAttribute("bss");
                BeanSessionStorage cur = new BeanSessionStorage(bSS.getArr());
                cur.addNewElement(el);
                System.out.println(cur.sizeOfArr());
                getServletContext().setAttribute("res", cur.getArr());
                getServletContext().setAttribute("lastInfo", el);
                request.setAttribute("bss", cur);
            }
        } catch (Exception e) {
            getServletContext().setAttribute("errorInfo", e.getMessage());
            System.out.println(e.getMessage());
            request.getServletContext().getRequestDispatcher("/errorInfo.jsp").forward(request, response);
        }

    }

    public boolean inArr(float ch, float[] arr){
        boolean res = false;
        for (float x : arr) {
            if (x == ch) {
                res = true;
                break;
            }
        }
        return res;
    }

    public static String ifEnter(float x, float y, float r) {
        String resultF = "false";

        if (x >= 0 && y <= 0) {
            if ((-1 * y) + x <= r / 2) {
                resultF = "true";
            }
        }

        if (x <= 0 && y <= 0) {
            if (x >= -r && y >= (-r / 2)) {
                resultF = "true";
            }
        }

        if (x >= 0 && y >= 0) {
            if (x <= r / 2 && y <= r / 2 && (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r / 2, 2))) {
                resultF = "true";
            }
        }

        return resultF;
    }

}
