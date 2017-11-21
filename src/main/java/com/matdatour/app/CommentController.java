package com.matdatour.app;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.matdatour.comment.CommentDTO;
import com.matdatour.comment.CommentService;

@RestController
@RequestMapping("/reply/*")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@RequestMapping("insert.do")
	public void insert(@ModelAttribute CommentDTO commentdto, HttpSession session){
		String user_nick = (String) session.getAttribute("user_nick");
		commentdto.setUser_nick(user_nick);
		commentService.serv_commentInsert(commentdto);
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam int board_num, ModelAndView mav){
		List<CommentDTO> list = commentService.selectAllComment(board_num);
		mav.setViewName("replyList");
        // 뷰에 전달할 데이터 지정
        mav.addObject("comment", list);
        // replyList.jsp로 포워딩
        return mav;
	}
	
	@RequestMapping("listJson.do")
    @ResponseBody // 리턴데이터를 json으로 변환(생략가능)
    public List<CommentDTO> listJson(@RequestParam int board_num){
        List<CommentDTO> list = commentService.selectAllComment(board_num);
        return list;
    }
}
