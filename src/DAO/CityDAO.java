package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DoMain.City;
import Util.DBUtil;

public class CityDAO {
	public static ArrayList<City> citylist=null;
	public static ArrayList<City> getCityList(){
		if(citylist!=null)return citylist;
		citylist=new ArrayList<City>();
		Connection conn=null;
		ResultSet rs=null;
		Statement stm=null;
		try {
			conn=DBUtil.getConn();
			String sql="select * from city;";
			stm=conn.createStatement();
			rs=stm.executeQuery(sql);
			while(rs.next()){
				citylist.add(new City(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4)));
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
		return citylist;
	}
	public  static String getCityAirport(String cityname){
		if(citylist==null)getCityList();
		City c=new City();
		c.setCityname(cityname);
		for(City city:citylist){
			if(city.equals(c)){
				return city.getAirport();
			}
		}
		return null;
	}
}
