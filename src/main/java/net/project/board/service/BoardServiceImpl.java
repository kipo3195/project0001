package net.project.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.project.board.BoardVO.BoardVO;
import net.project.board.dao.BoardMapper;
import net.project.util.Criteria;
import net.project.util.PageMaker;
@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	BoardMapper Bmapper;
	
	
	
	@Override
	public int ListCount() throws Exception {
		
		return Bmapper.count();
	}


	@Override
	public BoardVO DetailBoard(int bNum) throws Exception {
		
		return Bmapper.DetailBoard(bNum);
	}

	@Override
	public String modify(BoardVO VO) throws Exception {
		System.out.println("BOARDSERVICE"+VO);
		int result = Bmapper.modify(VO);
		String msg = null; 
		
		if(result != 0) {
			msg="S";
		}else {
			msg="F";
		} 
		return msg; 
	}

	@Override
	public String DELETE(int bNum) throws Exception {
		
		int result = Bmapper.delete(bNum);
		String msg = null; 
		if(result != 0) {
			msg="S";
		}else {
			msg="F";
		} 
		return msg; 
	}

	@Override
	public String regist(BoardVO VO) throws Exception {
		int result = Bmapper.register(VO);
		String msg = null; 
		if(result != 0) {
			msg="S";
		}else {
			msg="F";
		} 
		return msg; 
		
	}




	@Override
	public PageMaker GetPagemaker(Criteria cri) throws Exception {
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setDisplayPageNum(10);
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(Bmapper.count());
		
		return pageMaker;
	}


	@Override
	public List<BoardVO> boardList(Criteria cri) throws Exception {
		List<BoardVO> list =Bmapper.SelectList(cri);
		return list;
	}



	
	
}
