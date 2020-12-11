package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDao;
import com.example.demo.vo.BoardVo;

@Controller
@RequestMapping("/insertBoard.do")
public class InsertBoardController {
	@Autowired
	private BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void form(Model model, @RequestParam(value = "no", defaultValue = "0") int no) {
		model.addAttribute("no", no);
		
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(BoardVo b) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		int no = dao.getNextNo();
		System.out.println("눈부신+"+no);
		b.setNo(no);
		System.out.println("눈부신 햇살이+"+no);

		int re = dao.insert(b);
		return mav;
		
		
	}

}
