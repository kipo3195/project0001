package net.project.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//검색 기능 추가
@Getter
@Setter
@NoArgsConstructor //기본생성자
public class SearchCriteria extends Criteria{

	private String searchType;
	private String keyword;
	
	
	public SearchCriteria(int page, int perPageNum, String searchType, String keyword) {
		super(page, perPageNum);
		this.searchType = searchType;
		this.keyword = keyword;
	}


	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + ", getPageStart()="
				+ getPageStart() + ", getPage()=" + getPage() + ", getPerPageNum()=" + getPerPageNum() + "]";
	}

	
	
	
	
	
}
