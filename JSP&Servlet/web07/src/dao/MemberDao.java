package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import dto.Member;

public class MemberDao {
	// �뜲�씠�꽣踰좎씠�뒪 �뿰寃고빐�꽌 �뜲�씠�꽣 二쇨퀬 諛쏅뒗 �뿭�븷

	private MemberDao() {}
	
	private static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	//--------------------------------------------------------------------------------
	
	public int insert(Member member) {
		// 諛쏆븘�삩 �젙蹂대�� �뜲�씠�꽣踰좎씠�뒪�뿉 ���옣
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uId = "HR";
		String uPwd = "1234";
		
		int num = -1;
		
		Connection con = null;
		PreparedStatement psmt = null;
		
		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?)";
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, uId, uPwd);
			
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, member.getName());
			psmt.setString(2, member.getUserid());
			psmt.setString(3, member.getUserpwd());
			psmt.setString(4, member.getEmail());
			psmt.setString(5, member.getPhone());
			psmt.setInt(6, member.getAdmin());
			
			num = psmt.executeUpdate();
					
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(psmt!=null)psmt.close();
				if(con!=null)con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return num;
	}
	
	
}
