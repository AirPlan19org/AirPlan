package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class PlaneFilter
 */
@WebFilter("/PlaneFilter")
public class PlaneFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public PlaneFilter() {
		// TODO Auto-generated constructor stub
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("进入航班过滤器");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		String directive = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		switch (directive) {
		case "passenger":
			HttpSession ss=req.getSession();
			String usermail=(String) ss.getAttribute("usermail");
			String userstatus=(String) ss.getAttribute("userstatus");
			if(usermail==null||userstatus==null){
				req.setAttribute("notice", "<script>alert('请先登录')</script>");
				req.getRequestDispatcher("/HKProject/login.jsp").forward(req, resp);
				return;
			}
			if(!userstatus.equals("[normal]")){
				req.setAttribute("notice", "<script>alert('请先激活用户')</script>");
				req.getRequestDispatcher("/HKProject/user.jsp").forward(req, resp);
				return;
			}
			if(req.getParameter("spaceId")==null){
				req.setAttribute("notice", "<script>alert('请先预定机票')</script>");
				req.getRequestDispatcher("/HKProject/SearchPlane.jsp").forward(req, resp);
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
