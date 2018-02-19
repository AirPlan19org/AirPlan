package Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import DAO.AddrDAO;
import DoMain.Addr;

public class FormatUtil {
	public static ArrayList<Addr> addrlist=null;
	static{
		addrlist=new ArrayList<Addr>();
		addrlist=AddrDAO.getaddrlist();
	}
	//判断身份证号是否合法
	public static boolean checkidno(String idno) throws ParseException{
		System.out.println("正在验证身份证号");
		//判断长度
		if(idno.length()!=18)return false;
		//判断合法行政区
		String saddcode=idno.substring(0,6);
		Addr addr=new Addr("123", saddcode);
		if(!addrlist.contains(addr)){
			return false;
		}
		//判断数字
		String str=idno.substring(0,17);
		if(!isNum(str))return false;
		//判断是否年满18周岁
		String birthday=idno.substring(6,10);
		Calendar c=Calendar.getInstance();
		c.add(Calendar.YEAR, -18);
		Date date=c.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Date birth=sdf.parse(birthday);
		if(birth.getTime()>date.getTime())return false;
		//判断最末字符
		String endstr=idno.substring(17);
		if(!isNum(endstr)||!endstr.equals("x"))return false;
		return true;
	}
	//判断密码是否合法是否合法
	public static boolean checkpsw(String psw){
		System.out.println("正在验证密码");
		//判断字符长度8~20位
		if(psw.length()<8||psw.length()>20)return false;
		//判断密码是否为规定字符，并是否含有大小写
		int uptime=0;
		for(char p:psw.toCharArray()){
			int flag=0;
			if(p>'a'&&p<'z'||p=='_'||p>'0'&&p<'9'){
				flag=1;
			}
			if(p>'A'&&p<'Z'){
				flag=1;
				uptime=1;
			}
			if(flag==0)return false;
		}
		if(uptime==0)return false;
		return true;
	}
	private static boolean isNum(String str){
		for(char i:str.toCharArray()){
			if(i<'0'||i>'9')return false;
		}
		return true;
	}
	private static String getNow(){
		String now=null;
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		now=sdf.format(date);
		return now;
	}
}