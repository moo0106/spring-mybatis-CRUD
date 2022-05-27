package com.spring.db.jdbc.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.db.jdbc.board.model.BoardVO;
import com.spring.db.jdbc.board.repository.IBoardDAO;


@Service
public class BoardService implements IBoardService {

	@Autowired
	private IBoardDAO dao;
	
	@Override
	@Transactional ( propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10 )
	public void insertArticle(BoardVO article) throws Exception {
		dao.insertArticle(article);
	}

	@Override
	public List<BoardVO> getArticles() throws Exception {
		return dao.getArticles();
	}

	@Override
	public BoardVO getArticle(int index) throws Exception {
		return dao.getArticle(index);
	}

	@Override
	public void deleteArticle(int index) throws Exception {
		dao.deleteArticle(index);
	}

	@Override
	@Transactional ( propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10 )
	public void updateArticle(BoardVO article) throws Exception {
		dao.updateArticle(article);
	}

	@Override
	
	public List<BoardVO> searchList(String keyword) throws Exception {
		keyword = '%' + keyword + '%';
		return dao.searchList(keyword);
		
	}

}
