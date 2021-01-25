package net.project.util;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageMaker {
	//한번에 보여줄 블럭수가 5개일때,
	//[1] [2] [3] [4] [5]
	//[6] [7] [8] [9] [10]
	
	private int totalCount; 		//전체 게시물의 수
	private int startPage; 			//게시물의 화면에 보여질 시작 페이지 번호 [1],[6]
	private int endPage; 			//게시물의 화면에 보여질 마지막 페이지 번호[5],[10]
	private int displayPageNum;		//한번에 보여줄 블럭의 수
	private int maxPage;			//최대 페이지 개수
	//10개씩 보여준다. 전체 게시물의 갯수가 110개다. maxPage = 11page
	//10개씩 보여준다. 전체 게시물의 갯수가 109개다. maxPage = 11page
	//10개씩 보여준다. 전체 게시물의 갯수가 99개다. maxPage = 10page
	//이전, 다음이 존재하는지 유무를 위해서
	private boolean next;			//다음 페이징 블럭이 존재하는지 유무
	private boolean prev;			//이전 페이징 블럭이 존재하는지 유무
	
	private boolean first;			//최초 페이지로이동
	private boolean last;			//마지막 페이지로 이동
	
	
	Criteria cri;
	
	
	
	public PageMaker() {
		this(0);
	}
	
	public PageMaker(int totalCount) {
		this(new Criteria(),totalCount);//기본 크리트리아 값 가지고 페이지 블럭 처리
	}
	
	public PageMaker(Criteria cri, int totalCount) {
		setCri(cri);
		setTotalCount(totalCount);
		setDisplayPageNum(5);
	}
	
	public void calc() {
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum))*displayPageNum;
		
		startPage = (endPage - displayPageNum) + 1;
		
		maxPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}

		prev = (endPage - displayPageNum <= 0) ? false : true; //이전으로 이동 할 수 없다.
		
		next = (endPage == maxPage) ? false : true;
		
		first = startPage > 1 ? true : false;
		
		last = (cri.getPage() < maxPage) ? true : false;
		
	}
	
	
	public void setCri(Criteria cri) {
		this.cri = cri;
		calc();
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calc();
	}
	
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
		calc();
	}
	
	//검색 후 다른페이지 요청 보낼시, 같은 검색값으로 페이지만 다르게 보여주기 위해서 설정하는것. 
	public String makeQuery(int page) {
		
		//스프링의 라이브러리 
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance() //자동으로 ? 붙음
				.queryParam("page", page) //자동으로 &붙음
				.queryParam("perPageNum", cri.getPerPageNum())
				.queryParam("searchType", ( (SearchCriteria) cri).getSearchType())
				.queryParam("keyword", ( (SearchCriteria) cri).getKeyword())
				.build();
		String queryString = uriComponents.toUriString();
		System.out.println(queryString);
			return queryString;
	}

	
}
