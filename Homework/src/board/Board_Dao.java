package board;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

public class Board_Dao {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public int writeBoard(BoardVO bv) {
		int cnt = 0;

		try {
			conn = BoardUtil.getConnection();
			String sql = " INSERT INTO jdbc_board(BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CONTENT ) "
					+ " VALUES(BOARD_SEQ.NEXTVAL, ?, ?, SYSDATE, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bv.getTitle());
			pstmt.setString(2, bv.getUser());
			pstmt.setString(3, bv.getContent());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardUtil.close(conn, stmt, pstmt, rs);
		}

		return cnt;
	}

	public int updateBoard(int boardNum, String newTitle, String newContent) {
		int cnt = 0;

		try {
			conn = BoardUtil.getConnection();
			String sql = " update jdbc_board set board_title = ?, board_content = ? "
					   + " where board_no = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, newTitle);
			pstmt.setString(2, newContent);
			pstmt.setInt(3, boardNum);

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardUtil.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	public int deleteBoard(int boardNum) {

		int cnt = 0;

		try {
			conn = BoardUtil.getConnection();
			String sql = " delete from jdbc_board where board_no = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNum);

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardUtil.close(conn, stmt, pstmt, rs);
		}

		return cnt;
	}

	public List<BoardVO> selectAllBoard() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();

		try {
			conn = BoardUtil.getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select jdbc_board.*, rownum from jdbc_board ");

			while (rs.next()) {

				int boardNum = rs.getInt("rownum");
				String title = rs.getString("BOARD_TITLE");
				String user = rs.getString("BOARD_WRITER");
				String content = rs.getString("BOARD_CONTENT");

				BoardVO bv = new BoardVO(title, user, content);

				bv.setRegDt(rs.getTimestamp("board_date").toLocalDateTime().toLocalDate());
				bv.setBoardNum(boardNum);
				bv.setTitle(title);
				bv.setUser(user);
				bv.setContent(content);

				boardList.add(bv);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardUtil.close(conn, stmt, pstmt, rs);
		}
		return boardList;
	}
	
	public List<BoardVO> searchBoard(BoardVO bv){
		
		List<BoardVO> bList = new ArrayList<BoardVO>();

		try {
			
			conn = BoardUtil.getConnection();
			
			
			String sql = " select jdbc_board.*, rownum from jdbc_board where 1=1 ";
			
			if(bv.getTitle() != null && !bv.getTitle().equals("")) {
				sql += " and board_title like '%'|| ? || '%' ";
			}
			
			if(bv.getUser() != null && !bv.getUser().equals("")) {
				sql += " and board_writer = ? ";
			}
			
			if(bv.getContent() != null && !bv.getContent().equals("")) {
				sql += " and board_content like '%' || ? || '%' ";
			}
			
			pstmt = conn.prepareStatement(sql);

			int index = 1;
			
			if(bv.getTitle() != null && !bv.getTitle().equals("")) {
				pstmt.setString(index++, bv.getTitle());
			}
			if(bv.getUser() != null && !bv.getUser().equals("")) {
				pstmt.setString(index++, bv.getUser());
			}
			if(bv.getContent() != null && !bv.getContent().equals("")) {
				pstmt.setString(index++, bv.getContent());
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int boardNum = rs.getInt("rownum");
				String title = rs.getString("board_title");
				String user = rs.getString("board_writer");
				String content = rs.getString("board_content");
				
				BoardVO bVo = new BoardVO();
				
				bVo.setRegDt(rs.getTimestamp("board_date").toLocalDateTime().toLocalDate());
				bVo.setBoardNum(boardNum);
				bVo.setTitle(title);
				bVo.setUser(user);
				bVo.setContent(content);
				
				bList.add(bVo);

			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BoardUtil.close(conn, stmt, pstmt, rs);
		}
		
		return bList;
	}
	
	public boolean checkBoard(int boardNum) {
		
		boolean isExist = false;

		try {
			conn = BoardUtil.getConnection();

			String sql = " SELECT count(*) as cnt FROM JDBC_BOARD " 
					   + " WHERE BOARD_NO = ? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNum);

			rs = pstmt.executeQuery(); 
			
			int cnt = 0;

			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}

			if (cnt > 0) {
				isExist = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardUtil.close(conn, stmt, pstmt, rs);
		}

		return isExist;
	}

}