package edu.kh.book.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static edu.kh.book.common.JDBCTemplate.*;

import edu.kh.book.member.model.dao.MemberDAO;
import edu.kh.book.model.dto.Book;

public class BookDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public BookDAO() {
		try {
			prop = new Properties();
			
			String filePath
				= MemberDAO.class.getResource("/edu/kh/book/sql/book-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<Book> selectAll(Connection conn, int memberNo) throws Exception{
		List<Book> bookList = new ArrayList<Book>();
		
		try {
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			
			rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				Book book = new Book();
				
				String bookTitle = rs.getString("BOOK_TITLE");
				String bookAuthor = rs.getString("BOOK_AUTHOR");
				String publisher = rs.getString("PUBLISHER");
				int price = rs.getInt("PRICE");
				int bookNo = rs.getInt("BOOK_NO");
				
				book.setBookNo(bookNo);
				book.setBookTitle(bookTitle);
				book.setBookAuthor(bookAuthor);
				book.setPublisher(publisher);
				book.setBookPrice(price);
				
				bookList.add(book);
			}
					
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		
		return bookList;
	}

	public Book selectPrice(Connection conn) throws Exception{
		Book book = null;
		
		try {
			String sql = prop.getProperty("selectPrice");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				String bookTitle = rs.getString("BOOK_TITLE");
				String bookAuthor = rs.getString("BOOK_AUTHOR");
				int price = rs.getInt("PRICE");
				
				book = new Book();
				
				book.setBookTitle(bookTitle);
				book.setBookAuthor(bookAuthor);
				book.setBookPrice(price);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		return book;
	}

	public List<Book> SelectBook(Connection conn, String bookTitle) throws Exception {
		List<Book> bookList = new ArrayList<Book>();
		
		try {
			String sql = prop.getProperty("SelectBook");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bookTitle);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				
			
				String bookAuthor = rs.getString("BOOK_AUTHOR");
				String publisher = rs.getString("PUBLISHER");
				int price = rs.getInt("PRICE");
				
				book.setBookTitle(bookTitle);
				book.setBookAuthor(bookAuthor);
				book.setPublisher(publisher);
				book.setBookPrice(price);
				
				bookList.add(book);
			}
					
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		
		return bookList;
	}

}
