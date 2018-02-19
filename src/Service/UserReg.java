package Service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;
import DoMain.User;
import Util.MailUtil;

public class UserReg extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("text/html;charset=utf-8");
		resp.setContentType("utf-8");
		String to=req.getParameter("usermail");
		String uri=req.getRequestURI();
		String directive=uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
		switch(directive){
		case "authMail":
			try {
				MailUtil.sendMail(to);
			} catch (MessagingException e) {
				req.setAttribute("sendmailerror", "邮件发送失败");
				req.getRequestDispatcher("/HKProject/mailAuth.jsp");
				return;
			}
			break;
		case "active":
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String useridno=req.getParameter("useridno");
		String userphone=req.getParameter("userphone");
		String usermail=req.getParameter("usermail");
		String userpsw=req.getParameter("userpsw");
		String useraddr=req.getParameter("useraddr");
		User user=new User(null, username, useridno, userphone, useraddr, usermail, userpsw, "0", "0.00");
		UserDao.addUser(user);
		HttpSession s=req.getSession();
		s.setAttribute("user", user);
		req.getRequestDispatcher("").forward(req, resp);
	}
}
