package edu.kh.book.member.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.book.member.model.dto.Member;
import edu.kh.book.member.model.service.MemberService;
import edu.kh.book.order.controller.OrderService;
import edu.kh.book.orders.dto.Orders;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/purchase")
public class PurchaseController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		try {
			
			int quantity = (Integer.parseInt(req.getParameter("quantity")));
			String bookNo = req.getParameter("bookNo");
	
			HttpSession session = req.getSession();
			Member loginMember = (Member) session.getAttribute("loginMember");
						
			OrderService service = new OrderService();
			
			int result = service.purchase(quantity, bookNo, loginMember.getMemberNo());
			System.out.println(result);
			
			if(result > 0) {
				
				session.setAttribute("message", "주문 완료!");
				
				List<Orders> orderList = service.selectAll(loginMember.getMemberNo());
				session.setAttribute("orderList", orderList);
				
				req.getRequestDispatcher("/WEB-INF/views/purchase.jsp").forward(req, resp);
				
			} else {
				session.setAttribute("message", "주문 실패..");
				resp.sendRedirect(req.getHeader("referer"));
			}
			
		} catch(Exception e) {
			System.out.println("구매 중 오류 발생");
			e.printStackTrace();
		}

	}
	
}
