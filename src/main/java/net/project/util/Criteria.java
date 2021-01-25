package net.project.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	private int page;//현재 사용자가 보고있는 페이지
	private int perPageNum;//몇개를 보여줄 것인가
	
	
	public Criteria() {
		//아무 값도 넘겨받지 않고 요청이 들어오면 첫번째 페이지에 한번에 10개 보여줌 
		this(1,10); 
	}

	public Criteria(int page, int perPageNum) {
		setPage(page);
		this.perPageNum = perPageNum;
	}
	
	//이하 검증 작업
	public void setPage(int page) {
		
		//0이거나 음수면 
		if(page <= 0) {
			this.page = 1;
			
		}
		this.page = page;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum < 0 || perPageNum >100) {
			this.perPageNum = 10;
		}
		
		this.perPageNum = perPageNum;
	}
	
	//게시물 검색시 limit
	//SELECT * FROM board limit 시작인덱스, 검색 게시물 수
	//SELECT * FROM board limit 0, perPageNum
	//select * from board limit 10, perPageNum
	//select * from board limit 20, perPageNum
	
	//시작인덱스 계산법
	public int getPageStart() {
		return (this.page-1)* perPageNum;
	}
	//		limit #{pageStart}
}
