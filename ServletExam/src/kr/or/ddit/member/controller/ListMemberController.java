package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.VO.MemberVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet(value="/member/list.do") // 어노테이션을 통해 web.xml을 사용하지 않고 서블릿을 서버에 연결할 수 있다. ~패키지 이름~/member/list.do로 연결함.
public class ListMemberController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IMemberService memService = MemberServiceImpl.getInstance();
		
		List<MemberVO> memList = memService.displayAllMember();
		
		req.setAttribute("memList", memList);
		//요청 객체에 memList 객체를 넣어서 jsp에서 사용할 수 있도록 forward(req, resp)
		
		
		req.getRequestDispatcher("/views/member/list.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
