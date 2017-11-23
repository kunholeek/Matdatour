package com.matdatour.app;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.matdatour.board.BoardDAO;
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
	public String insert(MultipartHttpServletRequest mRequest) throws Exception {
		BoardDTO boarddto = new BoardDTO();
		ModelAndView mav = new ModelAndView();
		String file = null;
		// int board_num = Integer.parseInt(mRequest.getParameter("board_num"));
		String board_group = mRequest.getParameter("board_group");
		String title = mRequest.getParameter("title");
		String m_content = mRequest.getParameter("m_content");
		int user_num = Integer.parseInt(mRequest.getParameter("user_num"));
		String m_image = mRequest.getParameter("m_image");
		file = boardService.fileUpload(mRequest);

		System.out.println("[그룹 :" + board_group + "] " + "[제목 : " + title + "] " + "[내용 : " + m_content + "] "
				+ "[유저넘버 :" + user_num + "]");
		boarddto.setBoard_group(board_group);
		boarddto.setTitle(title);
		boarddto.setM_content(m_content);
		boarddto.setUser_num(user_num);
		boarddto.setM_image(file);

		boardService.serv_boardInsert(boarddto);
		mav.setViewName("home");
		String encodeResult = URLEncoder.encode(board_group, "UTF-8");

		return "redirect:list.do?board_group=" + encodeResult;
	}

	// 2. 게시글 상세 조회
	@RequestMapping(value = "/board/view.do", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int board_num, String user_nick) throws Exception {
		System.out.println(user_nick);
		ModelAndView mav = new ModelAndView();

		mav.setViewName("board_detail_view");

		mav.addObject("dto", boardService.detailView(board_num));
		mav.addObject("nick", user_nick);
		return mav;

	}

	@RequestMapping("/board/boardUpdate.do")
	public String boardUpdate() {
		return "board_update";
	}

	// 게시물 수정
	@RequestMapping(value = "/board/update.do", method = RequestMethod.POST)
	public String update(MultipartHttpServletRequest mRequest) throws Exception {

		BoardDTO boarddto = new BoardDTO();
		ModelAndView mav = new ModelAndView();
		String file = null;
		
		 int board_num = Integer.parseInt(mRequest.getParameter("board_num"));
		String board_group = mRequest.getParameter("board_group");
		String title = mRequest.getParameter("title");
		String m_content = mRequest.getParameter("m_content");
		int user_num = Integer.parseInt(mRequest.getParameter("user_num"));
		String m_image = mRequest.getParameter("m_image");
		file = boardService.fileUpload(mRequest);
		System.out.println( m_image);
		System.out.println(file);

		System.out.println("[그룹 :" + board_group + "] " + "[제목 : " + title + "] " + "[내용 : " + m_content + "] "+
						 "[유저넘버 :" + user_num + "]");
		boarddto.setBoard_num(board_num);
		boarddto.setBoard_group(board_group);
		boarddto.setTitle(title);
		boarddto.setM_content(m_content);
		boarddto.setUser_num(user_num);
		if(file!=null){
			boarddto.setM_image(file);
		}else{
			boarddto.setM_image(m_image);
		}
		
		
		System.out.println("업데이트"+boarddto);
		boardService.serv_boardUpdate(boarddto);
		
	
		String encodeResult = URLEncoder.encode(board_group, "UTF-8");

		return "redirect:list.do?board_group=" + encodeResult;
	}

	// 글삭제
	@RequestMapping("/board/delete.do")
	public String delete(@RequestParam int board_num, String board_group) throws Exception {
		System.out.println(board_num + "번 게시글 삭제" + board_group);

		boardService.serv_boardDelete(board_num);

		String encodeResult = URLEncoder.encode(board_group, "UTF-8");

		return "redirect:list.do?board_group=" + encodeResult;
	}

}
