package com.spring.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.db.jdbc.board.model.BoardVO;
import com.spring.db.jdbc.board.repository.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class InsertTest {

	@Autowired
	private BoardDAO dao;

	@Test
	public void testOfInsert() throws Exception {
		BoardVO vo = new BoardVO();
		for(int i=0;i<100;i++) {
		vo.setTitle(i + "번 게시글 제목");
		vo.setContent(i + "번 게시글 내용");
		vo.setWriter(i+"번 테스터");
		dao.insertArticle(vo);
		}
		
	}
}
