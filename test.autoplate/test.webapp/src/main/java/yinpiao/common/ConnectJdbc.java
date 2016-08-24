package yinpiao.common;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** 
 * @author  zxb
 * @version 1.0 
 * @date Created on�?2016�?7�?1�? 下午6:39:54 
 * Description�?  
 *
 */

/**
 * @author zhanxiaobing
 *
 */
public class ConnectJdbc {

				public static void main(String[] args) {
					yinpiao.common.ConnectJdbc oracl = new yinpiao.common.ConnectJdbc();
					System.out.println("����֮ǰ��");
					//oracl.Search();
					//oracl.Add();
					oracl.Delete("delete from t_activity_award where user_id = '23057' and activity_name='ŷ�ޱ���'");
					//oracl.Update();
					System.out.println("����֮��");
					//oracl.Search("select * from t_activity_award");
					oracl.close();
				}

				// ���ݿ�������
				private String dbDriver = "oracle.jdbc.driver.OracleDriver";
				// �������ݿ�url
				private String dbURL = "jdbc:oracle:thin:@192.168.11.52:1521:testdb";
				// �������ݿ��û���
				private String dbUser = "ypdb2";
				// �������ݿ�����
				private String dbPwd = "ypdb2";
				// ��ȡ���ݿ����ӷ���, ����Connection����
				private Connection con = null;
				// ����ִ�����
				private Statement stat = null;
				private String sql = null;
				private ResultSet rs = null;

				// �������ݿ�����
				public Connection getDBConnect() {
					try {
						// �������ݿ�����
						Class.forName(dbDriver);
						con = DriverManager.getConnection(dbURL, dbUser, dbPwd);
						System.out.println("���ݿ����ӳɹ�");
					} catch (Exception e) {
						System.out.println(e);
					}
					return con;
				}

				// ����
				public void Add(String sql) {
					con = getDBConnect();
					try {
						stat = con.createStatement();
						stat.executeUpdate(sql);
					} catch (SQLException e) {

						e.printStackTrace();
					}
				}

				// ɾ��
				public void Delete(String sql) {
					con = getDBConnect();
					try {
						stat = con.createStatement();
						stat.executeUpdate(sql);
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}

				// �޸�
				public void Update(String sql) {
					con = getDBConnect();
					try {
						stat = con.createStatement();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				// ��ѯ
				public void Search(String sql) {
					con = getDBConnect();
					// �������sql���
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

				// ����:�ر����ݿ������

				public void close() {// 6.�ͷ���Դ
					try { // ��׽�쳣
						try {
							if (rs != null) { // ��ResultSet�����ʵ��rs��Ϊ��ʱ
								rs.close(); // �ر�ResultSet����
							}
						} finally {
							try {
								if (stat != null) { // ��Statement�����ʵ��stmt��Ϊ��ʱ
									stat.close(); // �ر�Statement����
								}
							} finally {
								if (con != null) { // ��Connection�����ʵ��conn��Ϊ��ʱ
									con.close(); // �ر�Connection����
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace(System.err); // ����쳣��Ϣ
					}
				}

}
