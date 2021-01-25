package net.project.Member.service;

import org.springframework.stereotype.Service;

import net.project.Member.vo.MemberVO;

@Service
public interface MemberService {

	String joinMember(MemberVO vo) throws Exception;

	MemberVO loginSubmit(String userid, String userpw) throws Exception;

}
