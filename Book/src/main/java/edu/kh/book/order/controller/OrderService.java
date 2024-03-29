package edu.kh.book.order.controller;

import java.sql.Connection;
import java.util.List;

import static edu.kh.book.common.JDBCTemplate.*;
import edu.kh.book.order.model.dao.OrderDAO;
import edu.kh.book.orders.dto.Orders;


public class OrderService {
	OrderDAO dao = new OrderDAO();

	public int purchase(int quantity, String bookNo, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.purchase(conn, quantity,bookNo,memberNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public List<Orders> selectAll(int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Orders> orderList = dao.selectAll(conn, memberNo);
		
		close(conn);
		
		return orderList;
	}

	public int delete(String memberNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.delete(conn, memberNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		return result;
	}
}
