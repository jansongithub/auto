package yinpiao.common;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** 
 * @author  zxb
 * @version 1.0 
 * @date Created on锛?2016骞?7鏈?1鏃? 涓嬪崍6:39:54 
 * Description锛?  
 *
 */

/**
 * @author zhanxiaobing
 *
 */
public class ConnectJdbc {

				public static void main(String[] args) {
					yinpiao.common.ConnectJdbc oracl = new yinpiao.common.ConnectJdbc();
					System.out.println("操作之前：");
					//oracl.Search();
					//oracl.Add();
					oracl.Delete("delete from t_activity_award where user_id = '23057' and activity_name='欧洲杯奖'");
					//oracl.Update();
					System.out.println("操作之后：");
					//oracl.Search("select * from t_activity_award");
					oracl.close();
				}

				// 数据库驱动类
				private String dbDriver = "oracle.jdbc.driver.OracleDriver";
				// 连接数据库url
				private String dbURL = "jdbc:oracle:thin:@192.168.11.52:1521:testdb";
				// 连接数据库用户名
				private String dbUser = "ypdb2";
				// 连接数据库密码
				private String dbPwd = "ypdb2";
				// 获取数据库连接方法, 返回Connection对象
				private Connection con = null;
				// 数据执行语句
				private Statement stat = null;
				private String sql = null;
				private ResultSet rs = null;

				// 创建数据库连接
				public Connection getDBConnect() {
					try {
						// 加载数据库驱动
						Class.forName(dbDriver);
						con = DriverManager.getConnection(dbURL, dbUser, dbPwd);
						System.out.println("数据库连接成功");
					} catch (Exception e) {
						System.out.println(e);
					}
					return con;
				}

				// 增加
				public void Add(String sql) {
					con = getDBConnect();
					try {
						stat = con.createStatement();
						stat.executeUpdate(sql);
					} catch (SQLException e) {

						e.printStackTrace();
					}
				}

				// 删除
				public void Delete(String sql) {
					con = getDBConnect();
					try {
						stat = con.createStatement();
						stat.executeUpdate(sql);
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}

				// 修改
				public void Update(String sql) {
					con = getDBConnect();
					try {
						stat = con.createStatement();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				// 查询
				public void Search(String sql) {
					con = getDBConnect();
					// 创建表的sql语句
					try {
						stat = con.createStatement();
						rs = stat.executeQuery(sql);
						while (rs.next()) {
							String stuno = rs.getString(1);
							String stuname = rs.getString(2);
							String stusex = rs.getString(3);
							System.out.println(stuno + "," + stuname + "," + stusex);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// 功能:关闭数据库的连接

				public void close() {// 6.释放资源
					try { // 捕捉异常
						try {
							if (rs != null) { // 当ResultSet对象的实例rs不为空时
								rs.close(); // 关闭ResultSet对象
							}
						} finally {
							try {
								if (stat != null) { // 当Statement对象的实例stmt不为空时
									stat.close(); // 关闭Statement对象
								}
							} finally {
								if (con != null) { // 当Connection对象的实例conn不为空时
									con.close(); // 关闭Connection对象
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace(System.err); // 输出异常信息
					}
				}

}
