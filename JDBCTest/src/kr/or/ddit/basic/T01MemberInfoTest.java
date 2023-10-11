package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.JDBCUtil2;

/*
	회원정보를 관리하는 프로그램을 작성하는데 
	아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
	(DB의 MYMEMBER테이블을 이용하여 작업한다.)
	
	* 자료 삭제는 회원ID를 입력 받아서 삭제한다.
	
	예시메뉴)
	----------------------
		== 작업 선택 ==
		1. 자료 입력			---> insert
		2. 자료 삭제			---> delete
		3. 자료 수정			---> update
		4. 전체 자료 출력	---> select
		5. 작업 끝.
	----------------------
	 
	   
// 회원관리 프로그램 테이블 생성 스크립트 
create table mymember(
    mem_id varchar2(8) not null,  -- 회원ID
    mem_name varchar2(100) not null, -- 이름
    mem_tel varchar2(50) not null, -- 전화번호
    mem_addr varchar2(128),    -- 주소
    reg_dt DATE DEFAULT sysdate, -- 등록일
    CONSTRAINT MYMEMBER_PK PRIMARY KEY (mem_id)
);

*/
public class T01MemberInfoTest {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Scanner scan = new Scanner(System.in);

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작메서드
	 */
	public void start() {
		int choice = 0;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 자료 입력
				insertMember();
				break;
			case 2: // 자료 삭제
				deleteMember();
				break;
			case 3: // 자료 수정
				updateMember();
				break;
			case 4: // 전체 자료 출력
				diplayAllMember();
				break;
			case 5: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 5);
	}


	private void insertMember() {
		// 회원정보를 추가하기 위한 메서드
		boolean isExist = false;
		
		String memId = "";
		
		do {
			System.out.println();
			System.out.println("추가할 회원 정보를 입력하세요.");
			System.out.print("회원 ID >> ");
			memId = scan.next();
			
			isExist = checkMember(memId);
			
			if(isExist) {
				System.out.println(memId + "는 이미 존재하는 ID입니다.\n다시 입력해주세요." );
			}
			
		} while (isExist);
			
			System.out.print("회원 이름 >> ");
			String memName = scan.next();
			;
			
			System.out.print("회원 전화번호 >> ");
			String memTel = scan.next();
			
			scan.nextLine(); // 입력 버퍼 비우기
			
			System.out.print("회원 주소 >> ");
			String memAddr = scan.nextLine();
			
			try {
				conn = JDBCUtil2.getConnection();
				
				String sql = "    INSERT INTO mymember (mem_id, mem_name, mem_tel, mem_addr) " + 
						"    VALUES (?, ?, ?, ? ) ";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setNString(1, memId);
				pstmt.setNString(2, memName);
				pstmt.setNString(3, memTel);
				pstmt.setNString(4, memAddr);
				
				int cnt = pstmt.executeUpdate(); //insert 구문이라서 update로 
				
				if(cnt > 0) {
					System.out.println(memId + "님 회원가입 되었습니다.");
				}else {					
					System.out.println(memId + "님 회원가입 실패!!");
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtil2.close(conn, stmt, pstmt, rs);
			}

	}
	/**
	 * 회원정보를 수정하기 위한 메서드
	 */
	private void updateMember() {
		
		boolean isExist = false;
		
		String memId = "";
		
		do {
			System.out.println();
			System.out.println("수정할 회원 정보를 입력하세요.");
			System.out.print("회원 ID >> ");
			memId = scan.next();
			
			isExist = checkMember(memId);
			
			if(!isExist) {
				System.out.println(memId + "는 없는 ID입니다.\n다시 입력해주세요." );
			}
			
		} while (!isExist);
			
			System.out.print("회원 이름 >> ");
			String memName = scan.next();
			;
			
			System.out.print("회원 전화번호 >> ");
			String memTel = scan.next();
			
			scan.nextLine(); // 입력 버퍼 비우기
			
			System.out.print("회원 주소 >> ");
			String memAddr = scan.nextLine();
			
			try {
				conn = JDBCUtil2.getConnection();
				
				String sql = " UPDATE MYMEMBER SET MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ? "
							+" WHERE MEM_ID = ? ";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setNString(1, memName);
				pstmt.setNString(2, memTel);
				pstmt.setNString(3, memAddr);
				pstmt.setNString(4, memId);
				
				int cnt = pstmt.executeUpdate();
				
				if(cnt > 0) {
					System.out.println(memId + "님 회원 정보 수정 성공!");
				}else {
					System.out.println(memId + "님 회원 정보 수정 실패!!");					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtil2.close(conn, stmt, pstmt, rs);
			}
	}
		
	private void deleteMember() {
	
		boolean isExist = false;
		
		String memId = "";
		
			
			System.out.println();
			System.out.println("삭제할 회원 정보를 입력하세요.");
			System.out.print("회원 ID >> ");
			memId = scan.next();
			
			isExist = checkMember(memId);
			
			if(!isExist) {
				System.out.println(memId + "는 없는 ID입니다.\n다시 입력해주세요." );
			}
		try {
			conn = JDBCUtil2.getConnection();
			
			String sql = "delete from mymember where mem_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(memId + "회원 삭제 성공");
			}else {
				System.out.println(memId + "회원 삭제 실패");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.close(conn, stmt, pstmt, rs);
		}
	}

	/**
	 * 모든 회원정보 출력을 위한 메서드
	 */
	private void diplayAllMember() {
		System.out.println("\n----------------------------------------------------");
		System.out.println("  ID\t이름\t전화번호\t\t주소");
		System.out.println("----------------------------------------------------");
		try {
			conn = JDBCUtil2.getConnection();
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from mymember");
				
			while(rs.next()) {
				
				String memId = rs.getString("mem_id");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				
				System.out.println(" " + memId + "\t" + memName + "\t" + memTel + "\t" + memAddr);
				
				System.out.println("----------------------------------------------------");
				System.out.println("전체 회원 정보 출력 완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.close(conn, stmt, pstmt, rs);
		}
	}	
	
	/**
	 * 아이디 중복체크를 수행하는 메서드
	 * 
	 * @param memId : 회원존재 여부를 체크하기 위한 회원 ID
	 * @return 존재하면 true, 존재하지 않으면 false 반환
	 */
	private boolean checkMember(String memId) {
		boolean isExist = false;
		try {
			conn = JDBCUtil2.getConnection();
			
			String sql = " SELECT count(*) as cnt FROM MYMEMBER " + 
						 " WHERE MEM_ID = ? ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setNString(1, memId);
			
			rs = pstmt.executeQuery(); //select 문이니까 쿼리
			
			int cnt = 0;
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
			if(cnt > 0) {
				isExist = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.close(conn, stmt, pstmt, rs);
		}
		return isExist;
	}
	

	public static void main(String[] args) {
		T01MemberInfoTest memObj = new T01MemberInfoTest();
		memObj.start();
	}

}
