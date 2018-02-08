package Util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	HashMap<String, String> authMap=new HashMap<String,String>();
	public void sendMail(String to) throws IOException, MessagingException{
		String from="18428369524@163.com";
		String password="520lq1314";
		Properties props=new Properties();
		props.load(MailUtil.class.getResourceAsStream("/res/mail.properties"));
		Session session=Session.getInstance(props);
		session.setDebug(true);
		MimeMessage message=createMail(to, from, session);
		Transport transport=session.getTransport();
		transport.connect(from, password);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
	private MimeMessage createMail(String to,String from,Session session) throws UnsupportedEncodingException, MessagingException{
		String authno=authno();
		MimeMessage message=new MimeMessage(session);
		message.setFrom(new InternetAddress(from,"飞哪儿航空","utf-8"));
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to, "用户", "utf-8"));
		message.setSubject("用户验证","utf-8");
		message.setContent(authno,"utf-8");
		message.setSentDate(new Date());
		message.saveChanges();
		return message;
	}
	private String authno(){
		String authno="";
		Random r=new Random();
		for(int i=0;i<4;i++){
			authno=authno+r.nextInt(10);
		}
		return authno;
	}
}
