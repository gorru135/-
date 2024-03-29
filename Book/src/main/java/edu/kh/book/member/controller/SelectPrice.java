package edu.kh.book.member.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.book.model.dto.Book;
import edu.kh.book.model.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/selectPrice")
public class SelectPrice extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BookService service = new BookService();
		
		try {
			
			Book book = service.selectPrice();	
			
			HttpSession session = req.getSession();
			
			session.setAttribute("book", book);
			
		} catch(Exception e) {
			System.out.println("가격별 조회 중 예외 발생");
			e.printStackTrace();
		}
		
		
		req.getRequestDispatcher("/WEB-INF/views/selectPrice.jsp").forward(req, resp);
	}
}
