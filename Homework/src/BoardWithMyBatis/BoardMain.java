package BoardWithMyBatis;

import java.util.List;
import java.util.Scanner;

public class BoardMain {
	private Scanner sc;
	
	private IBoardDao boardDao;
	
	public static void main(String[] args) {
		
		
		BoardMain boardObj = new BoardMain();

		
		boardObj.start();
		
	}
	
	public BoardMain() {
		
		sc = new Scanner(System.in);
	
		boardDao = BoardDaoImpl.getInstance();

	}
	public void start() {
		
		int choice = 1000;
		
		do {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1: write(); break;
			case 2: delete(); break;
			case 3: update(); break;
			case 4: display(); break;
			case 5: search(); break;
			case 0: System.out.println("작업을 마칩니다.");
			System.exit(0);
			break;
			default:
				System.out.println("잘못된 입력!!");
				break;
			}
			
		}while(choice != 0);
	}
	
	public void menu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 자료 검색 ");
		System.out.println("  0. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	public void write() {	
		System.out.println("작성자를 입력하세요. >>");
		String writer = sc.next();
		sc.nextLine();
		System.out.println("글 제목을 입력하세요 >> ");
		String title = sc.nextLine();
		System.out.println("글 내용을 입력하세요 >>");
		String content = sc.nextLine();

		BoardVO bv = new BoardVO(title, writer, content);

		if (boardDao.writeBoard(bv) != 0) {
			System.out.println("게시글 작성 성공!");
		} else {
			System.out.println("게시글 작성 실패!!!");
		}
	}
	
	public void delete() {
		boolean isExits = false;
		int boardNo = 0;
	
		System.out.println("삭제할 글 번호를 입력해주세요.");
		boardNo = sc.nextInt();
		
		isExits = boardDao.checkBoard(boardNo);
		if(!isExits) {
			System.out.println("존재하지 않는 게시글 번호입니다.");
			return;
		}
	
		
		int cnt = boardDao.deleteBoard(boardNo);
		
		if(cnt > 0) {
			System.out.println("게시글이 삭제되었습니다.");
		}else {
			System.out.println("게시글 삭제 실패!!!!!!");
		}
	}
	
	public void update() {
		boolean isExist = false;
		
		int boardNo = 0;
		
			System.out.println("수정할 글 번호를 입력하세요.");
			boardNo = sc.nextInt();
			isExist = boardDao.checkBoard(boardNo);
			if(!isExist) {
				System.out.println("존재하지 않는 글번호입니다.");
				return;
			}
				
		System.out.println("새로운 글 제목을 입력해주세요>>");
		String newTitle = sc.next();
		sc.nextLine();
		System.out.println("새로운 내용을 입력해주세요>>");
		String newContent = sc.next();
		sc.nextLine();
		
		BoardVO bv = new BoardVO(boardNo, newTitle, newContent);
		
		if(boardDao.updateBoard(bv) != 0) {
			System.out.println("게시글 수정 완료!");
		}else {
			System.out.println("게시글 수정 실패!!!!");			
		}
	}
	
	public void display() {
		System.out.println("====================================");
		System.out.println("번호\t 글 제목\t 작성날짜 \t 작성자 \t 내용");
		System.out.println("====================================");
		
		List<BoardVO> boardList = boardDao.selectAllBoard();
		
		for(BoardVO bVo : boardList) {
			System.out.println(bVo.getBoardNo() + "\t" + bVo.getTitle() + "\t" + bVo.getUser() + "\t"
					 + bVo.getRegDt() + "\t" + bVo.getContent());
		}
	}
	
	public void search() {
		sc.nextLine();
		System.out.println("검색할 글 제목을 입력하세요.");
		String title = sc.nextLine().trim();
		System.out.println("검색할 글 작성자를 입력하세요.");
		String user = sc.nextLine().trim();
		System.out.println("검색할 글 내용 입력하세요.");
		String content = sc.nextLine().trim();
		
		BoardVO bv = new BoardVO(title, user, content);
		
		List<BoardVO> boardList = boardDao.searchBoard(bv);
		
		for(BoardVO bVo : boardList) {
			System.out.println(bVo.getBoardNo() + "\t" + bVo.getTitle() + "\t" + bVo.getUser() + "\t"
							 + bVo.getRegDt() + "\t" + bVo.getContent());
		}
	}
	
}
