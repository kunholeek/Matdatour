package com.matdatour.app;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.matdatour.user.UserDTO;
import com.matdatour.user.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	// 1. 로그인 화면
	@RequestMapping("/login.do")
	public String login() {
		return "login";
	}
	@RequestMapping("/home.do")
	public ModelAndView home(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "success");
		mav.setViewName("home");
		return mav;
	}
	// 2. 로그인 처리

	@RequestMapping("/loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute UserDTO userdto, HttpSession session) {
		boolean result = userService.loginCheck(userdto, session);
		ModelAndView mav = new ModelAndView();
		if (result == true) {// 로그인 성공
			session.setAttribute("user", userdto);
			// main.jsp로 이동
			mav.setViewName("home");
			mav.addObject("msg", "success");
		} else {// 로그인 실패
			mav.setViewName("login");// login.jsp로 이동
			mav.addObject("msg", "failure");
		}
		return mav;
	}

	// 3.로그아웃 처리

	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session) {
		userService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("msg", "logout");
		return mav;
	}

	// 4. 회원 목록.
	@RequestMapping("/list.do")
	public String selectAllUser(Model model) {
		List<UserDTO> list = userService.selectAllUser();
		model.addAttribute("list", list);
		return "user_list";
	}

	// 5. 회원 등록 페이지로 이동
	@RequestMapping("/write.do")
	public String userWrite() {
		return "user_write";
	}

	// 6. 회원 등록 처리 후 목록으로 redirect
	@RequestMapping("/insert.do")
	public String userInsert(@ModelAttribute UserDTO userdto) {
		userService.serv_userInsert(userdto);
		return "redirect:login.do";
	}

}
