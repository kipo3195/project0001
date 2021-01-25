package net.project.Member.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.project.Member.dao.MemberMapper;
import net.project.Member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberMapper MM;
	
	@Override
	public String joinMember(MemberVO vo) throws Exception {
		int result =MM.joinMember(vo);
		
		if(result != 0) {
			return "S";
		}
		
		return "F";
	}
	@Override
	public MemberVO loginSubmit(String userid,String userpw) throws Exception {
		Map<String, String> memberInfo = new HashMap<String, String>();
		memberInfo.put("userid", userid);
		memberInfo.put("userpw", userpw);
		
		return MM.loginCheck(memberInfo);
	}

	
}
