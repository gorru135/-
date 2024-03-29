package edu.kh.book.order.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.book.member.model.dao.MemberDAO;
import edu.kh.book.orders.dto.Orders;

import static edu.kh.book.common.JDBCTemplate.*;
public class OrderDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public OrderDAO() {
		try {
			prop = new Properties();
			
			String filePath
				= MemberDAO.class.getResource("/edu/kh/book/sql/order-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public int purchase(Connection conn, int quantity, String bookNo, int memberNo) throws Exception {
		int result = 0;
		
		try {
			String sql=prop.getProperty("purchase");	
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bookNo);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, quantity);
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			
			close(pstmt);
		}
				
		return result;
	}

	public List<Orders> selectAll(Connection conn, int memberNo) throws Exception{
		List<Orders> orderList= new ArrayList<Orders>();
		
		try {
			String sql = prop.getProperty("selctpriceAll");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Orders orders = new Orders();
				
				orders.setMemberNo(rs.getInt("MEMBER_NO"));
				orders.setMemberName(rs.getString("MEMBER_NAME"));
				orders.setBookNo(rs.getInt("BOOK_NO"));
				orders.setBookTitle(rs.getString("BOOK_TITLE"));
				orders.setAddress(rs.getString("MEMBER_ADDRESS"));
				orders.setOrderDate(rs.getString("ORDER_DATE"));
				orders.setQuantity(rs.getInt("ORDER_QUANTITY"));
				orders.setStatus(rs.getString("STATUS"));
				orders.setPrice(rs.getInt("PRICE"));
				
				
				
				orderList.add(orders);	
				
			}
			
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return orderList;
	}

	public int delete(Connection conn, String memberNo) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("delete");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
}
