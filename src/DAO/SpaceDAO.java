package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DoMain.Space;
import Util.DBUtil;

public class SpaceDAO {
	public static ArrayList<Space> getSpaceList(String flightNum){
		ArrayList<Space> spacelist=new ArrayList<Space>();
		Connection conn=null;
		ResultSet rs=null;
		Statement stm=null;
		try {
			conn=DBUtil.getConn();
			String sql="select * from space where flightNum='"+flightNum+"' order by spacePrice;";
			stm=conn.createStatement();
			rs=stm.executeQuery(sql);
			while(rs.next()){
				spacelist.add(new Space(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getString(8)));
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
		return spacelist;
	}
	public static Space getSpaceById(String spaceId){
		Connection conn=null;
		ResultSet rs=null;
		Statement stm=null;
		try {
			conn=DBUtil.getConn();
			String sql="select * from space where spaceId='"+spaceId+"';";
			stm=conn.createStatement();
			rs=stm.executeQuery(sql);
			if(rs.next()){
				return new Space(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getString(8));
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
		return null;
	}
}
