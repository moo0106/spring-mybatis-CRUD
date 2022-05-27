package com.spring.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.db.jdbc.board.model.BoardVO;
import com.spring.db.jdbc.board.repository.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TransactionTest {

	@Autowired
	private BoardDAO dao;

	@Test
	public void testOfInsert() throws Exception {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("트랜잭션 번 게시글 제목");
		vo.setContent("트랜잭션 번 게시글 내용");
		vo.setWriter("트랜잭션 번 테스터");
		dao.insertArticle(vo);
		
		vo.setTitle("트랜잭션 번 게시글 제목ㅇㅇ");
		vo.setContent("트랜잭션 번 게시글 내용ㅇㅇ");
		vo.setWriter("트랜잭션 번 테스터 초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과초과");
		dao.insertArticle(vo);
		}
		
	
}
