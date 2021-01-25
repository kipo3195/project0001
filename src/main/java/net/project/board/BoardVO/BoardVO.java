package net.project.board.BoardVO;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	//주석 추가
	private int bNum;
	private String bTitle;
	private String bAuth;
	private String bContent;
	private Date regDate;
	private Date updateDate;
	

	
	
	
}
