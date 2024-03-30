package BoardWithMyBatis;

import java.util.List;

public interface IBoardDao {
	
	/**
	 * db에 데이터를 전송하여 게시글을 작성하는 메서드
	 * @param bv 새 게시글에 대한 정보를 담은 객체
	 * @return 게시글 작성에 성공하면 1 이상의 값을 반환하고 실패하면 0을 반환
	 */
	public int writeBoard(BoardVO bv);
	
	public int updateBoard(BoardVO bv);
	
	public int deleteBoard(int boardNo);
	
	public List<BoardVO> selectAllBoard();
	
	public List<BoardVO> searchBoard(BoardVO bv);
	
	public boolean checkBoard(int boardNo);
}
