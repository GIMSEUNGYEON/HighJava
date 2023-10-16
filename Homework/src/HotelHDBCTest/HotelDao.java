package HotelHDBCTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HotelDao {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public int checkIn(HotelVO hv) {
		int cnt = 0;
		
		try {
			conn = HotelUtil.getConnection();
			String sql = " INSERT INTO HOTEL_MNG(ROOM_NUM, GUEST_NAME) "
					   + " VALUES(?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hv.getRoomNo());
			pstmt.setString(2, hv.getName());
			
			cnt = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("체크인 실패!!!!");
			e.printStackTrace();
		}finally {
			HotelUtil.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}
	
	public int checkOut(int roomNo) {
		int cnt = 0;
		
		try {
			conn = HotelUtil.getConnection();
			
			String sql = "DELETE FROM HOTEL_MNG WHERE ROOM_Num = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, roomNo);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("체크아웃 실패!!!!!");
			e.printStackTrace();
		}finally {
			HotelUtil.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}
	
	public List<HotelVO> displayRoom(){
		List<HotelVO> roomList = new ArrayList<HotelVO>();
		
		try {
			conn = HotelUtil.getConnection();
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from HOTEL_MNG");
			
			while(rs.next()) {
				int roomNo = rs.getInt("room_num");
				String name = rs.getString("guest_name");
				
				HotelVO hv = new HotelVO(roomNo, name);
				
				hv.setRoomNo(roomNo);
				hv.setName(name);
				
				roomList.add(hv);
			}
			
		}catch (SQLException e) {
			System.out.println("결과 조회 실패!!!!!");
			e.printStackTrace();
		}finally {
			HotelUtil.close(conn, stmt, pstmt, rs);
		}
		
		return roomList;
		
	}
	
	public boolean checkRoom(int roomNo) {
		boolean isExist = false;
		
		try {
			conn = HotelUtil.getConnection();
			
			String sql = " select count(*) as cnt from HOTEL_MNG where room_num = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, roomNo);
			
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			if(cnt > 0) {
				isExist = true;
			}
			
		} catch (SQLException e) {
			System.out.println("조회 실패!!!!!!!");
			e.printStackTrace();
		}
		return isExist;
	}
	public static void main(String[] args) {
		
	}
}
