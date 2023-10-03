package aca98b;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebFilter("/*")
public class UrlCounterFilter implements Filter {

    private Map<String, Integer> resultTable = new LinkedHashMap<>();
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{

        String urlPath = ((HttpServletRequest)request).getRequestURL().toString();
        System.out.println(urlPath);

        if (resultTable.get(urlPath) == null){
            resultTable.put(urlPath, 1);
        }else{
            resultTable.put(urlPath, resultTable.get(urlPath) + 1);
        }
        System.out.println(resultTable);
        ServletContext servletContext = filterConfig.getServletContext();
        servletContext.setAttribute("urlInfos", resultTable);
        servletContext.setAttribute("urlKeys", resultTable.keySet());
        chain.doFilter(request, response);
    }
}
