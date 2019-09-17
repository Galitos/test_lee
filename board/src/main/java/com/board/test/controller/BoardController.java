package com.board.test.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.test.domain.BoardVO;
import com.board.test.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger= LoggerFactory.getLogger(BoardController.class);
	@Inject
	BoardService service;
	
	//날짜 타입 데이터 변환
	@InitBinder
	protected void initBinder(WebDataBinder wdb) {
			// SimpleDateFormat("yyyy-MM-dd")인 형태로 만 변환 시켜줌
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		wdb.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
	// 게시물 목록
	@RequestMapping(value = "/list", method =RequestMethod.GET)
	public void getList(Model model)throws Exception {
		List<BoardVO> list = null;
		list = service.list();
		
		model.addAttribute("list", list);		
	}
	//게시물 작성 get
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWirte() throws Exception {
		
	}
	//게시물 작성 post
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(BoardVO vo)throws Exception {
		service.write(vo);
		return "redirect:/board/list";
	}
	
	// 게시물 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("bno")int bno, Model model) throws Exception {
		logger.info("view 호출,,,");
		
	  BoardVO view = null;
	  view =  service.view(bno);

	  model.addAttribute("view", view);
	}
	
	//게시물 수정  get
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void getupdate(@RequestParam("bno") int bno,Model model)throws Exception {
		BoardVO view = null;
		view = service.view(bno);
		model.addAttribute("view", view);
	}
	
	// 게시물 수정 post
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String postUpdate(BoardVO vo)throws Exception {
		 service.update(vo);
		return "redirect:/board/list";
	}
	
	//게시물 삭제 get
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void getdelete(@RequestParam("bno") int bno, Model model)throws Exception {
		BoardVO view = null;
		view = service.view(bno);
		model.addAttribute("view", view);
	}
	// 게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postDelete(BoardVO vo) throws Exception {

	  service.delete(vo.getBno());

	  return "redirect:/board/list";
	}
	//게시물 목록 - 페이징 구현
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void getListPage(Model model, int num) throws Exception {
		
		//게시물 총 갯수
		int count = service.count();
		//한 페이지에 출력할 게시물 갯수
		int postNum = 10;
		
		//게시물 총 갯수 / 한 페이지에 출력할 게시물 갯수= 하단 페이징
		int pageNum = (int)Math.ceil((double)count/(double)10);
		
		// 선택한 페이지 번호(임시)
		//int selectNum = 1;
		
		// 출력할 게시물 
		int displayPost = (num - 1) * 10;
		
		List<BoardVO> list = null;
		list = service.listPage(displayPost, postNum);
		
		model.addAttribute("list", list);
		model.addAttribute("pageNum", pageNum);
	}
}
 





