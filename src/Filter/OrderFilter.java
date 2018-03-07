package Filter;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.FormatUtil;

/**
 * Servlet Filter implementation class OrderFilter
 */
@WebFilter("/OrderFilter")
public class OrderFilter implements Filter {

    /**
     * Default constructor. 
     */
    public OrderFilter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("进入订单过滤器");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		String directive = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		switch (directive) {
		case "query":
			String querytype=req.getParameter("querytype");
			String queryinfo=req.getParameter("queryinfo");
				if(!queryinfo.equals("")){
					if(querytype.equals("3")){
					try {
						if(!FormatUtil.checkidno(queryinfo)){
							req.setAttribute("notice", "<script>alert('身份证号格式错误')</script>");
							req.getRequestDispatcher("/HKProject/orderquery.jsp").forward(req, resp);
							return;
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}else{}
			}else{
				req.getRequestDispatcher("/HKProject/orderquery.jsp").forward(req, resp);
				return;
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
