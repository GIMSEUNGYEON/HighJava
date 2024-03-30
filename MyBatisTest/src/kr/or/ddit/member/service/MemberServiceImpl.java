package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.VO.MemberVO;
import kr.or.ddit.member.dao.IMemberDao;
//import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.dao.MemberDaoImplWithMyBatis;

//현재는 코드가 간결해서 서비스가 있을 필요성이 거의 없지만 주석처리한 부분 등을 처리하는 역할을 한다.
//서비스가 트랜잭션의 하나의 단위가 되어 서비스 하나가 완전히 실행된 후에 커밋함으로써 오류를 줄이고 일괄처리가 가능해진다.

public class MemberServiceImpl implements IMemberService {
	
	private IMemberDao memDao;
	
	private static IMemberService memService;
	
 
	private MemberServiceImpl() {
		memDao = MemberDaoImplWithMyBatis.getInstance();
//		memDao = MemberDaoImpl.getInstance();
//		인터페이스 기반 코딩을 했기 때문에 jdbc 버전이 필요하다면 위로 바꿔치기만 하면 됨
	}
	
	public static IMemberService getInstance() {
		if(memService == null) {
			memService = new MemberServiceImpl();
		}
		return memService;
	}
	
	@Override
	public int registerMember(MemberVO mv) {
		
		//회원정보 DB 등록
		
		//회원 등록 이력 정보 남기기
		
		//등록된 회원 이메일로 메일 발송처리
		
		int cnt = memDao.insertMember(mv);
		
		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {
		
		return memDao.checkMember(memId);
	}

	@Override
	public int modifyMember(MemberVO mv) {
		
		int cnt = memDao.updateMember(mv);
		
		return cnt;
	}

	@Override
	public int removeMember(String memId) {
		
		int cnt = memDao.deleteMember(memId);
		
		return cnt;
	}

	@Override
	public List<MemberVO> displayAllMember() {
		
		List<MemberVO> memList = memDao.selectAllMember();
	
		return memList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		
		List<MemberVO> memList = memDao.searchMember(mv);
		
		return memList;
	}
	
	
}
