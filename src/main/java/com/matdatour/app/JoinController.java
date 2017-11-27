package com.matdatour.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.matdatour.user_board_join.UserBoardDTO;
import com.matdatour.user_board_join.UserBoardService;

@Controller // 현재 클래스를 컨트롤러 빈(bean)으로 등록
@RequestMapping("/board/*")
public class JoinController {

	@Autowired
	UserBoardService userboardService;

	// 게시글 목록.
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public String list(String board_group, Model model) throws Exception {
		System.out.println("list >> " + board_group);
		List<UserBoardDTO> list = userboardService.listAll(board_group);
		model.addAttribute("board_list", list);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board_list");

		return "board_list";
	}

	@RequestMapping(value = "search.do", method = RequestMethod.POST)
	public ModelAndView slist(@RequestParam(defaultValue = "title") String searchOption,
			@RequestParam(defaultValue = "") String keyword) {
		List<UserBoardDTO> slist = userboardService.slistAll(searchOption, keyword);
		 ModelAndView mav = new ModelAndView();
		 
		 Map<String, Object> map = new HashMap<String, Object>();
		    map.put("slist", slist); // list 
		    map.put("searchOption", searchOption); // 검색옵션
		    map.put("keyword", keyword); // 검색키워드
		    mav.addObject("map", map); // 맵에 저장된 데이터를 mav에 저장
		    mav.setViewName("search_list"); // 뷰를 list.jsp로 설정
		    return mav; // list.jsp로 List가 전달된다.
		 
	}

}
