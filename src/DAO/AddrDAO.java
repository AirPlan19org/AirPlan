package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DoMain.Addr;
import Util.DBUtil;

public class AddrDAO {
	private static ArrayList<Addr> addrlist=null;
	public static ArrayList<Addr> getaddrlist(){
		if(addrlist!=null)return addrlist;
		addrlist=new ArrayList<Addr>();
			ResultSet rs = null;
			Statement stm = null;
			Connection conn=null;
			try {
				conn=DBUtil.getConn();
				String sql="select * from addr";
				stm=conn.createStatement();
				rs=stm.executeQuery(sql);
				while(rs.next()){
					addrlist.add(new Addr(rs.getString(2), rs.getString(3)));
				}
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					if(rs!=null)rs.close();
					if(stm!=null)stm.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return addrlist;
	}
}
