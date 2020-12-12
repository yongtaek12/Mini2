package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/joinOk.do")
public class JoinOkMemberContoller {

	@RequestMapping(method = RequestMethod.GET)
	public void form() {
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(String num, HttpSession session) {	
		ModelAndView mav = new ModelAndView();
		String sendMsg = (String)session.getAttribute("sendMsg");
		if(sendMsg.equals(num)) {			
			session.setAttribute("msg","전화번호 인증에 성공하였습니다.");
			mav.setViewName("redirect:/insertMember.do");
		}else {
			session.setAttribute("msg","전화번호 인증에 실패하였습니다.");
			mav.setViewName("redirect:/join.do");
		}
		return mav;
	}
}