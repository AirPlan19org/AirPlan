package Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;
import DoMain.User;

public class UserReg extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String useridno=req.getParameter("useridno");
		String userphone=req.getParameter("userphone");
		String usermail=req.getParameter("usermail");
		String userpsw=req.getParameter("userpsw");
		String useraddr=req.getParameter("useraddr");
		User user=new User();
		user.setUsername(username);
		user.setUseridno(useridno);
		user.setUsermail(usermail);
		user.setUserphone(userphone);
		user.setUserpsw(userpsw);
		user.setUseraddr(useraddr);
		UserDao.addUser(user);
		resp.sendRedirect("/Airplan/HKProject/index.html");
	}
}
