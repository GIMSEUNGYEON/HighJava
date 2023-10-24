package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T03ServletParameterTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 요청 객체로부터 파라미터 값을 가져오는 방법 - getParameter() : 파라미터값이 한개인 경우 사용함. -
		 * getParameterValues() : 파라미터 값이 여러개인 경우 사용함. ex) checkbox 등. -
		 * getParameterNames() : 요청객체에 존재하는 모든 파라미터 이름을 가져올 때 사용함.
		 */
		req.setCharacterEncoding("UTF-8");
		//반드시 getParameter를 쓰기 전에 setCharacterEncoding을 설정할것
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String[] hobbies = req.getParameterValues("hobby");

		String rlgn = req.getParameter("rlgn");

		String[] foods = req.getParameterValues("food");

		///////////////////////////////////////////////////////////////////////

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
//		resp.setContentType("text/plain"); 으로 하면 html의 <>태그들이 형식없이 텍스트 형태로 그대로 출력됨

		PrintWriter out = resp.getWriter();

		out.println("<html><body>");
		out.println("<p>username: " + username + "</p>");
		out.println("<p>password: " + password + "</p>");
		out.println("<p>gender: " + gender + "</p>");
//		out.println("<p>hobby: " + hobby + "</p>");
		out.print("<p>hobby: ");
		if (hobbies != null) {
			for (String hobby : hobbies) {
				out.print(hobby + " ");
			}
		}
		out.print("</p>");

		out.println("<p>rlgn: " + rlgn + "</p>");

		out.print("<p>food: ");
		if (foods != null) {
			for (String food : foods) {
				out.print(food + " ");
			}
		}
		out.print("</p>");

		Enumeration<String> params = req.getParameterNames();

		while (params.hasMoreElements()) {
			String paramName = params.nextElement();
			out.println("<hr>");
			out.print("<p>파라미터 이름 : " + paramName + "</p>");
			out.print("<p>파라미터 값 : " + req.getParameter(paramName) + "</p>");
		}
		out.print("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
//	doPost 메서드가 없을 경우 405 에러 발생
//	Http 메소드인 POST는 이 URL에 의해 지원되지 않습니다
}
