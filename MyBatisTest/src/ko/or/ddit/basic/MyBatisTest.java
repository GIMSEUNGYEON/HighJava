package ko.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

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
			int cnt = sqlSession.insert("memberTest.insertMember", mv);
			
			if(cnt > 0) {
				System.out.println("insert 작업 성공 : " + cnt);
				sqlSession.commit();
			}else {
				System.out.println("insert 작업 실패!!!!!");
			}
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			sqlSession.close(); //세션 닫기
		}
	}
}
