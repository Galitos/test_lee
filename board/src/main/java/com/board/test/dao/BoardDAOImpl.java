package com.board.test.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.test.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sql;
	
	
	//게시물 목록
	@Override
	public List<BoardVO> list() throws Exception {
		
		return sql.selectList("board.list");
	}

	//게시물 작성
	@Override
	public void write(BoardVO vo) throws Exception {
		sql.insert("board.write", vo);
	}

	// 게시물 수정
	@Override
	public void update(BoardVO vo) throws Exception {
	 sql.update("board.update", vo);
	}

	// 게시물 삭제
	@Override
	public void delete(int bno) throws Exception {
	 sql.delete("board.delete", bno);
	}

	// 게시물 조회
	@Override
	public BoardVO view(int bno) throws Exception {
	 return sql.selectOne("board.view", bno);
	}

	@Override
	public int count() throws Exception {
		return sql.selectOne("board.count");
	}

	@Override
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception {
		
		HashMap<String, Integer> myMap = new HashMap<String, Integer>();
		
		myMap.put("displayPost", displayPost);
		myMap.put("postNum", postNum);
		
		return sql.selectList("board.listPage", myMap);
	}

}
