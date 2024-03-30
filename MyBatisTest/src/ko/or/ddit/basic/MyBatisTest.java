package ko.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.member.VO.MemberVO;

public class MyBatisTest {
	public static void main(String[] args) {
		//myBatis를 이용하여 DB데이터를 처리하는 작업 순서
		
		//1. myBatis의 환경설정파일을 읽어와 필요한 객체를 생성한다.
		SqlSessionFactory sessionFactory = null;
		
		try {
			//1-1. 설정파일 읽기(xml문서)
			Charset charset = Charset.forName("UTF-8");
			
			Resources.setCharset(charset);
			
			Reader rd = Resources.getResourceAsReader("config/mybatis-config.xml");
			
			//1-2. 위에서 생성한 Reader객체 이용하여 필요한 객체 생성
			sessionFactory = new SqlSessionFactoryBuilder().build(rd);
			
			rd.close(); //스트림 닫기
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//2. 실행할 SQL문에 맞는 쿼리문을 호출하여 원하는 작업을 수행한다.
		
		//2-1. insert작업 연습
		System.out.println("insert 작업 시작...");
		
		MemberVO mv = new MemberVO();
		
		mv.setMemId("d001");
		mv.setMemName("김승연");
		mv.setMemTel("010-1111-1111");
		mv.setMemAddr("광주");
		
		// SqlSession 객체를 이용하여 해당 쿼리문을 실행한다.
		// ex) sqlSession.insert("namespace값,id값", 파라미터 객체)
		// 반환값 : 성공한 레코드 수
		
		//세션 열기(오토커밋 여부 설정)
		SqlSession sqlSession = sessionFactory.openSession(false); //오토커밋 false
		
		try {
			
			int cnt = sqlSession.insert("memberTest.insertMember", mv); //네임스페이스.쿼리아이디 형식
			//	Mappers의 member.xml파일에서 확인 가능
			
			if(cnt > 0) {
				System.out.println("insert 작업 성공 : " + cnt);
				sqlSession.commit();
				//커밋하지 않으면 sqlSession.close() 메서드에서 롤백시켜버림
			}else {
				System.out.println("insert 작업 실패!!!!!");
			}
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			sqlSession.close(); //세션 닫기 내부적으로 데이터베이스와 연결되어있기 때문에 close로 연결을 반납
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//2-2. update 구문 연습
		System.out.println("-----------------------------------------------------");
		System.out.println("update 작업 시작....");
		SqlSession sqlSession2 = sessionFactory.openSession(false);
		
		MemberVO mv2 = new MemberVO();
		mv2.setMemId("d001");
		mv2.setMemName("강감찬");
		mv2.setMemTel("010-2222-2222");
		mv2.setMemAddr("대전시 중구");
		
		try {
			int cnt = sqlSession2.update("memberTest.updateMember", mv2);
			
			if(cnt > 0) {
				System.out.println("update 작업 성공 : " + cnt);
				sqlSession2.commit();
			}else {
				System.out.println("update 작업 실패!!!!!");
			}
		}catch(PersistenceException e){
			e.printStackTrace();
		}finally {
			sqlSession2.close();
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//2-3. delete 구문 연습
	
//		System.out.println("delete 작업 시작....");
//		SqlSession sqlSession3 = sessionFactory.openSession(false);
//		
//		try {
//			int cnt = sqlSession3.delete("memberTest.deleteMember", "d001");
//			
//			if(cnt > 0) {
//				System.out.println("delete 작업 성공 : " + cnt);
//				sqlSession3.commit();
//			}else {
//				System.out.println("delete 작업 실패!!!!");
//			}
//		}catch (PersistenceException e) {
//			e.printStackTrace();
//		}finally {
//			sqlSession3.close();
//		}
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//2-4. select 구문 연습
		//	1) 응답의 결과가 여러개인 경우
		
		System.out.println("select 작업 시작...(결과가 여러개인 경우)");
		
		// 응답결과가 여러개일 경우에는 selectList()를 사용한다.
		// 이 메서드는 여러개의 레코드를 VO에 담은 후 이 VO데이터를 List에 추가해주는 작업을 자동으로 수행한다.
		
		SqlSession sqlSession4 = sessionFactory.openSession(true);
		
		try {
			
			List<MemberVO> memList = sqlSession4.selectList("memberTest.selectAllMember");
			
			for(MemberVO mv4 : memList) {
				System.out.println("ID : " + mv4.getMemId());
				System.out.println("이름 : " + mv4.getMemName());
				System.out.println("전화번호 : " + mv4.getMemTel());
				System.out.println("주소 : " + mv4.getMemAddr());
				System.out.println("=================================");
			}
			
		}catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			sqlSession4.close();
		}
		
		//	2) 응답의 결과가 한개인 경우
		System.out.println("select 작업 시작...(결과가 한개인 경우)");
		
		SqlSession sqlSession5 = sessionFactory.openSession(true);
		
		try {
			MemberVO mv5 = sqlSession5.selectOne("memberTest.getMember", "a001");
			
			System.out.println("=================================");
			System.out.println("ID : " + mv5.getMemId());
			System.out.println("이름 : " + mv5.getMemName());
			System.out.println("전화번호 : " + mv5.getMemTel());
			System.out.println("주소 : " + mv5.getMemAddr());
			
		}catch(PersistenceException e){
			e.printStackTrace();
		}finally {
			sqlSession5.close();
		}
		
	}
}
