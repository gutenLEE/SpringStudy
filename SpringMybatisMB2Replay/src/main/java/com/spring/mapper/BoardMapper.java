package com.spring.mapper;

import java.util.HashMap;
import java.util.List;

import com.spring.mb2replay.board.BoardVO;

public interface BoardMapper {
	
	int getListCount();
	List<BoardVO> getBoardList(HashMap<String, Integer> map); //int page,int limit)
	BoardVO getDetail(int num);
	int boardInsert(BoardVO board);
	int boardReply(BoardVO board);
	int boardReplyUpdate(BoardVO board);
	int boardModify(BoardVO modifyboard);
	int boardDelete(HashMap<String, String> hashmap);
	//boolean boardDelete(int num);
	void setReadCountUpdate(int num);
	boolean isBoardWriter(HashMap<String, String> hashmap);
	BoardVO boardModifyForm(int num);
	
}
