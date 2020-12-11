package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.BoardDao;

@Controller
public class BoardController {
	
	
	@Autowired
	private BoardDao dao;
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}


	@RequestMapping("/listBoard.do")
	public void list(Model model) {
		model.addAttribute("list", dao.findAll());
	}
	@RequestMapping("/detailBoard.do")
	public void detail(int no, Model model) {
		model.addAttribute("b", dao.findByNo(no));
	}

}