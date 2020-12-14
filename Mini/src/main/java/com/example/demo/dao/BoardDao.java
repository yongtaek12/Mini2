package com.example.demo.dao;


import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.BoardManager;
import com.example.demo.vo.BoardVo;



@Repository
public class BoardDao {

	public int getTotalCount() {
		return BoardManager.getTotalCount();
	}
	
	public int delete(HashMap map) {
		return BoardManager.delete(map);
	}
	
	public int update(BoardVo b) {
		return BoardManager.update(b);
	}
	
	public int getNextNo() {
		return BoardManager.getNextNo();
	}
	
	public List<BoardVo> findAll(HashMap map){
		return BoardManager.findAll(map);
	}
	
	public int insert(BoardVo b) {
		return BoardManager.insert(b);
	}
	
	public BoardVo findByNo(int no) {
		return BoardManager.findByNo(no);
	}
	
	public int updateStep(HashMap map) {
		return BoardManager.updateStep(map);
	}


}