package edu.kh.book.member.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.book.member.model.dto.Member;
import edu.kh.book.member.model.service.MemberService;
import edu.kh.book.model.dto.Book;
import edu.kh.book.model.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");
			
			MemberService service = new MemberService();
			
			Member loginMember = service.login(inputId,inputPw);
			
			HttpSession session = req.getSession();
			
			if(loginMember != null) {
				
				session.setAttribute("loginMember", loginMember);
				
				session.setMaxInactiveInterval(60 * 60);
				
				
				
				// 현재 로그인한 회원
				BookService bookService = new BookService();
				
				List<Book> bookList = bookService.selectAll(loginMember.getMemberNo());
				
				session.setAttribute("bookList", bookList);
				
				
				
				resp.sendRedirect("/");
				
			} else {
				
				session.setAttribute("message", "아이디 또는 비밀번호 불일치");
				
				String referer = req.getHeader("referer");
				
				resp.sendRedirect(referer);
			}
			
			
		} catch(Exception e) {
			System.out.println("로그인 중 예외 발생");
			e.printStackTrace();
			
		}
	}
}
