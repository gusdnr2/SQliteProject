import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtil {
	
	public static void DeleteData(Connection con) {
		try {
			Statement stat = con.createStatement();
			String sql = "delete from g_artists;";
			int cnt = stat.executeUpdate(sql);
			if (cnt > 0)
				System.out.println("������ ���� �Ϸ�.");
			else 
				System.out.println("[Error] ������ ������ ���� �߻�.");
			stat.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}
	public static void ResetSequence(Connection con) {
		try {
			Statement stat= con.createStatement();
			String sql = "update sqlite_sequence set seq=0 where name='g_artists';";
			int cnt = stat.executeUpdate(sql);
			stat.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void EditData(Connection con, String col, String data, String id) {
		try {
			System.out.println("\n--- ������ ���� ---");
			Statement stat = con.createStatement();
			String sql = "update g_artists"+" set "+col+" = "+" '"+data+"' "+" where id="+id+";";
			int cnt = stat.executeUpdate(sql);
			if (cnt > 0)
				System.out.println("������ ���� �Ϸ�");
			else
				System.out.println("[Error] ������ ������ ���� �߻�.");
			stat.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
