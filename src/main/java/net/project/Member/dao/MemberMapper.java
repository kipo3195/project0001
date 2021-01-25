package net.project.Member.dao;

import java.util.Map;

import net.project.Member.vo.MemberVO;

public interface MemberMapper {

	int joinMember(MemberVO vo)throws Exception;

	MemberVO loginCheck(Map<String, String> memberInfo)throws Exception;


}
