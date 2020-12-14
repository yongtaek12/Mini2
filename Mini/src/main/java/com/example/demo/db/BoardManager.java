package com.example.demo.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BoardVo;


public class BoardManager {
	
	public static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
		String resource = "com/example/demo/db/sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	public static List<BoardVo> findAll(HashMap map){
		List<BoardVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("board.selectAll", map);
		session.close();
		return list;
	}
	
	
	public static int getNextNo() {
		int re =  -1;
		SqlSession session 
		= sqlSessionFactory.openSession();
		re = session.selectOne("board.nextNo");
		session.close();
		return re;
	}
	
	public static int getTotalCount() {
		int re =  -1;
		SqlSession session 
		= sqlSessionFactory.openSession();
		re = session.selectOne("board.selectCount");
		session.close();
		return re;
	}
	
	public static int insert(BoardVo b) {
		int re =  -1;
		SqlSession session 
		= sqlSessionFactory.openSession(true);
		re = session.insert("board.insert", b);
		session.close();
		return re;
	}
	
	public static int update(BoardVo b) {
		int re =  -1;
		SqlSession session 
		= sqlSessionFactory.openSession(true);
		re = session.update("board.update", b);
		session.close();
		return re;
	}
	
	public static int delete(HashMap map) {
		int re =  -1;
		SqlSession session 
		= sqlSessionFactory.openSession(true);
		re = session.delete("board.delete", map);
		session.close();
		return re;
	}
	
	public static int updateStep(HashMap map) {
		int re =  -1;
		SqlSession session 
		= sqlSessionFactory.openSession(true);
		re = session.update("board.updateStep", map);
		session.close();
		return re;
	}
	
	public static BoardVo findByNo(int no) {
		BoardVo b = null;
		SqlSession session
		= sqlSessionFactory.openSession();
		b = session.selectOne("board.selectByNo", no);
		System.out.println("객체정보.........................");
		System.out.println(b);
		System.out.println("---------------------------------");
		session.close();
		return b;
	}
	
	
}