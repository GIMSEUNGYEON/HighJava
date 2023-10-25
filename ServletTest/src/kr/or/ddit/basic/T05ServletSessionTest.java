package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class T05ServletSessionTest extends HttpServlet {
	/*
	 * 세션(HttpSession)객체에 대하여
	 * 
	 * - 세션을 통해서 사용자(웹브라우저) 별로 구분하여 정보를 관리할 수 있다.(세션ID이용) - 쿠키를 사용할 때보다 보안이
	 * 향상된다.(정보가 서버에 저장되기 때문이다)
	 * 
	 * - 세션객체를 가져오는(생성하는) 방법 HttpSession session = req.getSession(boolean) 
	 * boolean :true 인경우 -> 세션객체가 존재하지 않으면 새로 생성 ==> 세션 생성(기본값) 
	 * 			false인경우 -> 세션객체가 존재하지 않으면 null을 리턴한다. ==> 세션 존재 여부 확인 
	 * 세션은 사용자별로 한개씩 만들어지도록 관리한다.
	 * 세션 정보를 담은 쿠키는 지속 시간이 세션과 동일하며 브라우저가 종료될때 쿠키가 함께 삭제되어 브라우저 재접속이 되면 쿠키가 새로 생성된다.
	 * 
	 * - 세션 객체 삭제처리 방법
	 * 1. invalidate() 메서드 호출
	 * 2. setMaxInactiveInterval(int interval) 메서드 호출
	 *  => 일정시간(초) 동안 요청이 없으면 세션 객체 삭제됨.
	 * 3. web.xml에 <session-config> 설정하기(분단위)
	 * <session-config>의 하위 태그 <session-timeout>태그 안에 숫자만 입력해두면 됨
	 * 이 방법을 사용하면 모든 세션 정보가 삭제
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 세션을 가져오는데 없으면 새로 생성한다.
		HttpSession session = req.getSession(true);

		// 실행시간 가져오기
		Date createTime = new Date(session.getCreationTime());

		// 마지막 접근 시간 가져오기
		Date lastAccessTime = new Date(session.getLastAccessedTime());

		String title = "재방문을 환영합니다.";
		int visitCnt = 0; // 방문 횟수
		String userId = "pc02"; // 사용자 Id

		if (session.isNew()) { // 새로 만들어진 세션 객체인지 판별
			title = "처음 방문을 환영합니다.";
			session.setAttribute("userId", userId);
		} else {
			visitCnt = (Integer) session.getAttribute("visitCnt");
			visitCnt++; //방문횟수 증가시키기
			userId = (String) session.getAttribute("userId");
		}

		session.setAttribute("visitCnt", visitCnt);
		
//		session.invalidate(); // 세션 무효화시키기
		//재방문을 해도 계속 처음 방문으로 세션이 초기화됨. 로그아웃할 때 주로 사용함.
		
//		session.setMaxInactiveInterval(30);
		//30초 이후 세션 초기화. 
		
		////////////////////////////////////////////////////////////////////////////
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<!DOCTYPE html><html><head><title>" + title + "</title></head><body>"
				+ "<h1 align=\"center\">" + title + "</h1>"
				+ "<h2 align=\"center\"> 세션 정보 </h2>"
				+ "<table border=\"1\" align=\"center\">"
				+ "<tr bgcolor=\"orange\">"
				+ "<th>구분</th><th>값</th></tr>"
				+ "<tr><td>세션ID</td><td>" + session.getId() + "</td></tr>"
				+ "<tr><td>생성 시간</td><td>" + createTime + "</td></tr>"
				+ "<tr><td>마지막 접근 시간</td><td>" + lastAccessTime + "</td></tr>"
				+ "<tr><td>USER ID</td><td>" + userId + "</td></tr>"
				+ "<tr><td>방문 횟수</td><td>" + visitCnt + "</td></tr>"
				+ "</table></body></html>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
