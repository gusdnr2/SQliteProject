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
				System.out.println("데이터 삭제 완료.");
			else 
				System.out.println("[Error] 데이터 삭제중 오류 발생.");
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
			System.out.println("\n--- 데이터 수정 ---");
			Statement stat = con.createStatement();
			String sql = "update g_artists"+" set "+col+" = "+" '"+data+"' "+" where id="+id+";";
			int cnt = stat.executeUpdate(sql);
			if (cnt > 0)
				System.out.println("데이터 수정 완료");
			else
				System.out.println("[Error] 데이터 수정중 오류 발생.");
			stat.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
