package com.example.demo.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.MemberDao;
import com.example.demo.vo.MemberVo;

@Controller
public class loginController {
	
	@Autowired
	private MemberDao dao;
	
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public void getlogin() {
		System.out.println("로그인 화면으로 이동");

		//view 폴더에 login.jsp파일을 뷰페이지로 선언
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(MemberVo vo, HttpServletRequest req, RedirectAttributes rttr) {
		
		HttpSession session = req.getSession();
		HashMap map = new HashMap();
		String id = vo.getId();
		System.out.println("tesddddddddddddddt"+id);
		String pwd = vo.getPwd();
		map.put("id", id);
		map.put("pwd", pwd);

		MemberVo login = dao.login(map);
		System.out.println("w=작동됌" + login);
		ModelAndView mav = new ModelAndView("redirect:/");
		if(login !=null) {
		session.setAttribute("name", login.getName());
		mav = new ModelAndView("redirect:/listBoard.do");
		}
		return mav;

		
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
}
