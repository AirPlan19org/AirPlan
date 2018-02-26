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

import DAO.UserDao;
import DoMain.User;
import Util.FormatUtil;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter("/UserFilter")
public class UserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		System.out.println("进入用户过滤器");
		String uri=req.getRequestURI();
		String directive=uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
		switch(directive){
		case "reg":
		String usermail=req.getParameter("usermail");
		String useridno=req.getParameter("useridno");
		String userpsw=req.getParameter("userpsw");
		try {
			int flag=0;
			User user=new User();
			user.setUsermail(usermail);
			user.setUseridno(useridno);
			if(UserDao.checkUser(user)!=null){
				req.setAttribute("exsistuser", "存在该用户");
				req.getRequestDispatcher("/HKProject/reg.jsp").forward(request, response);
				return;
			}
			if(!FormatUtil.checkidno(useridno)){
				flag=1;
				req.setAttribute("idnoerror", "身份证号不合法");
			}
			if(!FormatUtil.checkpsw(userpsw)){
				flag=1;
				req.setAttribute("pswerror", "密码格式不合法");
			}
			if(flag==1){
				req.getRequestDispatcher("/HKProject/reg.jsp").forward(request, response);
				return;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		chain.doFilter(req, resp);
		return;
		case "reget":
			if(req.getAttribute("usermail")==null&&req.getParameter("usermail")==null){
				resp.sendRedirect("/AirPlan/HKProject/index.jsp");
				return;
			}else{
				chain.doFilter(req, resp);
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
