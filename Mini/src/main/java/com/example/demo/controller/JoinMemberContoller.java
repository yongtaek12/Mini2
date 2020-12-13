package com.example.demo.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.youiwe.webservice.BitSms;

@Controller
@RequestMapping("/join.do")
public class JoinMemberContoller {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public void form() {		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(String to, HttpSession session) {
		Random r = new Random();
		String msg  =  r.nextInt(10) +""+r.nextInt(10)+""+r.nextInt(10)+""+r.nextInt(10);
		//임의 코드 4자리 설정
		BitSms.sendMsg(to, msg);
		// to : 핸드폰번호 / msg 코드 번호 발송 기능
		session.setAttribute("sendMsg", msg);
		ModelAndView mav = new ModelAndView("redirect:/joinOk.do");
		return mav;
	}
}
