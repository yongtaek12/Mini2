package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.MemberDao;
import com.example.demo.vo.MemberVo;

@Controller
public class MemberController {
	@Autowired
	private MemberDao dao;
	
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	@RequestMapping(value = "/insertMember.do", method= RequestMethod.GET)
	public void getInsert() {
		
	}
	@RequestMapping(value = "/insertMember.do", method= RequestMethod.POST)
	public int postInsert(MemberVo m) {
		int re = dao.insert(m);
		return re;
	}
}
