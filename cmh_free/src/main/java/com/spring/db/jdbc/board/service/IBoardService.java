package com.spring.db.jdbc.board.service;

import java.util.List;

import com.spring.db.jdbc.board.model.BoardVO;

public interface IBoardService {

	//게시글 등록
	void insertArticle(BoardVO article) throws Exception;
	
	//전체 게시글 목록 가져오기
	List<BoardVO> getArticles() throws Exception;
	
	//게시글 상세 보기
	BoardVO getArticle(int index) throws Exception;
	
	//게시글 삭제
	void deleteArticle(int index) throws Exception;
	
	//게시글 수정
	void updateArticle(BoardVO article) throws Exception;
	
	//게시글 검색
	List<BoardVO> searchList(String keyword) throws Exception;
}
