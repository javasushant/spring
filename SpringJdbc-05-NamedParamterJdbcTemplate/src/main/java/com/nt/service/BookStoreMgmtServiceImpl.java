package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IBookInfoDAO;
import com.nt.model.BookInfo;
@Service("service")
public class BookStoreMgmtServiceImpl implements IBookStoreMgmtService{
	
	@Autowired
	private IBookInfoDAO dao;

	@Override
	public BookInfo fetchBookInfoById(int bookId) {
		//use dao
		BookInfo info=dao.getBookById(bookId);
		return info;
	}//method

	@Override
	public List<BookInfo> fetchBooksByCategories(String category1, String category2, String category3) {
		List<BookInfo> list=dao.getBookByCategory(category1, category2, category3);
		return list;
	}

	@Override
	public String addBook(BookInfo info) {
		int count=dao.insert(info);
		return count==0?"Registration Failed ":"Registration successful";
	}
}//class
