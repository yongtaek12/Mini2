package com.example.demo.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		//view 폴더에 login.jsp파일을 뷰페이지로 선언
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(MemberVo vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		
		HttpSession session = req.getSession();
		HashMap map = new HashMap();
		String id = vo.getId();
		String pwd = vo.getPwd();
		map.put("id", id);
		map.put("pwd", pwd);

		MemberVo login = dao.login(map);
		
		if(login !=null) {
			session.setAttribute("name", login.getName());
			return "listBoard.do";
		}
		else return "login.do";
		
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
}
