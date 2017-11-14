package com.matdatour.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.matdatour.board.BoardDTO;
import com.matdatour.board.BoardService;
import com.matdatour.user.UserService;

@Controller // 현재 클래스를 컨트롤러 빈(bean)으로 등록
public class BoardController {

	// 의존관계 주입 => BoardServiceImpl 생성
	// IoC 의존관계 역전
	@Autowired
	BoardService boardService;
	UserService userService;

	// 1. 게시글 작성화면
	@RequestMapping(value = "/board/write.do", method = RequestMethod.GET)
	public String write() {
		return "board_write";
	}

	// 2. 게시글 작성처리
	@RequestMapping(value = "/board/insert.do", method = RequestMethod.POST)
	public String insert(@ModelAttribute BoardDTO boarddto) throws Exception {
		boardService.serv_boardInsert(boarddto);
		return "home";
	}

	// 2. 게시글 상세 조회
	@RequestMapping(value = "/board/view.do", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int board_num, String user_nick) throws Exception {
		System.out.println(user_nick);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("board_detail_view");
		
		mav.addObject("dto", boardService.detailView(board_num));
		mav.addObject("nick" , user_nick);
		return mav;

	}

	// 게시물 수정
	@RequestMapping(value = "/board/update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardDTO boarddto) throws Exception {
		boardService.serv_boardUpdate(boarddto);
		return "redirect:list.do";

	}

	@RequestMapping("/board/delete.do")
	public String delete(@RequestParam int board_num) throws Exception {
		boardService.serv_boardDelete(board_num);
		return "redirect:list.do";
	}

}
