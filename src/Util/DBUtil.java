package Util;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	private static BasicDataSource datasource=null;
	private static void getDBSource() throws IOException{
		Properties props=new Properties();
		props.load(DBUtil.class.getResourceAsStream("/res/db.properties"));
		String driver=props.getProperty("driverClassName");
		String url=props.getProperty("url");
		String username=props.getProperty("username");
		String password=props.getProperty("password");
		String initialSize=props.getProperty("initialSize");
		String maxIdle=props.getProperty("maxIdle");
		String minIdle=props.getProperty("minIdle");
		String maxActive=props.getProperty("maxActive");
		String maxWait=props.getProperty("maxWait");
		datasource=new BasicDataSource();
		datasource.setDriverClassName(driver);
		datasource.setUrl(url);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setInitialSize(Integer.valueOf(initialSize));
		datasource.setMaxIdle(Integer.valueOf(maxIdle));
		datasource.setMinIdle(Integer.valueOf(maxIdle));
		datasource.setMaxActive(Integer.valueOf(maxActive));
		datasource.setMaxWait(Integer.valueOf(maxActive));
	}
	public static Connection getConn() throws IOException, SQLException{
		if(datasource==null){
			getDBSource();
		}
		return datasource.getConnection();
	}
	public SqlSession getsqlSession() throws IOException{
		SqlSession sqlSS=null;
		Reader reader=Resources.getResourceAsReader("config/Configuration.xml");
		SqlSessionFactory sqlSSF=new SqlSessionFactoryBuilder().build(reader);
		sqlSS=sqlSSF.openSession();
		return sqlSS;
	}
}
