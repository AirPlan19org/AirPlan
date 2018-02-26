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

import DAO.UserDao;
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		System.out.println("进入总过滤器");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession ss=req.getSession();
		String usermail=(String) ss.getAttribute("usermail");
		String userstatus=null;
		if(usermail!=null){
			User user=UserDao.getUserByMail(usermail);
			if(user.getUserstatus().equals("0")){
				userstatus="[unActive]";
			}else if(user.getUserstatus().equals("1")){
				userstatus="[normal]";
			}else if(user.getUserstatus().equals("2")){
				userstatus="[limit]";
			}else{
				userstatus="[others]";
			}
			ss.setAttribute("userstatus", userstatus);
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
