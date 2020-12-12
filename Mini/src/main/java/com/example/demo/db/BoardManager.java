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
	
	public static List<BoardVo> findAll(){
		List<BoardVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("board.selectAll");
		session.close();
		return list;
	}
	public static BoardVo findByNo(int no) {
		BoardVo b = null;
		SqlSession session = 
		sqlSessionFactory.openSession();
		b = session.selectOne("board.selectByNo", no);
		session.close();
		return b;
	}
	public static int insert(BoardVo b) {
		int re =  -1;
		SqlSession session
		= sqlSessionFactory.openSession(true);
		re = session.insert("board.insert", b);
		session.close();
		return re;
	}
	
	public static int getNextNo() {
		int n  = 0;
		SqlSession session
		= sqlSessionFactory.openSession();
		n = session.selectOne("board.nextNo");
		session.close();
		return n;
	}
	public static int updateStep(HashMap map) {
		int re = -1;
		SqlSession session
		= sqlSessionFactory.openSession(true);
		re = session.update("board.updateStep", map);
		session.close();
		return re;
	}
	
}