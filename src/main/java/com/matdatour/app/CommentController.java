package com.matdatour.app;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.matdatour.comment.CommentDTO;
import com.matdatour.comment.CommentService;
import com.matdatour.user.UserDTO;
import com.matdatour.user.UserService;

//REST : Representational State Transfer
//하나의 URI가 하나의 고유한 리소스를 대표하도록 설계된 개념

//http://localhost/spring02/list?bno=1 ==> url+파라미터
//http://localhost/spring02/list/1 ==> url
//RestController은 스프링 4.0부터 지원
//@Controller, @RestController 차이점은 메서드가 종료되면 화면전환의 유무
//@Controller
@RestController
public class CommentController {

	@Autowired
	CommentService commentService;
	@Autowired
	UserService userService;

	// 댓글 입력
	@RequestMapping(value = "/reply/insert.do", method = RequestMethod.POST)
	public String insert(@ModelAttribute CommentDTO commentdto, HttpSession session) {
		String user_id = (String) session.getAttribute("user_id");
		int board_num = commentdto.getBoard_num();
		commentdto.setC_replyer(user_id);
		commentdto.setC_user_nick(commentdto.getC_replyer());
		commentService.commentInsert(commentdto);
		System.out.println(commentdto);
		return "redirect:board/view.do?board_num=" + board_num;
	}

	/*
	 * // 댓글 목록(@Controller방식 : veiw(화면)를 리턴)
	 * 
	 * @RequestMapping("/reply/list.do") public ModelAndView list(@RequestParam
	 * int board_num, ModelAndView mav) { List<CommentDTO> list =
	 * commentService.selectAllComment(board_num); // 뷰이름 지정
	 * mav.setViewName("replyList"); // 뷰에 전달할 데이터 지정
	 * mav.addObject("commentlist", list); // replyList.jsp로 포워딩 return mav; }
	 */

	@RequestMapping(value = "/reply/list.do", method = RequestMethod.GET)
	public String commentlist(int board_num, Model model) throws Exception {
		List<CommentDTO> clist = commentService.selectAllComment(board_num);
		model.addAttribute("replyList", clist);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("replyList");
		return "redirect:board/view.do?board_num=" + board_num;

	}

}
