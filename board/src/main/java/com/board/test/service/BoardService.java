package com.board.test.service;

import java.util.List;

import com.board.test.domain.BoardVO;

public interface BoardService {

		public List<BoardVO> list() throws Exception;
		public void write(BoardVO vo) throws Exception;
		// 게시물 수정
		public void update(BoardVO vo) throws Exception;
		 
		// 게시물 삭제
		public void delete(int bno) throws Exception;
		 
		// 게시물 조회
		public BoardVO view(int bno) throws Exception;
		
		// 게시물 총 갯수
		public int count() throws Exception;
		
		//페이징 1 
		public List<BoardVO> listPage(int displayPost, int postNum)throws Exception;
}
