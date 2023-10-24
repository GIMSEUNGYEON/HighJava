package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T05ServletSessionTest extends HttpServlet {
	/*
	 세션(HttpSession)객체에 대하여
	 
	 - 세션을 통해서 사용자(웹으라우저) 별로 구분하여 정보를 관리할 수 있다.(세션ID이용)
	 - 쿠키를 사용할 때보다 보안이 향상된다.(정보가 서버에 저장되기 때문이다)
	 
	 - 세션객체를 가져오는(생성하는) 방법
	 HttpSession session = req.getSession(boolean)
	 boolean : true 인경우 -> 세션객체가 존재하지 않으면 새로 생성
	 		   false인경우 -> 세션객체가 존재하지 않으면 null을 리턴한다.
	 		   
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
