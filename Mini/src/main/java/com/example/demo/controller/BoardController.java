package com.example.demo.controller;


import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.demo.dao.BoardDao;

@Controller
public class BoardController {
	
	public static int pageSIZE =  10;
	//한화면에 출력하고싶은 게시물의 수
	public static int totalCount  = 0;
	public static int totalPage = 1;	
	@Autowired
	private BoardDao dao;
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}


	@RequestMapping("/listBoard.do")
	public void list(Model model, @RequestParam(value = "pageNUM", defaultValue = "1") int pageNUM) {
		totalCount = dao.getTotalCount();
		totalPage = (int)Math.ceil( (double)totalCount/pageSIZE ) ;
		int start = (pageNUM-1)*pageSIZE + 1;
		int end = start + pageSIZE;
		if(end > totalCount) {
			end = totalCount;
		}
		
		HashMap map = new HashMap();
		map.put("start",start);
		map.put("end",end);
		
		model.addAttribute("list", dao.findAll(map));
		model.addAttribute("totalPage", totalPage);
	}
	
	@RequestMapping("/detailBoard.do")
	public void detail(int no, Model model) {
		model.addAttribute("b", dao.findByNo(no));
	}

}