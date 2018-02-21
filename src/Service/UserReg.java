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
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		User user=null;
		String to=null;
		String uri=req.getRequestURI();
		String directive=uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
		switch(directive){
		case "mailauth":
			to=req.getParameter("usermail");
			try {
				MailUtil.sendMail(to);
			} catch (MessagingException e) {
				req.setAttribute("sendmailerror", "邮件发送失败");
				req.getRequestDispatcher("/HKProject/mailAuth.jsp");
				return;
			}
			break;
		case "active":
			to=req.getParameter("usermail");
			String authno=req.getParameter("authno");
			if(authno!=null&&MailUtil.authMap.containsValue(authno)){
				MailUtil.authMap.remove(to);
				user=new User();
				user.setUsermail(to);
				user.setUserstatus("1");
				UserDao.adminUser(user);
				resp.sendRedirect("/AirPlan/HKProject/index.html");
				return;
			}else{
				req.setAttribute("authnoerror", "验证码错误");
				req.getRequestDispatcher("/HKProject/mailAuth.jsp").forward(req, resp);
				return;
			}
		case "modify":
			user=new User();
			break;
		case "logout":
			req.getSession().invalidate();
			resp.sendRedirect("/AirPlan/HKProject/index.jsp");
			return;
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
		s.setAttribute("usermail", usermail);
		req.getRequestDispatcher("/HKProject/mailAuth.jsp").forward(req, resp);
		try {
			System.out.println(usermail);
			MailUtil.sendMail(usermail);
		} catch (MessagingException e) {
			req.setAttribute("sendmailerror", "邮件发送失败");
			req.getRequestDispatcher("/HKProject/mailAuth.jsp");
		}
		return;
	}
}
