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
	public void form(@RequestParam(value = "no", defaultValue = "0") int no, Model model) {
		model.addAttribute("no", no);
		String title = "";
		if(no != 0) {
			title ="답글)"+ dao.findByNo(no).getTitle();
		}
		
		model.addAttribute("title", title);
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request, BoardVo b) {
		b.setIp(request.getRemoteAddr());
		
		String path = request.getRealPath("upload");
		System.out.println("path:"+path);
		int pno = b.getNo();
		int no = dao.getNextNo();
		int b_ref = no;
		int b_level =0;
		int b_step = 0;
		if(pno !=0 ) {
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
		System.out.println(b);		
		MultipartFile uploadFile = b.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		int fsize = 0;
		byte []data = null;
		if( fname != null && !fname.equals("")) {
			try{
				data = uploadFile.getBytes();
				fsize = data.length;
			}catch (Exception e) {		
				
			}
		}else {
			fname = "";
		}
		
		b.setFname(fname);
		b.setFsize(fsize);
		
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		int re = dao.insert(b);
		if(re <= 0) {
			mav.addObject("msg", "게시물 등록에 실패하였습니다.");
			mav.setViewName("error");
		}else {
			if(!fname.equals("")) {
				try {
					
					FileOutputStream fos = new FileOutputStream(path + "/"+ fname);
					fos.write(data);
					fos.close();
				}catch (Exception e) {
					System.out.println("예외발생:"+e.getMessage());
				}
			}
			
		}
		
		return mav;
	}
}