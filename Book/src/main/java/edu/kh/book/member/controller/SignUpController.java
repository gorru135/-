package edu.kh.book.member.controller;

import java.io.IOException;

import edu.kh.book.member.model.dto.Member;
import edu.kh.book.member.model.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignUpController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String inputName = req.getParameter("inputName");
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputpw");
			char gender = req.getParameter("gender").charAt(0);
			String address = req.getParameter("address");
			
			Member member = new Member();
			
			
			member.setMemberName(inputName);
			member.setMemberId(inputId);
			member.setMemberPw(inputPw);
			member.setGender(gender);
			member.setMemberAdress(address);
			
			MemberService service = new MemberService();
			
			int result = service.signUp(member);
			
			HttpSession session = req.getSession();
			
			if(result>0) {
				session.setAttribute("message", "회원가입 완료!");
				resp.sendRedirect("/");
			
			}else {
				session.setAttribute("message", "회원가입 오류...");
				resp.sendRedirect(req.getHeader("referer"));
			}
			
		} catch(Exception e) {
			System.out.println("회원 가입중 예외 발생");
			e.printStackTrace();
		}
	}
}
