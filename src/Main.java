import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			
			String dbfile = "myfirst.db";
			con = DriverManager.getConnection("jdbc:sqlite:" +dbfile);
			
			Scanner sc = new Scanner(System.in);
			boolean flag = false;
			
			System.out.println("Do you want to remove all data in g_artists? > ");
			String answer = sc.next();
			
			if (answer.equals("y"))
				flag = true;
			else 
				flag = false;
			
			if (flag)
				SqlUtil.DeleteData(con);
			else 
				System.out.println("�������� �ʰڽ��ϴ�.");
			
			
			System.out.println("\n*** ������ ��ȸ ***");
			Statement stat1 = con.createStatement();
			String sql1 = "select * from g_artists;";
			ResultSet rs1 = stat1.executeQuery(sql1);
			while (rs1.next()) {
				String id = rs1.getString("id");
				String name = rs1.getString("name");
				String a_year = rs1.getString("a_year");
				System.out.println(id + " " + name + " " + a_year);
			}
			stat1.close();
			
			System.out.println("\n--- �� ������ �߰� ---");
			Statement stat2 = con.createStatement();
			String sql2 = "insert into g_artists (name, a_type, a_year, debut, regdate) values ('Slowdive','ȥ��/�׷�','1990���','1991��',datetime('now','localtime')),"
					+ "('The beatles','�׷�','1960���','1960','2021-10-01'),('������','�ַ�','2000���','2010','2021-10-01'),('�Ź�','�ַ�','2000���','2000','2021-10-01'),"
					+ "('�׽�Ʈ����','����','','','');"
					;
			int cnt = stat2.executeUpdate(sql2);
			if (cnt > 0)
				System.out.println("�� ������ �߰� �Ϸ�");
			else
				System.out.println("[Error] ������ �߰� ����");
			stat2.close();
			
			SqlUtil.EditData(con, "a_year","2000���,2010���" , "1");
			
			System.out.println("\n*** ������ ��ȸ ***");
			Statement stat3 = con.createStatement();
			String sql3 = "select * from g_artists;";
			ResultSet rs3 = stat3.executeQuery(sql3);
			while (rs3.next()) {
				String id = rs3.getString("id");
				String name = rs3.getString("name");
				String a_year = rs3.getString("a_year");
				System.out.println(id + " " + name + " " + a_year);
			}
			stat3.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {}
				}
			}
		}

	}

