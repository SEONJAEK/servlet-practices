package com.poscoict.guestbook.dao.test;

import java.util.List;

import com.poscoict.guestbook.dao.GuestbookDao;
import com.poscoict.guestbook.vo.GuestbookVo;

public class GuestbookDaoTest {
	public static void main(String[] args) {
		testInsert();
		testDelete();
		testFindAll();
	}
	private static void testInsert() {
		GuestbookVo vo = new GuestbookVo();
		vo.setName("경");
		vo.setReg_date("선재");
		vo.setMessage("안뉴유유우우웅 하세요~~~");
		
		boolean result = new GuestbookDao().insert(vo);
		System.out.println(result? "success" : "fail");
		
	}
	private static void testDelete() {
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(1);
		boolean result = new GuestbookDao().delete(vo);
		System.out.println(result? "삭제성공" : "삭제 실패");
	}
	private static void testFindAll() {
		List<GuestbookVo> list = new GuestbookDao().findAll();
		for(GuestbookVo vo : list) {
			System.out.println(vo);
		}
	}
	
}
