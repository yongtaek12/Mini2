package com.example.demo.controller;

import java.io.FileOutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(BoardVo b, HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		b.setIp(ip);
		String path = request.getRealPath("board_upload");
		System.out.println("path:"+path);
		MultipartFile uploadFile = b.getUploadFile();
		String fname= uploadFile.getOriginalFilename();
		b.setFname(fname);
		
		if(fname.equals("")) {
			System.out.println("업로드 파일이 없어요!");
		}else {
			System.out.println("업로드 파일이 있어요!");
		}
			
		
		try {
			byte []data = uploadFile.getBytes();
			FileOutputStream fos = new FileOutputStream(path + "/" + fname);
			fos.write(data);
			fos.close();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		int no = dao.getNextNo();
		int b_ref = no;
		int b_level = 0;
		int b_step = 0;
		
		int pno = b.getNo();
		if(pno != 0) {
			BoardVo p = dao.findByNo(pno);
			b_ref = p.getB_ref();
			b_level = p.getB_level();
			b_step = p.getB_step();
			
			HashMap map = new HashMap();
			map.put("b_ref", b_ref);
			map.put("b_step", b_step);
			dao.updateStep(map);			
			b_level++;
			b_step++;
		}
		
		
		
		b.setNo(no);
		b.setB_ref(b_ref);
		b.setB_level(b_level);
		b.setB_step(b_step);
		int re = dao.insert(b);
		if(re <= 0) {
			mav.addObject("msg", "게시물 등록에 실패하였습니다.");
			mav.setViewName("error");
		}
		
		return mav;
	}
}
