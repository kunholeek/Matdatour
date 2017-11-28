package com.matdatour.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.matdatour.board.BoardService;
import com.matdatour.user.UserDTO;
import com.matdatour.user.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;
	@Autowired
	BoardService boardService;

	// 1. 로그인 화면
	@RequestMapping("/login.do")
	public String login() {
		return "login";
	}

	@RequestMapping("/home.do")
	public ModelAndView home() {
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

	// 5. 회원 등록 페이지로 이동
	@RequestMapping("/mapview.do")
	public String mapview() {
		return "mapview";
	}

	// 6. 회원 등록 처리 후 목록으로 redirect
	@RequestMapping("/insert.do")
	public ModelAndView userInsert(@ModelAttribute UserDTO userdto) {
		ModelAndView mav = new ModelAndView();
		String userIDChk = userdto.getUser_id();
		String userNickChk = userdto.getUser_nick();
		String userPhoneChk = userdto.getUser_phone();
		if (userService.selectByID(userIDChk) == null && userService.selectByNick(userNickChk) == null
				&& userService.selectByPhone(userPhoneChk) == null) {
			userService.serv_userInsert(userdto);
			mav.setViewName("login");
		} else if (userService.selectByID(userIDChk) != null) {
			mav.setViewName("user_write");
			mav.addObject("msg1", "idfail");
		} else if (userService.selectByNick(userNickChk) != null) {
			mav.setViewName("user_write");
			mav.addObject("msg1", "nickfail");
		} else if (userService.selectByPhone(userPhoneChk) != null) {
			mav.setViewName("user_write");
			mav.addObject("msg1", "phonefail");

		} else {
			mav.setViewName("user_write");
			mav.addObject("msg1", "IdNICKfail");
		}
		return mav;
	}

	@RequestMapping("/delete.do")
	public String userDelete(@RequestParam String user_id) {
		UserDTO userdto = new UserDTO();
		userdto = userService.selectByID(user_id);
		int user_num = userdto.getUser_num();
		System.out.println(user_num);
		boardService.boardDeleteByID(user_num);
		userService.serv_userDelete(user_id);
		return "redirect:list.do";

	}

	// 7. 회원 등록 페이지로 이동
	@RequestMapping("/updateready.do")
	public String mypageWrite(String user_id, Model model) {
		model.addAttribute("user", userService.selectByID(user_id));
		return "mypage";
	}

	// 회원 수정 처리후 목록으로 redirect
	@RequestMapping("/update.do")
	public String memberUpdate(@ModelAttribute UserDTO userdto) {
		userService.serv_userUpdate(userdto);
		return "redirect:home.do";
	}

	// 회원 아이디 찾기
	@RequestMapping("/findId.do")
	public String findId() {
		return "findID";
	}

	@RequestMapping("/find.do")
	public ModelAndView userfind(@RequestParam String user_phone) {
		ModelAndView mav = new ModelAndView();
		System.out.println("입력한 폰번호 >>>" + user_phone);
		UserDTO userdto = null;
		if (userService.selectByPhone(user_phone) != null) {
			userdto = userService.selectByPhone(user_phone);
			String user_id = userdto.getUser_id();
			mav.setViewName("findID");
			mav.addObject("user_id", user_id);
		} else {
			mav.setViewName("findID");
			mav.addObject("msg", "전화번호를 잘못 입력하셨습니다");

		}
		return mav;
	}

	// 회원 비밀번호찾기
	@RequestMapping("/findPWD.do")
	public String findPwd() {
		return "findPWD";
	}

	@RequestMapping("/findpw.do")
	public ModelAndView findpw(@RequestParam String user_id, String user_phone) {
		ModelAndView mav = new ModelAndView();
		System.out.println("입력한 ID >>>" + user_id);
		System.out.println("입력한 폰번호 >>>" + user_phone);
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("user_phone", user_phone);
		UserDTO userdto = null;
		if (userService.userPwdCheck(map) == null) {
			mav.setViewName("findPWD");
			mav.addObject("msg", "ID 또는 전화번호를 잘못 입력하셨습니다.");
		} else {
			userdto = userService.userPwdCheck(map);
			String user_pwd = userdto.getUser_pwd();
			mav.setViewName("findPWD");
			mav.addObject("user_pwd", user_pwd);
		}

		return mav;
	}
}
