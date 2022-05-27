package com.spring.db;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.db.jdbc.board.model.BoardVO;
import com.spring.db.jdbc.board.repository.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ListTest {

	@Autowired
	private BoardDAO dao;

	@Test
	public void testOfList() throws Exception {
		List<BoardVO> voList = dao.getArticles();
		for(BoardVO svo : voList) {
			System.out.println(svo.toString());
		}
	}
}
