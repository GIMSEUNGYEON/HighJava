package BoardWithMyBatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

public class BoardDaoImpl implements IBoardDao {

	private static IBoardDao boardDao;

	private BoardDaoImpl() {

	}

	public static IBoardDao getInstance() {
		if (boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}

	@Override
	public int writeBoard(BoardVO bv) {

		SqlSession session = BatisBoardUtil.getInstance();

		int cnt = 0;

		try {

			cnt = session.insert("board.writeBoard", bv);
			session.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		SqlSession session = BatisBoardUtil.getInstance();

		int cnt = 0;

		try {
			cnt = session.update("board.updateBoard", bv);
			session.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {

		SqlSession session = BatisBoardUtil.getInstance();

		int cnt = 0;

		try {
			cnt = session.delete("board.deleteBoard", boardNo);
			session.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> selectAllBoard() {
		SqlSession session = BatisBoardUtil.getInstance(true);

		List<BoardVO> boardList = new ArrayList<BoardVO>();

		try {

			boardList = session.selectList("board.selectAllBoard");

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return boardList;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {

		SqlSession session = BatisBoardUtil.getInstance(true);

		List<BoardVO> boardList = new ArrayList<BoardVO>();

		try {
			boardList = session.selectList("board.searchMember", bv);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return boardList;
	}

	@Override
	public boolean checkBoard(int boardNo) {
		boolean isExist = false;
		SqlSession session = BatisBoardUtil.getInstance();

		try {
			int cnt = session.selectOne("board.checkBoard", boardNo);

			if (cnt > 0) {
				isExist = true;
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isExist;
	}

}
