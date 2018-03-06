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
import Util.FormatUtil;
import Util.MailUtil;

public class UserReg extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri=req.getRequestURI();
		String directive=uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
		User user=null;
		String usermail=null;
		String userpsw=null;
		String useridno=null;
		switch(directive){
		case "mailauth":
			usermail=req.getParameter("usermail");
			try {
				MailUtil.sendMail(usermail);
				req.setAttribute("usermail", usermail);
			} catch (MessagingException e) {
				req.setAttribute("sendmailerror", "邮件发送失败");
			}finally{
				req.setAttribute("autotime", "load()");
				req.getRequestDispatcher("/HKProject/mailAuth.jsp").forward(req, resp);
				return;
			}
		case "active":
			usermail=req.getParameter("usermail");
			String authno=req.getParameter("authno");
			if(authno!=null&&MailUtil.authMap.containsValue(authno)){
				MailUtil.authMap.remove(usermail);
				user=new User();
				user.setUsermail(usermail);
				user.setUserstatus("1");
				UserDao.adminUser(user);
				req.setAttribute("notice", "<script>alert('用户："+usermail+"激活成功')</script>");
				req.getRequestDispatcher("/HKProject/index.jsp").forward(req, resp);
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
		case "reget":
			usermail=req.getParameter("usermail");
			if(UserDao.getUserByMail(usermail)==null){
				req.setAttribute("authnoerror", "不存在该用户");
				req.getRequestDispatcher("/HKProject/mailAuth.jsp").forward(req, resp);
				return;
			}
			authno=req.getParameter("authno");
			if(authno!=null&&MailUtil.authMap.containsValue(authno)){
				MailUtil.authMap.remove(usermail);
				req.setAttribute("usermail", usermail);
				req.getRequestDispatcher("/HKProject/reget.jsp").forward(req, resp);
				return;
			}else{
				req.setAttribute("authnoerror", "验证码错误");
				req.getRequestDispatcher("/HKProject/mailAuth.jsp").forward(req, resp);
				return;
			}
		case "login":
			usermail=req.getParameter("usermail");
			userpsw=req.getParameter("userpsw");
			user=new User();
			user.setUsermail(usermail);
			user.setUserpsw(userpsw);
			user=UserDao.checkUser(user);
			if(user!=null){
				HttpSession ss=req.getSession();
				ss.setAttribute("usermail", usermail);
				resp.sendRedirect("/AirPlan/HKProject/index.jsp");
				return;
			}else{
				req.setAttribute("usermail", usermail);
				req.setAttribute("cannotin", "邮箱或者密码错误");
				req.getRequestDispatcher("/HKProject/login.jsp").forward(req, resp);
				return;
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getCharacterEncoding());
		String uri=req.getRequestURI();
		String directive=uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
		switch(directive){
		case "reg":
		String username=req.getParameter("username");
		String useridno=req.getParameter("useridno");
		String userphone=req.getParameter("userphone");
		String usermail=req.getParameter("usermail");
		String userpsw=req.getParameter("userpsw");
		String useraddr=req.getParameter("useraddr");
		User user=new User(null, username, useridno, userphone, useraddr, usermail, userpsw, "0", "0.00");
		UserDao.addUser(user);
		HttpSession ss=req.getSession();
		ss.setAttribute("usermail", usermail);
		req.setAttribute("notice", "<script>alert('注册成功')</script>");
		req.getRequestDispatcher("/HKProject/index.jsp").forward(req, resp);
		return;
		case "reset":
			usermail=req.getParameter("usermail");
			userpsw=req.getParameter("userpsw");
			if(!FormatUtil.checkpsw(userpsw)){
				req.setAttribute("errorpsw", "密码格式错误");
				req.getRequestDispatcher("/HKProject/reget.jsp").forward(req, resp);
				return;
			}else{
				user=new User();
				user.setUserpsw(userpsw);
				user.setUsermail(usermail);
				UserDao.resetUser(user);
				req.setAttribute("usermail", usermail);
				req.setAttribute("notice", "<script>alert('用户修改成功')</script>");
				req.getRequestDispatcher("/HKProject/login.jsp").forward(req, resp);
				return;
			}
		}
	}
}
