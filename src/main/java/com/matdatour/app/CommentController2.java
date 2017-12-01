package com.matdatour.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.matdatour.comment.CommentService;

@Controller
public class CommentController2 {
	@Autowired
	CommentService commentService;

	@RequestMapping(value = "reply/delete.do", method = RequestMethod.GET)
	public String commentDelete(@RequestParam int board_num, int c_num) {
		commentService.commentDelete(c_num);
		return "redirect:../board/view.do?board_num=" + board_num;
	}
	
	@RequestMapping(value = "reply/update.do", method = RequestMethod.GET)
	public String commentUpdate(int board_num, int c_num, String c_comment){
		System.out.println("++++"+c_comment);
		System.out.println("++++"+c_num+"*****" + board_num);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("c_num", c_num);
		map.put("c_comment", c_comment);
		/*commentService.commentUpdate(c_num);*/
		commentService.commentUpdate(map);
		return "redirect:../board/view.do?board_num=" + board_num;
	}
}
