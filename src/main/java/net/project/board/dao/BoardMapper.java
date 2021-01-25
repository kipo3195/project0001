package net.project.board.dao;

import java.util.List;

import net.project.board.BoardVO.BoardVO;
import net.project.util.Criteria;

public interface BoardMapper {

	List<BoardVO> SelectList(Criteria cri) throws Exception;

	int count() throws Exception;

	BoardVO DetailBoard(int bNum) throws Exception;

	int modify(BoardVO vO) throws Exception;

	int delete(int bNum) throws Exception;

	int register(BoardVO vO) throws Exception;



}
