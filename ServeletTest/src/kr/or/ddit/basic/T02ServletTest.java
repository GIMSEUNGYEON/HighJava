package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T02ServletTest extends HttpServlet {
	/*
	 서블릿 동작 방식에 대하여
	 
	 1. 사용자(클라이언트)가 URL을 클릭하면 Http Request를 서블릿 컨테이너로 전송(요청)한다.
	 2. 컨테이너는 web.xml에 정의된 url패턴을 확인하여 어느 서블릿을 통해 처리해야 할지를 검색한다.
	  (로딩이 안된 경우에는 로딩처리함. 로딩시 init() 메서드 호출됨.)
	 3. 서블릿 컨테이너는 요청을 처리할 개별 스레드 객체를 생성하여 해당 서블릿 객체의 service() 메서드를 호출한다.
	  (HttpServletRequest 및 HttpServletResponse 객체를 생성하여 파라미터로 넘겨준다.)
	 4. service() 메서드는 메서드타입을 체크하여 적절한 메서드를 호출한다.(doGet, doPost, doPut 등)
	 5. 요청 처리가 완료되면 HttpServletRequest 및 HttpServletResponse 객체는 소멸된다.
	 6. 컨테이너로부터 서블릿이 제거되는 경우에는 destroy() 메서드가 호출된다.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청 객체의 메서드 
		System.out.println("getCharacterEncoding() : " + req.getCharacterEncoding());
		System.out.println("getContentLength() : " + req.getContentLength());
		System.out.println("getQueryString() : " + req.getQueryString());
		System.out.println("getProtocol() : " + req.getProtocol());
		System.out.println("getRequestURI() : " + req.getRequestURI());
		System.out.println("getRemoteAddr() : " + req.getRemoteAddr());
		System.out.println("getRemotePort() : " + req.getRemotePort());

		//url 뒤에 ?name=홍길동&age=19 등 정보를 입력하면 쿼리스트링이 출력됨(없으면 null)
		//이러한 방식으로 doGet 메서드에서도 브라우저에 데이터를 전송할 수 있으나 url 길이엔 제한이 있기 때문에 보낼 수 있는 정보량에 한계가 있음.
		
		
		//Post 방식으로 넘어오는 Body 데이터를 인코딩 처리함. GET 방식인 경우 톰캣이 자동으로 인코딩 처리함.
		//요청객체로부터 값을 가져오기 전에 먼저 설정해야 적용 됨.
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		//요청 메시지에서(서버를 통해) 오는 데이터들은 getParameter로 데이터를 받을 수 있음
		//GET 방식에서는 브라우저 url에서 ?name=이름 과 같은 방식을 통해 서버에 데이터를 전송할 수 있음.
		//이러한 방식을 쿼리 스트링이라고 하며, url의 길이에는 제한이 있기 때문에 제약사항이 많다.
		System.out.println("name => "  + name);
		
		//요청 객체에 정보 저장하기
		req.setAttribute("tel", "1111-1111");
		req.setAttribute("addr", "대전시 중구 오류동");
		
		//요청 객체에 저장된 정보 꺼내기
		System.out.println("tel => " + req.getAttribute("tel"));
		System.out.println("addr => " + req.getAttribute("addr"));
		//setAttribute로 이미 값을 저장한 후에 getAttribute 가능
		
		//응답 메시지 생성하기(응답 객체 이용)
		
		resp.setCharacterEncoding("UTF-8");
		//POST 방식에서 필수적임
		resp.setContentType("text/plain");
		//POST 방식에서 필수적임
		resp.setHeader("Content-type", "text/plain");
		//혹은 이 방식 사용 가능

		//실제 응답 메시지 생성하는 부분
		PrintWriter out = resp.getWriter();
		
		out.println("name => " + name);
		out.println("서블릿 경로 => " + req.getServletPath());
		out.println("컨텍스트 경로 => " + req.getContextPath());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
