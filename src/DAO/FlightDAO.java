package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DoMain.Flight;
import Util.DBUtil;

public class FlightDAO {
	public static ArrayList<Flight> getFightList(Flight flight){
		ArrayList<Flight> flightlist=new ArrayList<Flight>();
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement pstm=null;
		try {
			conn=DBUtil.getConn();
			String sql="select * from flight where startcity=? and arrivecity=? and startdate>=? and startdate<?;";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, flight.getStartCity());
			pstm.setString(2, flight.getArriveCity());
			pstm.setString(3, flight.getStartDate());
			pstm.setString(4, flight.getStartDate().substring(0, 9)+Integer.valueOf(flight.getStartDate().substring(9))+1);
			rs=pstm.executeQuery();
			int flag=0;
			while(rs.next()){
				flag=1;
				flightlist.add(new Flight(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
			}
			if(flag==0)return null;
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flightlist;
	}
	public static Flight getFlightById(String flightId){
		Connection conn=null;
		Statement stm=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConn();
			String sql="select * from flight where flightId='"+flightId+"';";
			stm=conn.createStatement();
			rs=stm.executeQuery(sql);
			if(rs.next()){
				return new Flight(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
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
