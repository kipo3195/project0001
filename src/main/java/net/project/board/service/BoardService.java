package net.project.board.service;

import java.util.List;

import net.project.board.BoardVO.BoardVO;
import net.project.util.Criteria;
import net.project.util.PageMaker;

public interface BoardService {

	int ListCount() throws Exception;


	BoardVO DetailBoard(int bNum) throws Exception;

	String modify(BoardVO VO) throws Exception;

	String DELETE(int bNum)throws Exception;

	String regist(BoardVO vO)throws Exception;

	List<BoardVO> boardList(Criteria cri)throws Exception;

	PageMaker GetPagemaker(Criteria cri) throws Exception;






}
