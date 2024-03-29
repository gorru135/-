package edu.kh.book.member.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.book.common.JDBCTemplate.*;
import edu.kh.book.member.model.dao.MemberDAO;
import edu.kh.book.member.model.dto.Member;
import edu.kh.book.orders.dto.Orders;

public class MemberService {
	
	MemberDAO dao = new MemberDAO();

	/** 로그인 서비스
	 * @param inputId
	 * @param inputPw
	 * @return loginMemger
	 * @throws Exception
	 */
	public Member login(String inputId, String inputPw) throws Exception{
		
		Connection conn = getConnection();
		
		
		Member loginMemger = dao.login(conn, inputId,inputPw);
		
		close(conn);
		
		return loginMemger;
	}

	/** 회원가입 서비스
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.signUp(conn,member);
		
		if(result > 0) commit(conn);
		
		else rollback(conn);
		
		return result;
	}



}
