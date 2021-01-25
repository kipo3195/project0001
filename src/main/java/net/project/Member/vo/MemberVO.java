package net.project.Member.vo;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberVO {

	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	private Date regdate;
	private Date updatedate;
	
}
