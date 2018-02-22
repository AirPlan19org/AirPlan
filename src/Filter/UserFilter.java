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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String usermail=request.getParameter("usermail");
		String useridno=request.getParameter("useridno");
		String userpsw=request.getParameter("userpsw");
		try {
			int flag=0;
			User user=new User();
			user.setUsermail(usermail);
			user.setUseridno(useridno);
			if(UserDao.checkUser(user)!=null){
				request.setAttribute("exsistuser", "存在该用户");
				request.getRequestDispatcher("/HKProject/reg.jsp").forward(request, response);
				return;
			}
			if(!FormatUtil.checkidno(useridno)){
				flag=1;
				request.setAttribute("idnoerror", "身份证号不合法");
			}
			if(!FormatUtil.checkpsw(userpsw)){
				flag=1;
				request.setAttribute("pswerror", "密码格式不合法");
			}
			if(flag==1){
				request.getRequestDispatcher("/HKProject/reg.jsp").forward(request, response);
				return;
			}
		} catch (ParseException e) {
			e.printStackTrace();
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
