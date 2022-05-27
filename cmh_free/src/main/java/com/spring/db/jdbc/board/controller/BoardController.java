package com.spring.db.jdbc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.db.jdbc.board.model.BoardVO;
import com.spring.db.jdbc.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	//글 작성 화면 요청
	@GetMapping("/write")
	public void write() {
		System.out.println("/board/write: GET");
	}
	 
	@PostMapping("/write")
	public String write(BoardVO article) throws Exception {
	
		System.out.println("/board/write: POST");
		service.insertArticle(article); // 데이터베이스에 입력
	
		return "redirect:/board/list"; // 등록 폼으로 리다이렉트
	}
	
	//글 목록 화면 요청
	@GetMapping("/list")
	public void list(Model model) throws Exception{
		//DB 대용 리스트에서 가지고 온 글 목록을 list.jsp파일로 전달해서
		//브라우저에 글 목록을 띄워주면 된다.
		System.out.println("/board/list: GET"); 
		
		model.addAttribute("articles", service.getArticles()); // 데이터베이스 배열 가져오기
	}
	
	@GetMapping("/content")
	public void content(Model model, int boardNo) throws Exception {
		System.out.println("/board/content?boardNo=" + boardNo + ": GET");
		model.addAttribute("article",service.getArticle(boardNo));
		
	}
	
	@GetMapping("/modify")
	public void modify(@ModelAttribute("boardNo")int boardNo, Model model) throws Exception {
		System.out.println("/board/modify?boardNo=" + boardNo + ": GET");
		model.addAttribute("article",service.getArticle(boardNo));
	}
	
	@PostMapping("/modify")								// 이름이 같으면 RequestParam 생략 가능
	public String modify(BoardVO article) throws Exception {
		System.out.println("/board/modify?boardNo=" + article.getBoardNo() + ": POST");
		service.updateArticle(article);
		
		return "redirect:/board/content?boardNo=" + article.getBoardNo();
	}
	
	
	@GetMapping("/delete")
	public String delete(@ModelAttribute("boardNo") int boardNo
			/*RedirectAttributes ra */) throws Exception {
		System.out.println("삭제할 번호 : " + boardNo);
		service.deleteArticle(boardNo);
		
		return "redirect:/board/list";
	}
	
	//게시글 검색 처리 요청.
	@GetMapping("/searchList")
	public String searchlist(String keyword, Model model) throws Exception {
		model.addAttribute("articles", service.searchList(keyword));
		
		return "/board/list";
	}
	
}
