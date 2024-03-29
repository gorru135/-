package edu.kh.book.model.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.book.model.dao.BookDAO;
import edu.kh.book.model.dto.Book;

import static edu.kh.book.common.JDBCTemplate.*;
public class BookService {

	private BookDAO dao = new BookDAO();

	public List<Book> selectAll(int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Book> bookList = dao.selectAll(conn,memberNo);
		
		close(conn);
		
		return bookList;
	}

	public Book selectPrice() throws Exception{
		Connection conn = getConnection();
		
		Book book = dao.selectPrice(conn);
		
		close(conn);
		
		return book;
	}

	public List<Book> SelectBook(String bookTitle) throws Exception{
		Connection conn = getConnection();
		
		List<Book> bookList = dao.SelectBook(conn,bookTitle);
		
		close(conn);
		
		return bookList;
	}


}
