package board;

import java.util.List;
import java.util.Scanner;

public class Board_Controller {
	private Scanner sc;
	static Board_Dao bd = new Board_Dao();

	public static void main(String[] args) {
		// 게시판 구현 과제 : 전체 목록 출력, 새 글 작성, 수정, 삭제, 검색 기능 구현하기
		Board_Controller bc = new Board_Controller();

		bc.start();
	}

	public Board_Controller() {
		sc = new Scanner(System.in);
	}

	public void start() {
		int choice = 5000;
		do {
			Menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				write();
				break;
			case 2:
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				display();
				break;
			case 5:
				search();
				break;
			case 0:
				System.out.println("작업을 마칩니다.");
				System.exit(0);
			default:
				break;
			}
		} while (choice != 0);
	}

	public void Menu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 게시글 검색");
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
		//nextLine을 쓰면 입력을 못받는데 이유를 못찾겠음!!!!!
		BoardVO bv = new BoardVO(title, writer, content);

		if (bd.writeBoard(bv) != 0) {
			System.out.println("게시글 작성 성공!");
		} else {
			System.out.println("게시글 작성 실패!!!");
		}
	}

	public void update() {
		
		boolean isExist = false;

		int no = 0;
		do {

			System.out.println("수정할 글 번호를 입력하세요. >> ");

			no = sc.nextInt();

			isExist = bd.checkBoard(no);

			if (!isExist) {
				System.out.println("존재하지 않는 글번호입니다...");
			}

		} while (!isExist);

		System.out.println("새로운 글 제목을 입력해주세요 >>");
		String newTitle = sc.next();
		sc.nextLine();
		
		System.out.println("새로운 내용을 입력해주세요 >> ");
		String newContent = sc.nextLine();

		if (bd.updateBoard(no, newTitle, newContent) != 0) {
			System.out.println("글 수정 완료 !");
		} else {
			System.out.println("글 수정 실패!!!");
		}
	}
	
	public void delete() {
		boolean isExist = false;

		int no = 0;
		
		do {

			System.out.println("삭제할 글 번호를 입력하세요. >> ");

			no = sc.nextInt();

			isExist = bd.checkBoard(no);

			if (!isExist) {
				System.out.println("존재하지 않는 글번호입니다...");
			}

		} while (!isExist);

		if (bd.deleteBoard(no) != 0) {
			System.out.println("글 삭제 완료 !");
		} else {
			System.out.println("글 삭제 실패!!!");
		}
	}
	
	public void display() {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println("번호\t 글 제목\t 작성날짜 \t 작성자 \t 내용");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		List<BoardVO> bList = bd.selectAllBoard();
		
		for(BoardVO bVo : bList) {
			System.out.println(bVo.getBoardNum() + "\t" + bVo.getTitle() + "\t" + bVo.getUser() + "\t"
							 + bVo.getRegDt() + "\t" + bVo.getContent());
		}
		
		System.out.println("출력완료");
	}
	
	public void search() {
		
		sc.nextLine();
		System.out.println("검색할 글 제목을 입력하세요 >> ");
		String title = sc.nextLine();
		
		System.out.println("검색할 글 작성자를 입력하세요 >> ");
		String user = sc.nextLine();
		
		System.out.println("검색할 글 내용을 입력하세요 >> ");
		String content = sc.nextLine();
		
		BoardVO bv = new BoardVO(title, user, content);
		
		List<BoardVO> bList = bd.searchBoard(bv);
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println("번호\t 글 제목\t 작성날짜 \t 작성자 \t 내용");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

		for(BoardVO bVo : bList) {
			System.out.println(bVo.getBoardNum() + "\t" + bVo.getTitle() + "\t" + bVo.getUser() + "\t"
							 + bVo.getRegDt() + "\t" + bVo.getContent());
		}
	}
}

