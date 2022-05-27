package com.spring.db.jdbc.board.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.db.jdbc.board.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace = "mappers.BoardMapper";

	// 게시글 등록
	public void insertArticle(BoardVO vo) throws Exception {
		sqlSession.insert(namespace + ".insertArticle", vo);
	}

	// 전체 게시글 목록 가져오기
	public List<BoardVO> getArticles() throws Exception {
		List<BoardVO> Boardlist = new ArrayList<BoardVO>();
		Boardlist = sqlSession.selectList(namespace + ".getArticles");
		return Boardlist;
	}

	// 게시글 상세 보기
	public BoardVO getArticle(int index) throws Exception {
		BoardVO vo = sqlSession.selectOne(namespace + ".getArticle", index);
		return vo;
	}

	// 게시글 삭제
	public void deleteArticle(int index) throws Exception {
		sqlSession.delete(namespace + ".deleteArticle", index);
	}

	// 게시글 수정
	public void updateArticle(BoardVO vo) throws Exception {
		sqlSession.update(namespace + ".updateArticle", vo);
	}

	// 게시글 검색
	public List<BoardVO> searchList(String keyword) throws Exception {
		List<BoardVO> Boardlist = new ArrayList<BoardVO>();
		Boardlist = sqlSession.selectList(namespace + ".searchList", keyword);
		return Boardlist;
	}
}
