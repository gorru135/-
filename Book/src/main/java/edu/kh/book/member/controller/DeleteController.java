package edu.kh.book.member.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.book.member.model.dto.Member;
import edu.kh.book.order.controller.OrderService;
import edu.kh.book.orders.dto.Orders;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String memberNo = req.getParameter("memberNo");
			
			OrderService service = new OrderService();
			
			int result = service.delete(memberNo);
			
			HttpSession session =req.getSession();
			Orders orders = (Orders)session.getAttribute("orderList");
			
			if(result > 0) {
				List<Orders> orderList = service.selectAll(orders.getMemberNo());
				session.setAttribute("orderList", orderList);
				
			} else {
				session.setAttribute("message", "삭제실패");
				
			}
			resp.sendRedirect("/");
			
		} catch (Exception e) {
			System.out.println("삭제중 예외 발생");
			e.printStackTrace();
		}
	}
}
