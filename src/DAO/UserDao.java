package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DoMain.User;
import Util.DBUtil;

public class UserDao {
	public static void addUser(User user){
		System.out.println("正在添加用户");
		Connection conn=null;
		PreparedStatement pstm=null;
		String sql="insert into user values(default,?,?,?,?,?,?,0,default);";
		try {
			conn=DBUtil.getConn();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getUseridno());
			pstm.setString(3, user.getUserphone());
			pstm.setString(4, user.getUseraddr());
			pstm.setString(5, user.getUsermail());
			pstm.setString(6, user.getUserpsw());
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
	public static User checkUser(User user){
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConn();
			String sql = null;
			if(user.getUserpsw()==null){
				System.out.println("验证用户是否已经存在");
				sql="select * from user where useridno=? or usermail=?;";
				pstm=conn.prepareStatement(sql);
				pstm.setString(2, user.getUsermail());
				pstm.setString(1, user.getUseridno());
			}else if(user.getUsermail()!=null){
				sql="select * from user where usermail=? and userpsw=?;";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, user.getUsermail());
				pstm.setString(2, user.getUserpsw());
			}else if(user.getUseridno()!=null){
				sql="select * from user where useridno=? and userpsw=?;";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, user.getUseridno());
				pstm.setString(2, user.getUserpsw());
			}else{
				return null;
				}
			rs=pstm.executeQuery();
			if(rs.next()){
				user= new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				System.out.println(user);
				return user;
			}
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
		return null;
	}
	public static User getUserByMail(String usermail){
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConn();
			String sql="select * from user where usermail=?;";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, usermail);
			rs=pstm.executeQuery();
			if(rs.next()){
				return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
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
		return null;
	}
	public static void modifyUser(User user){
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			conn=DBUtil.getConn();
			String sql="update user set useraddr=?,userphone=? userbalance=? where usermail=?;";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, user.getUseraddr());
			pstm.setString(2, user.getUserphone());
			pstm.setString(3, user.getUserbalance());
			pstm.setString(4, user.getUsermail());
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
	public static void resetUser(User user){
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			conn=DBUtil.getConn();
			String sql="update user set userpsw=? where usermail=?;";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, user.getUserpsw());
			pstm.setString(2, user.getUsermail());
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
	public static void adminUser(User user){
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			conn=DBUtil.getConn();
			String sql="update user set userstatus=? where usermail=?;";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, user.getUserstatus());
			pstm.setString(2, user.getUsermail());
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
