package com.matdatour.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.matdatour.user_board_join.JoinDTO;
import com.matdatour.user_board_join.JoinService;

@Controller // 현재 클래스를 컨트롤러 빈(bean)으로 등록
@RequestMapping("/board/*")
public class JoinController {

	
	@Autowired
	JoinService joinService;

	//게시글 목록. 
	@RequestMapping("list.do")
	public ModelAndView list() throws Exception {
		List<JoinDTO> list = joinService.listAll();

		for(JoinDTO join : list){
			System.out.println(join);
		}
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board_list");
		mav.addObject("list", list);
		return mav;
	}

}
