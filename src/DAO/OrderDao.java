package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DoMain.Order;
import Util.DBUtil;

public class OrderDao {
	public static ArrayList<Order> getOrderList(String querytype,String queryinfo,String orderStatus){
		Connection conn=null;
		Statement stm=null;
		ResultSet rs=null;
		ArrayList<Order> orderlist=new ArrayList<Order>();
		try {
			conn=DBUtil.getConn();
				String sql="select * from t_order where";
			switch(querytype){
			case "3":
				sql=sql+" useridno='"+queryinfo+"'";
				break;
			case "2":
				sql=sql+" draftNum='"+queryinfo+"'";
				break;
			case "1":
				sql=sql+" orderId='"+queryinfo+"'";
				break;
			}
			if(orderStatus!=null){
				sql=sql+" and orderStatus='"+orderStatus+"';";
			}
			stm=conn.createStatement();
			rs=stm.executeQuery(sql);
			while(rs.next()){
				orderlist.add(new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
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
		return orderlist;
	}

	public static void addOrder(Order order) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = DBUtil.getConn();
			String sql = "insert into t_order values(default,?,?,?,?,?,?,?,?,?,?,?,?);";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, order.getFlightNum());
			pstm.setString(2, order.getStartCity());
			pstm.setString(3, order.getArriveCity());
			pstm.setString(4, order.getSpaceId());
			pstm.setString(5, order.getSpaceName());
			pstm.setDouble(6, order.getSpacePrice());
			pstm.setDouble(7, order.getAirportprice());
			pstm.setDouble(8, order.getOilPrice());
			pstm.setString(9, order.getUserIdno());
			pstm.setString(10, order.getPayId());
			pstm.setString(11, order.getOrderStatus());
			pstm.setString(12, order.getDraftNum());
			pstm.execute();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void modifyStatus(String orderId, String orderStatus) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = DBUtil.getConn();
			String sql = "update t_order set orderStatus=? where orderId=?;";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, orderStatus);
			pstm.setString(2, orderId);
			pstm.executeUpdate();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
