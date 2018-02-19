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

public class FormatUtil {
	static ArrayList<String> addrcode=null;
	static{
		ResultSet rs = null;
		Statement stm = null;
		Connection conn=null;
		try {
			addrcode=new ArrayList<String>();
			conn=DBUtil.getConn();
			String sql="select addno from addr";
			stm=conn.createStatement();
			rs=stm.executeQuery(sql);
			while(rs.next()){
				addrcode.add(rs.getString(1));
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(stm!=null)rs.close();
				if(conn!=null)rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//判断身份证号是否合法
	public static boolean checkidno(String idno) throws ParseException{
		//判断长度
		if(idno.length()!=18)return false;
		//判断合法行政区
		String saddcode=idno.substring(0,6);
		if(!addrcode.contains(saddcode))return false;
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
	//判断手机号是否合法
	public static boolean checkphone(String phone){
		
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
