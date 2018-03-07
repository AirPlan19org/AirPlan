package Filter;

import java.io.IOException;
import java.util.ArrayList;

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

import DAO.OrderDao;
import DAO.UserDao;
import DoMain.Order;
import DoMain.User;

/**
 * Servlet Filter implementation class AllFilter
 */
@WebFilter("/AllFilter")
public class AllFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AllFilter() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		System.out.println("进入总过滤器");
		HttpSession ss = req.getSession();
		String usermail = (String) ss.getAttribute("usermail");
		String userstatus = null;
		if (usermail != null) {
			User user = UserDao.getUserByMail(usermail);
			if (user != null) {
				if (user.getUserstatus().equals("0")) {
					userstatus = "[unActive]";
				} else if (user.getUserstatus().equals("1")) {
					userstatus = "[Active]";
				} else if (user.getUserstatus().equals("2")) {
					userstatus = "[Limit]";
				} else {
					userstatus = "[Others]";
				}
				ss.setAttribute("userstatus", userstatus);
			}
		}
		String uri = req.getRequestURI();
		String directive = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		switch (directive) {
		case "orderquery":
			usermail = (String) req.getSession().getAttribute("usermail");
			if (usermail != null) {

				User user = UserDao.getUserByMail(usermail);
				ArrayList<Order> orderlist = OrderDao.getOrderList("3", user.getUseridno(), null);
				req.setAttribute("querytype", "3");
				req.setAttribute("queryinfo", user.getUseridno());
				req.setAttribute("orderlist", orderlist);
				req.getRequestDispatcher("/HKProject/orderquery.jsp").forward(req, resp);
				return;
			}
		}
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
